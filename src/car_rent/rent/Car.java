package car_rent.rent;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    @Enumerated (EnumType.STRING)
    private Make make;
    private int capacity;
    @Embedded
    private Engine engine;
    @Enumerated (EnumType.STRING)
    private CarSegment carSegment;
    @Enumerated (EnumType.STRING)
    private Color color;
    private BigDecimal basePrice;
    private BigDecimal insuranceCost;

    @ManyToMany (mappedBy = "carSet")
    private Set<Option> optionSet;

    @OneToMany (mappedBy = "car")
    private Set<Rent> rentSet;

    public Car() {
    }

    public Car(String model, Make make, int capacity, Engine engine, CarSegment carSegment, Color color,
               BigDecimal basePrice, BigDecimal insuranceCost) {
        this.model = model;
        this.make = make;
        this.capacity = capacity;
        this.engine = engine;
        this.carSegment = carSegment;
        this.color = color;
        this.basePrice = basePrice;
        this.insuranceCost = insuranceCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public CarSegment getCarSegment() {
        return carSegment;
    }

    public void setCarSegment(CarSegment carSegment) {
        this.carSegment = carSegment;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(BigDecimal insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public Set<Option> getOptionSet() {
        return optionSet;
    }

    public void setOptionSet(Set<Option> optionSet) {
        this.optionSet = optionSet;
    }

    public Set<Rent> getRentSet() {
        return rentSet;
    }

    public void setRentSet(Set<Rent> rentSet) {
        this.rentSet = rentSet;
    }
}
