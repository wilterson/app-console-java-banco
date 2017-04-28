public class Pessoa {

    private int codigo;
    private String nome;
    private String cpf;
    private Data dtNasc;

    public Pessoa(int codigo, String nome, Data dtNasc) {
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.cpf = cpf;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Data getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Data dtNasc) {
        this.dtNasc = dtNasc;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
