package ogloszenia.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

@Entity
@Table(name = "zabawki")
public class Zabawka implements Serializable {

    public Zabawka() {
    }

    public Zabawka(String nazwa, Cena cena, Kolor kolor, int stanMagazynu, boolean czyPromocja, Material material,
                   LocalDateTime dataProdukcji, byte[] image, byte[] document) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.kolor = kolor;
        this.stanMagazynu = stanMagazynu;
        this.czyPromocja = czyPromocja;
        this.material = material;
        this.dataProdukcji = dataProdukcji;
        this.image = image;
        this.document = document;
    }

    public Zabawka(String nazwa, int stanMagazynu) {
        this.nazwa = nazwa;
        this.stanMagazynu = stanMagazynu;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    private byte[] document;

    @Lob
    private byte[] image;

    private String nazwa;

    @Embedded
    private Cena cena;

    @Enumerated(EnumType.STRING)
    private Kolor kolor;

    private int stanMagazynu;

    private boolean czyPromocja;

    @Enumerated(EnumType.STRING)
    private Material material;

    private LocalDateTime dataProdukcji;

    @Transient
    private Cena cenaProdukcji;

    @OneToMany(mappedBy = "zabawka")
    private Set<PozycjaZamowienia> pozycjaZamowieniaSet;

    @OneToOne
    private Atest atest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Cena getCena() {
        return cena;
    }

    public void setCena(Cena cena) {
        this.cena = cena;
    }

    public Kolor getKolor() {
        return kolor;
    }

    public void setKolor(Kolor kolor) {
        this.kolor = kolor;
    }

    public int getStanMagazynu() {
        return stanMagazynu;
    }

    public void setStanMagazynu(int stanMagazynu) {
        this.stanMagazynu = stanMagazynu;
    }

    public boolean isCzyPromocja() {
        return czyPromocja;
    }

    public void setCzyPromocja(boolean czyPromocja) {
        this.czyPromocja = czyPromocja;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public LocalDateTime getDataProdukcji() {
        return dataProdukcji;
    }

    public void setDataProdukcji(LocalDateTime dataProdukcji) {
        this.dataProdukcji = dataProdukcji;
    }

    public Cena getCenaProdukcji() {
        return cenaProdukcji;
    }

    public void setCenaProdukcji(Cena cenaProdukcji) {
        this.cenaProdukcji = cenaProdukcji;
    }

    public Set<PozycjaZamowienia> getPozycjaZamowieniaSet() {
        return pozycjaZamowieniaSet;
    }

    public void setPozycjaZamowieniaSet(Set<PozycjaZamowienia> pozycjaZamowieniaSet) {
        this.pozycjaZamowieniaSet = pozycjaZamowieniaSet;
    }

    public Atest getAtest() {
        return atest;
    }

    public void setAtest(Atest atest) {
        this.atest = atest;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Zabawka{" +
                "id=" + id +
                ", document=" + Arrays.toString(document) +
                ", image=" + Arrays.toString(image) +
                ", nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", kolor=" + kolor +
                ", stanMagazynu=" + stanMagazynu +
                ", czyPromocja=" + czyPromocja +
                ", material=" + material +
                ", dataProdukcji=" + dataProdukcji +
                ", cenaProdukcji=" + cenaProdukcji +
                ", pozycjaZamowieniaSet=" + pozycjaZamowieniaSet +
                ", atest=" + atest +
                '}';
    }
}
