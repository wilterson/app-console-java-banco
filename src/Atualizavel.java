import java.math.BigDecimal;

public interface Atualizavel {

    BigDecimal calculaJuros(BigDecimal inflacao);
    BigDecimal cobrarJuros(BigDecimal inflacao);
}
