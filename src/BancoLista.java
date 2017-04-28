import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BancoLista implements Banco {

    private List<Conta> contas;
    private List<Cliente> clientes;
    private String nome;
    private Conta contaCentralBanco;
    private List<Gerenciador> logBanco;

    // TODO: CONTA CENTRAL DO BANCO
    public BancoLista(String nome) {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.nome = nome;
        this.logBanco = new ArrayList<>();

//        this.contaCentralBanco = new
    }

    /**
     * Inicializa alguns clientes no banco para testes.
     * */
    public void inicializa(){
        //Clientes
        Cliente cli1 = new Cliente(1, "Frank Castle", new Data(12, 05, 1986), "05430939983");
        Cliente cli2 = new Cliente(2, "Matt Murdock", new Data(5, 4, 1995), "02245678951");
        Cliente cli3 = new Cliente(3, "Jessica Jones", new Data(1, 12, 1946), "06340950943");
        Cliente cli4 = new Cliente(4, "Elektra Natchios", new Data(14, 7, 1992), "05450987451");
        Cliente cli5 = new Cliente(5, "Wilson Fisk", new Data(25, 1, 1999), "54012055819");

        clientes.add(cli1);
        clientes.add(cli2);
        clientes.add(cli3);
        clientes.add(cli4);
        clientes.add(cli5);

        //Conta Corrente
        Conta cc1 = new ContaCorrente(1, cli1);
        Conta cc2 = new ContaCorrente(2, cli2);
        Conta cc3 = new ContaCorrente(3, cli3);
        Conta cc4 = new ContaCorrente(4, cli4);
        Conta cc5 = new ContaCorrente(5, cli5);

        cc1.deposito(new BigDecimal(1000));
        logBanco.add(new Gerenciador(cc1.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(1000)));

        cc2.deposito(new BigDecimal(1500));
        logBanco.add(new Gerenciador(cc2.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(1500)));

        cc3.deposito(new BigDecimal(2500));
        logBanco.add(new Gerenciador(cc3.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(2500)));

        cc4.deposito(new BigDecimal(1125));
        logBanco.add(new Gerenciador(cc4.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(1125)));

        cc5.deposito(new BigDecimal(150));
        logBanco.add(new Gerenciador(cc5.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(150)));

        this.adiciona(cc1);
        this.adiciona(cc2);
        this.adiciona(cc3);
        this.adiciona(cc4);
        this.adiciona(cc5);

        //Conta Poupanca
        Conta cp1 = new ContaPoupanca(6, cli1);
        Conta cp2 = new ContaPoupanca(7, cli2);
        Conta cp3 = new ContaPoupanca(8, cli3);
        Conta cp4 = new ContaPoupanca(9, cli4);
        Conta cp5 = new ContaPoupanca(10,cli5);

        cp1.deposito(new BigDecimal(100));
        logBanco.add(new Gerenciador(cp1.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(100)));

        cp2.deposito(new BigDecimal(150));
        logBanco.add(new Gerenciador(cp2.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(150)));

        cp3.deposito(new BigDecimal(250));
        logBanco.add(new Gerenciador(cp3.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(250)));

        cp4.deposito(new BigDecimal(1125));
        logBanco.add(new Gerenciador(cp4.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(1125)));

        cp5.deposito(new BigDecimal(2500));
        logBanco.add(new Gerenciador(cp5.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(2500)));

        this.adiciona(cp1);
        this.adiciona(cp2);
        this.adiciona(cp3);
        this.adiciona(cp4);
        this.adiciona(cp5);

        //Conta Investimento
        Conta ci1 = new ContaInvestimento(11, cli1);
        Conta ci2 = new ContaInvestimento(12, cli2);
        Conta ci3 = new ContaInvestimento(13, cli3);
        Conta ci4 = new ContaInvestimento(14, cli4);
        Conta ci5 = new ContaInvestimento(15, cli5);

        ci1.deposito(new BigDecimal(5000));
        logBanco.add(new Gerenciador(ci1.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(5000)));

        ci2.deposito(new BigDecimal(50));
        logBanco.add(new Gerenciador(ci2.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(50)));

        ci3.deposito(new BigDecimal(100));
        logBanco.add(new Gerenciador(ci3.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(100)));

        ci4.deposito(new BigDecimal(2500));
        logBanco.add(new Gerenciador(ci4.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(2500)));

        ci5.deposito(new BigDecimal(250));
        logBanco.add(new Gerenciador(ci5.getNumero(), "Crédito", "Depósito inicial", new BigDecimal(250)));

        this.adiciona(ci1);
        this.adiciona(ci2);
        this.adiciona(ci3);
        this.adiciona(ci4);
        this.adiciona(ci5);
    }

    /**
     * Adiciona novas contas ao banco
     * */
    public void adiciona(Conta c) {
        contas.add(c);
    }

    /**
     * Remove a conta do Banco
     * */
    public void remove(int n) {
        contas.remove(n);
    }

    /**
     * Lista todas as contas ativas no banco
     * */
    public void listarContas() {
        Menu.limpaTela();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        System.out.println("Banco: " + this.nome);
        for (int i = 0; i < contas.size(); i++) {
            if(i == 0){
                System.out.format("%-28s | %-25s | %-32s | %-25s\n", "Numero Conta", "Titular", "Saldo", "Tipo");
            }

            System.out.format("%-28s | %-25s | %-32s | %-25s\n",
                    contas.get(i).getNumero(),
                    contas.get(i).getTitular(),
                    formatter.format(contas.get(i).getSaldo()),
                    contas.get(i).getTipo()
            );
        }
    }

    /**
     * Lista todos os clientes ativos do banco
     * */
    public void listarClientes() {
        Menu.limpaTela();

        for(int i = 0; i < clientes.size(); i++){
            if(i == 0){
                System.out.format("%-25s%-25s\n", "Codigo do Cliente", "Nome do Cliente");
            }

            System.out.format("%-25s%-25s\n", clientes.get(i).getCodigo(), clientes.get(i).getNome());
        }

    }

    /**
     * Cobra tarifa das contas onde é aplicável a cobrança
     * */
    @Override
    public void cobrarTarifas(){
        Menu.limpaTela();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        for (int i = 0; i < contas.size(); i++) {
            if(i == 0){
                System.out.format("%-20s | %-18s | %-20s | %-15s | %-15s | %-15s\n", "Numero Conta", "Tipo", "Titular", "Saldo Anterior", "Tarifa Cobrada", "Saldo Atual");
            }

            BigDecimal tarifaCobrada = contas.get(i).cobrarTarifa();

            System.out.format("%-20s | %-18s | %-20s | %-15s | %-15s | %-15s\n", contas.get(i).getNumero(),
                    contas.get(i).getTipo(),
                    contas.get(i).getTitular(),
                    formatter.format(contas.get(i).getSaldo()),
                    formatter.format(contas.get(i).cobrarTarifa()),
                    formatter.format(contas.get(i).getSaldo())
            );

            logBanco.add(new Gerenciador(contas.get(i).getNumero(), "Débito", "Cobrança de tarifa", tarifaCobrada));

//            contaCentralBanco.setSaldo( contaCentralBanco.getSaldo() + contas.get(i).cobrarTarifa() );
        }
    }

    /**
     * Atualiza as contas com os juros da correção inflacionária do período
     * */
    @Override
    public void cobrarJuros(){
        Menu.limpaTela();

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        BigDecimal inflacao;
        Scanner inf = new Scanner(System.in);

        System.out.print("Digite a inflacao do período (%): ");
        inflacao = inf.nextBigDecimal();

        final BigDecimal valorInflacao = inflacao.divide(new BigDecimal(100));

        for (int i = 0; i < contas.size(); i++) {
            BigDecimal valorJuros = contas.get(i).cobrarJuros(valorInflacao);

            if(i == 0){
                System.out.format("%-20s | %-18s | %-20s | %-15s | %-13s | %-15s\n", "Numero Conta", "Tipo", "Titular", "Saldo Anterior", "Juros", "Saldo Atual");
            }

            System.out.format("%-20s | %-18s | %-20s | %-15s | %-13s | %-15s\n",
                    contas.get(i).getNumero(),
                    contas.get(i).getTipo(),
                    contas.get(i).getTitular(),
                    formatter.format(contas.get(i).getSaldo()),
                    formatter.format(contas.get(i).cobrarJuros(valorInflacao)),
                    formatter.format(contas.get(i).getSaldo())
            );

            logBanco.add(new Gerenciador(contas.get(i).getNumero(), "Crédito", "Atualização inflacionária", valorJuros));
        }
    }

    /**
     * Verifica o montante aplicado no banco pelos clientes
     * */
    @Override
    public void verificarMontante() {
        Menu.limpaTela();

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        BigDecimal montante = new BigDecimal(0);

        for (int i = 0; i < contas.size(); i++) {
            if(i == 0){
                System.out.format("%-20s | %-18s | %-20s | %-15s\n", "Numero Conta", "Tipo", "Titular", "Saldo");
            }

            if((contas.get(i).getTipo().equals("Investimento")) || (contas.get(i).getTipo().equals("Poupança"))) {
                montante = montante.add(contas.get(i).getSaldo());

                System.out.format("%-20s | %-18s | %-20s | %-15s\n",
                        contas.get(i).getNumero(),
                        contas.get(i).getTipo(),
                        contas.get(i).getTitular(),
                        formatter.format(contas.get(i).getSaldo())
                );
            }
        }

        System.out.println("Montante: " + formatter.format(montante));
    }

    public void extrato(){
        Menu.limpaTela();

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        int codigoConta;
        Scanner esc = new Scanner(System.in);

        System.out.print("Digite o número da conta: ");
        codigoConta = esc.nextInt();

        for (int i = 0; i < logBanco.size(); i++){
            Gerenciador operacao = logBanco.get(i);

            if(operacao.getNumeroConta() == codigoConta){

                System.out.format("%-5s | %-12s | %-25s | %-15s\n",
                        operacao.getNumeroConta(),
                        operacao.getTipoTransacao(),
                        operacao.getDescricaoTransacao(),
                        formatter.format(operacao.getValorTransacao())
                );
            }
        }


        for (int i = 0; i < contas.size(); i++) {
            if ( contas.get(i).getNumero() == codigoConta ) {
                System.out.printf( "Saldo: %-6s %n", formatter.format(contas.get(i).getSaldo()));
                break;
            }
        }
    }

    public void verificarCpf(){
        Menu.limpaTela();

        for(int i = 0; i < clientes.size(); i++){

            if(i == 0){
                System.out.format("%-25s | %-25s | %-12s | %-15s\n", "Codigo do Cliente", "Nome do Cliente", "CPF", "Status");
            }
            String cpf = clientes.get(i).getCpf();
            boolean statusCpf = clientes.get(i).validaCpf(cpf);

            System.out.format("%-25s | %-25s | %-12s | %-15s\n",
                clientes.get(i).getCodigo(),
                clientes.get(i).getNome(),
                cpf,
                (statusCpf ? "CPF Válido" : "CPF Inválido")
            );

        }

    }
}