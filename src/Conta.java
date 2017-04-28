import java.math.BigDecimal;

abstract class Conta implements Atualizavel, Tarifavel{

    //Atributos
    private int numero;
    private BigDecimal saldo;
    private Cliente titular;
    private String tipo;

    public Conta(int numero, Cliente titular) {
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public String getTitular() {
        return this.titular.getNome();
    }

    public Cliente getCliente() {
        return this.titular;
    }

    public int getNumero() {
        return this.numero;
    }

    protected void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void deposito(BigDecimal valorDeposito) {
        this.setSaldo(valorDeposito);
    }

    public void sacar(BigDecimal valorSaque) {
        this.setSaldo(getSaldo().subtract(valorSaque));
    }

    public BigDecimal cobrarTarifa() {
        setSaldo( getSaldo().subtract(cobrarTarifa()));
        return calculaTarifa();
    }

    public BigDecimal cobrarJuros(BigDecimal inflacao){
        return new BigDecimal(0);
    }

    public BigDecimal calculaJuros(BigDecimal inflacao){
        return new BigDecimal(0);
    }
}
