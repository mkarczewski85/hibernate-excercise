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

    @ManyToMany
    @JoinTable(
            joinColumns=@JoinColumn(name = "option_id", referencedColumnName = "id"),
            inverseJoinColumns=@JoinColumn(name = "car_id")
    )
    Set<Car> carSet;




}
