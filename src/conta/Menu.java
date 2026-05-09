package conta;

import java.util.Scanner;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

    public static Scanner leia = new Scanner(System.in);
    static ContaController contaController = new ContaController();

    public static void main(String[] args) {

        int opcao;

        System.out.println(Cores.AZUL_NEGRITO +
            "*****************************************************" + Cores.RESET);
        System.out.println(Cores.AZUL_NEGRITO +
            "                  BANCO DA GENERATION               " + Cores.RESET);
        System.out.println(Cores.AZUL_NEGRITO +
            "*****************************************************" + Cores.RESET);

        do {
            System.out.println(Cores.VERDE_NEGRITO + "\n\nMenu Principal:" + Cores.RESET);
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Listar todas as Contas");
            System.out.println("3 - Buscar Conta por Numero");
            System.out.println("4 - Atualizar Dados da Conta");
            System.out.println("5 - Apagar Conta");
            System.out.println("6 - Sacar");
            System.out.println("7 - Depositar");
            System.out.println("8 - Transferir valores entre Contas");
            System.out.println(Cores.VERMELHO + "9 - Sair" + Cores.RESET);
            System.out.println(Cores.AMARELO_NEGRITO +
                "\nEntre com a opção desejada: " + Cores.RESET);

            opcao = leia.nextInt();

            if (opcao == 9) {
                System.out.println(Cores.VERDE_NEGRITO +
                    "\nBanco da Generation - Até logo!\n" + Cores.RESET);
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: contaController.listarTodas(); break;
                case 3: buscarPorNumero(); break;
                case 4: atualizar(); break;
                case 5: deletar(); break;
                case 6: sacar(); break;
                case 7: depositar(); break;
                case 8: transferir(); break;
                default:
                    System.out.println(Cores.VERMELHO + "\nOpção Inválida!" + Cores.RESET);
                    break;
            }

        } while (opcao != 9);
    }

    public static void cadastrar() {
        System.out.println("\nTipo da Conta (1-Corrente / 2-Poupança): ");
        int tipo = leia.nextInt();

        System.out.println("Número da Agência: ");
        int agencia = leia.nextInt();

        System.out.println("Titular da Conta: ");
        String titular = leia.next();

        System.out.println("Saldo inicial (R$): ");
        float saldo = leia.nextFloat();

        if (tipo == 1) {
            System.out.println("Limite de Crédito (R$): ");
            float limite = leia.nextFloat();
            contaController.cadastrar(
                new ContaCorrente(contaController.gerarNumero(), agencia, titular, saldo, limite)
            );
        } else {
            System.out.println("Dia do Aniversário da Conta: ");
            int aniversario = leia.nextInt();
            contaController.cadastrar(
                new ContaPoupanca(contaController.gerarNumero(), agencia, titular, saldo, aniversario)
            );
        }
    }

    public static void buscarPorNumero() {
        System.out.println("\nNúmero da Conta: ");
        int numero = leia.nextInt();
        contaController.procurarPorNumero(numero);
    }

    public static void atualizar() {
        System.out.println("\nNúmero da Conta a atualizar: ");
        int numero = leia.nextInt();

        System.out.println("Tipo da Conta (1-Corrente / 2-Poupança): ");
        int tipo = leia.nextInt();

        System.out.println("Número da Agência: ");
        int agencia = leia.nextInt();

        System.out.println("Titular da Conta: ");
        String titular = leia.next();

        System.out.println("Saldo (R$): ");
        float saldo = leia.nextFloat();

        if (tipo == 1) {
            System.out.println("Limite de Crédito (R$): ");
            float limite = leia.nextFloat();
            contaController.atualizar(
                new ContaCorrente(numero, agencia, titular, saldo, limite)
            );
        } else {
            System.out.println("Dia do Aniversário da Conta: ");
            int aniversario = leia.nextInt();
            contaController.atualizar(
                new ContaPoupanca(numero, agencia, titular, saldo, aniversario)
            );
        }
    }

    public static void deletar() {
        System.out.println("\nNúmero da Conta a deletar: ");
        int numero = leia.nextInt();
        contaController.deletar(numero);
    }

    public static void sacar() {
        System.out.println("\nNúmero da Conta: ");
        int numero = leia.nextInt();
        System.out.println("Valor do Saque (R$): ");
        float valor = leia.nextFloat();
        contaController.sacar(numero, valor);
    }

    public static void depositar() {
        System.out.println("\nNúmero da Conta: ");
        int numero = leia.nextInt();
        System.out.println("Valor do Depósito (R$): ");
        float valor = leia.nextFloat();
        contaController.depositar(numero, valor);
    }

    public static void transferir() {
        System.out.println("\nNúmero da Conta de Origem: ");
        int numeroOrigem = leia.nextInt();
        System.out.println("Número da Conta de Destino: ");
        int numeroDestino = leia.nextInt();
        System.out.println("Valor da Transferência (R$): ");
        float valor = leia.nextFloat();
        contaController.transferir(numeroOrigem, numeroDestino, valor);
    }
}
