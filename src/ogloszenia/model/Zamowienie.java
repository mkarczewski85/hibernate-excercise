package ogloszenia.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Zamowienie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Long liczbaProduktow;

    private LocalDate dataZamowienia;

    private String email;

    @OneToMany(mappedBy = "zamowienie")
    private Set<PozycjaZamowienia> pozycjaZamowieniaSet;

    public Zamowienie() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getLiczbaProduktow() {
        return liczbaProduktow;
    }

    public void setLiczbaProduktow(Long liczbaProduktow) {
        this.liczbaProduktow = liczbaProduktow;
    }

    public LocalDate getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(LocalDate dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<PozycjaZamowienia> getPozycjaZamowieniaSet() {
        return pozycjaZamowieniaSet;
    }

    public void setPozycjaZamowieniaSet(Set<PozycjaZamowienia> pozycjaZamowieniaSet) {
        this.pozycjaZamowieniaSet = pozycjaZamowieniaSet;
    }
}
