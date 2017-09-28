package ogloszenia.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;

@Embeddable
public class Cena implements Serializable{

    private BigDecimal wartosc;
    private String symbolWaluty;

    public Cena() {
    }

    public Cena(BigDecimal wartosc, String symbolWaluty) {
        this.wartosc = wartosc;
        this.symbolWaluty = symbolWaluty;
    }

    public BigDecimal getWartosc() {
        return wartosc;
    }

    public void setWartosc(BigDecimal wartosc) {
        this.wartosc = wartosc;
    }

    public String getSymbolWaluty() {
        return symbolWaluty;
    }

    public void setSymbolWaluty(String symbolWaluty) {
        this.symbolWaluty = symbolWaluty;
    }
}
