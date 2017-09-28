package ogloszenia.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PozycjaZamowienia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ile")
    private int liczbaSztuk;

    @ManyToOne
    @JoinColumn
    private Zabawka zabawka;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Zamowienie zamowienie;

    public PozycjaZamowienia() {
    }

    public PozycjaZamowienia(int liczbaSztuk, Zabawka zabawka, Zamowienie zamowienie) {
        this.liczbaSztuk = liczbaSztuk;
        this.zabawka = zabawka;
        this. zamowienie = zamowienie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLiczbaSztuk() {
        return liczbaSztuk;
    }

    public void setLiczbaSztuk(int liczbaSztuk) {
        this.liczbaSztuk = liczbaSztuk;
    }

    public Zabawka getZabawka() {
        return zabawka;
    }

    public void setZabawka(Zabawka zabawka) {
        this.zabawka = zabawka;
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }
}
