import java.math.BigDecimal;

public class ContaPoupanca extends Conta implements Tarifavel, Atualizavel{

    private String tipo = "Poupança";

    public ContaPoupanca(int numero, Cliente titular) {
        super(numero, titular);
        setTipo(tipo);
    }

    @Override
    public BigDecimal calculaTarifa() {
        return new BigDecimal(0);
    }

    @Override
    public BigDecimal calculaJuros(BigDecimal inflacao) {
        BigDecimal valorJuros = new BigDecimal(0.05);
        return getSaldo().multiply(valorJuros);
    }

    @Override
    public BigDecimal cobrarTarifa() {
        return new BigDecimal(0);
    }

    @Override
    public BigDecimal cobrarJuros(BigDecimal inflacao) {
        setSaldo( getSaldo().add(calculaJuros(inflacao)));
        return calculaJuros(inflacao);
    }
}
