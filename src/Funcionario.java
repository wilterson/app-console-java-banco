import java.util.List;

public class Funcionario  extends Pessoa{

    Conta contaFuncionario;

    public Funcionario(int codigo, String nome, Data dtNasc) {
        super(codigo, nome, dtNasc);
    }

    public void setContaCentral(Conta contaFuncionario) {
        this.contaFuncionario = contaFuncionario;
    }
}
