import java.math.BigDecimal;

public class ContaCorrente extends Conta implements Tarifavel{

    private String tipo = "Corrente";

    public ContaCorrente(int numero, Cliente titular) {
        super(numero, titular);
        setTipo(tipo);
    }

    public void sacar(BigDecimal valorSaque){
        int res = getSaldo().compareTo( valorSaque );
        if (res == 1){
            setSaldo( getSaldo().add( valorSaque ));
        }
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
    public BigDecimal getSaldo() {
        return super.getSaldo();
    }

    @Override
    public String getTitular() {
        return super.getTitular();
    }

    @Override
    public int getNumero() {
        return super.getNumero();
    }

    @Override
    public BigDecimal calculaTarifa() {
        BigDecimal valorTarifa = new BigDecimal(20);
        return valorTarifa;
    }

    @Override
    public BigDecimal cobrarTarifa() {
        setSaldo( getSaldo().subtract(calculaTarifa()));
        return calculaTarifa();
    }
}
