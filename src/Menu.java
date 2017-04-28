import java.util.Scanner;

public class Menu {

    public static int escolha;
    public static Scanner interacao = new Scanner(System.in);

    public static void mostrar(){
        System.out.println("**************************");
        System.out.println("********** MENU **********");
        System.out.println("**************************\n");

        System.out.println("Escolha uma opção");

        System.out.println("2 - Listar clientes ativos");
        System.out.println("3 - Listar contas abertas");
        System.out.println("4 - Validar os CPFs dos clientes");
        System.out.println("5 - Cobrar tarifas de todas as contas");
        System.out.println("6 - Verifique o montante");
        System.out.println("7 - Atualizar o valor inflacionário das contas");
        System.out.println("8 - Visualização do extrato de uma conta");
        System.out.println("0 - Sair");

        System.out.print("\nDigite uma opção: ");
    }

    public static void limpaTela() {
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
    }

    public static void continuar() {
        System.out.print("\nDeseja voltar ao menu (1 - Sim / 0 - Não): ");
    }
}
