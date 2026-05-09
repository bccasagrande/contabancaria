package conta.controller;

import conta.model.Conta;
import conta.util.Cores;
import java.util.ArrayList;

public class ContaController {

    private ArrayList<Conta> listaContas = new ArrayList<Conta>();

    public void listarTodas() {
        for (Conta conta : listaContas) {
            conta.visualizar();
        }
    }

    public Conta buscarNaCollection(int numero) {
        for (Conta conta : listaContas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public void procurarPorNumero(int numero) {
        Conta conta = buscarNaCollection(numero);
        if (conta != null) {
            conta.visualizar();
        } else {
            System.out.println(Cores.VERMELHO +
                "\nConta número " + numero + " não encontrada!" + Cores.RESET);
        }
    }

    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println(Cores.VERDE +
            "\nConta cadastrada com sucesso!" + Cores.RESET);
    }

    public void atualizar(Conta conta) {
        Conta contaAtualizar = buscarNaCollection(conta.getNumero());
        if (contaAtualizar != null) {
            listaContas.set(listaContas.indexOf(contaAtualizar), conta);
            System.out.println(Cores.VERDE +
                "\nConta atualizada com sucesso!" + Cores.RESET);
        } else {
            System.out.println(Cores.VERMELHO +
                "\nConta não encontrada!" + Cores.RESET);
        }
    }

    public void deletar(int numero) {
        Conta contaDeletar = buscarNaCollection(numero);
        if (contaDeletar != null) {
            listaContas.remove(contaDeletar);
            System.out.println(Cores.VERDE +
                "\nConta deletada com sucesso!" + Cores.RESET);
        } else {
            System.out.println(Cores.VERMELHO +
                "\nConta não encontrada!" + Cores.RESET);
        }
    }

    public int gerarNumero() {
        return listaContas.size() + 1;
    }

    public void sacar(int numero, float valor) {
        Conta conta = buscarNaCollection(numero);
        if (conta != null) {
            if (conta.sacar(valor)) {
                System.out.println(Cores.VERDE +
                    "\nSaque realizado com sucesso!" + Cores.RESET);
            }
        } else {
            System.out.println(Cores.VERMELHO +
                "\nConta número " + numero + " não encontrada!" + Cores.RESET);
        }
    }

    public void depositar(int numero, float valor) {
        Conta conta = buscarNaCollection(numero);
        if (conta != null) {
            conta.depositar(valor);
            System.out.println(Cores.VERDE +
                "\nDepósito realizado com sucesso!" + Cores.RESET);
        } else {
            System.out.println(Cores.VERMELHO +
                "\nConta número " + numero + " não encontrada!" + Cores.RESET);
        }
    }

    public void transferir(int numeroOrigem, int numeroDestino, float valor) {
        Conta contaOrigem  = buscarNaCollection(numeroOrigem);
        Conta contaDestino = buscarNaCollection(numeroDestino);

        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.sacar(valor)) {
                contaDestino.depositar(valor);
                System.out.println(Cores.VERDE +
                    "\nTransferência realizada com sucesso!" + Cores.RESET);
            }
        } else {
            System.out.println(Cores.VERMELHO +
                "\nConta de origem ou destino não encontrada!" + Cores.RESET);
        }
    }
}
