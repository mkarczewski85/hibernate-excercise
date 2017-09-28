package ogloszenia.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Atest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "atest")
    private Zabawka zabawka;

    private String numerAtestu;

    public Atest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Zabawka getZabawka() {
        return zabawka;
    }

    public void setZabawka(Zabawka zabawka) {
        this.zabawka = zabawka;
    }

    public String getNumerAtestu() {
        return numerAtestu;
    }

    public void setNumerAtestu(String numerAtestu) {
        this.numerAtestu = numerAtestu;
    }
}
