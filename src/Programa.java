import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        int escolha;
        Scanner lerOpcao = new Scanner(System.in);

        //Inicia o Banco
        BancoLista bank = new BancoLista("Java Bank");
        bank.inicializa();


        do {
            Menu.limpaTela();
            //Mostra Menu e espera escolha do usuario
            Menu.mostrar();
            escolha = lerOpcao.nextInt();

            switch (escolha) {
                case 2:
                    bank.listarClientes();
                    Menu.continuar();
                    escolha = lerOpcao.nextInt();
                    break;

                case 3:
                    bank.listarContas();
                    Menu.continuar();
                    escolha = lerOpcao.nextInt();
                    break;

                case 4:
                    bank.verificarCpf();
                    Menu.continuar();
                    escolha = lerOpcao.nextInt();
                    break;

                case 5:
                    bank.cobrarTarifas();
                    Menu.continuar();
                    escolha = lerOpcao.nextInt();
                    break;

                case 6:
                    bank.verificarMontante();
                    Menu.continuar();
                    escolha = lerOpcao.nextInt();
                    break;

                case 7:
                    bank.cobrarJuros();
                    Menu.continuar();
                    escolha = lerOpcao.nextInt();
                    break;

                case 8:
                    bank.extrato();
                    Menu.continuar();
                    escolha = lerOpcao.nextInt();
                    break;

            }
        }while (escolha != 0 );
    }

    private void listarContas() {

    }
}
