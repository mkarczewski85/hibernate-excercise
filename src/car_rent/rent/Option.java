package car_rent.rent;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "options")
@Getter
@Setter
public class Option {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "optionSet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Car> carSet;


    public Option(String name) {
        this.name = name;
    }

    public Option() {
    }
}
