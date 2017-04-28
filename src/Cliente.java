import java.util.List;

public class Cliente extends Pessoa{
    protected int codigo;
    protected List<Conta> contas;
    protected Data nasc;
    protected String cpf;

    public Cliente(int codigo, String nome, Data dtNasc, String cpf) {
        super(codigo, nome, dtNasc);
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

    public boolean validaCpf(String cpf) {
        int cpfArray[] = new int[11];
        int pesoInicial = 2;

        int resto= 0;
        int resto2 = 0;
        int dv1 =0;
        int dv2 = 0;

        //Separa o cpf por digitos
        for (int i = 0; i < cpf.length(); i++){
            cpfArray[i] = Integer.valueOf(cpf.substring(i, i+1));
        }

        //Multiplica os digitos do cpf para o primeiro DV
        for(int i = 0; i < 9; i++){
            dv1 += (cpfArray[i] * pesoInicial);
            pesoInicial++;
        }

        resto = dv1 % 13;

        if (resto < 4)
            dv1 = 3;
        else
            dv1 = 13 - resto;

//        System.out.println("dv1: " + dv1);

        //Multiplica os digitos do cpf para o segundo DV
        pesoInicial = 2;

        for(int i = 0; i < 10; i++){
            dv2 += (cpfArray[i] * pesoInicial);
            pesoInicial++;
        }

        resto2 = dv2 % 13;

        if(resto2 < 4)
            dv2 = 3;
        else
            dv2 = 13 - resto;

//        System.out.println("DV2: " + dv2);

        //Verifica o digitos calculados com os digitados
        if ((cpfArray[9] == dv1) && (cpfArray[10] == dv2)){
            return true;
        }else{
            return false;
        }
    }
}
