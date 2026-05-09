package conta.controller;

import conta.model.Conta;
import conta.util.Cores;
import java.util.ArrayList;

public class ContaController {

    private ArrayList<Conta> listaContas = new ArrayList<Conta>();

    // Listar todas as contas
    public void listarTodas() {
        for (Conta conta : listaContas) {
            conta.visualizar();
        }
    }

    // Buscar conta por número
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

    // Cadastrar nova conta
    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println(Cores.VERDE +
            "\nConta cadastrada com sucesso!" + Cores.RESET);
    }

    // Atualizar conta existente
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

    // Deletar conta
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

    // Gerar número sequencial para nova conta
    public int gerarNumero() {
        return listaContas.size() + 1;
    }
}
