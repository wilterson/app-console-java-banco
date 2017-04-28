import java.math.BigDecimal;

public class ContaInvestimento extends Conta implements Tarifavel, Atualizavel {

    private String tipo = "Investimento";

    public ContaInvestimento(int numero, Cliente titular) {
        super(numero, titular);
        setTipo(tipo);
    }

    @Override
    public void setTipo(String tipo) {
        super.setTipo(tipo);
    }

    @Override
    public String getTipo() {
        return super.getTipo();
    }

    @Override
    public BigDecimal calculaTarifa() {
        BigDecimal porcentagemTarifa = new BigDecimal(0.02);
        return getSaldo().multiply(porcentagemTarifa);
    }

    @Override
    public BigDecimal cobrarTarifa() {
        setSaldo( getSaldo().subtract(calculaTarifa()));
        return calculaTarifa();
    }

    @Override
    public BigDecimal calculaJuros(BigDecimal inflacao) {
        BigDecimal porcentagemJuros = new BigDecimal(0.05);
        return (getSaldo().multiply(inflacao)).add(getSaldo().multiply(porcentagemJuros));
    }

    @Override
    public BigDecimal cobrarJuros(BigDecimal inflacao) {
        setSaldo( getSaldo().add(calculaJuros(inflacao)));
        return calculaJuros(inflacao);
    }
}
