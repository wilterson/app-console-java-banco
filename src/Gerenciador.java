import java.math.BigDecimal;

public class Gerenciador {

    private int numeroConta;
    private String tipoTransacao;
    private String descricaoTransacao;
    private BigDecimal valorTransacao;

    public Gerenciador(int num, String tipo, String desc, BigDecimal valor) {
        this.numeroConta = num;
        this.tipoTransacao = tipo;
        this.descricaoTransacao = desc;
        this.valorTransacao = valor;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public String getDescricaoTransacao() {
        return descricaoTransacao;
    }

    public void setDescricaoTransacao(String descricaoTransacao) {
        this.descricaoTransacao = descricaoTransacao;
    }

    public BigDecimal getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(BigDecimal valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public void registraOperacao(int num, String tipo, String desc, BigDecimal valor){
        setNumeroConta(num);
        setTipoTransacao(tipo);
        setDescricaoTransacao(desc);
        setValorTransacao(valor);
    }
}
