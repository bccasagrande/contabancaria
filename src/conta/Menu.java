package conta;

import java.util.Scanner;
import conta.util.Cores;

public class Menu {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
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
                case 1:
                    System.out.println("Criar Conta");
                    break;
                case 2:
                    System.out.println("Listar todas as Contas");
                    break;
                case 3:
                    System.out.println("Buscar Conta por Numero");
                    break;
                case 4:
                    System.out.println("Atualizar Dados da Conta");
                    break;
                case 5:
                    System.out.println("Apagar Conta");
                    break;
                case 6:
                    System.out.println("Sacar");
                    break;
                case 7:
                    System.out.println("Depositar");
                    break;
                case 8:
                    System.out.println("Transferir valores entre Contas");
                    break;
                default:
                    System.out.println(Cores.VERMELHO + 
                        "\nOpção Inválida!" + Cores.RESET);
                    break;
            }

        } while (opcao != 9);

    }
}