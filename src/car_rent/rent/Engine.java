package car_rent.rent;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Embeddable
public class Engine {

    private BigDecimal engineCapacity;
    @Enumerated (EnumType.STRING)
    private EngineType enginetype;
    private BigDecimal fuelConsumption;
    @Enumerated (EnumType.STRING)
    private GearBox gearBox;
    private Integer horsePower;
    private Integer torque;

    public Engine() {
    }

    public Engine(BigDecimal engineCapacity, EngineType enginetype, BigDecimal fuelConsumption, GearBox gearBox,
                  Integer horsePower, Integer torque) {
        this.engineCapacity = engineCapacity;
        this.enginetype = enginetype;
        this.fuelConsumption = fuelConsumption;
        this.gearBox = gearBox;
        this.horsePower = horsePower;
        this.torque = torque;
    }

    public BigDecimal getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(BigDecimal engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public EngineType getEnginetype() {
        return enginetype;
    }

    public void setEnginetype(EngineType enginetype) {
        this.enginetype = enginetype;
    }

    public BigDecimal getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(BigDecimal fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public GearBox getGearBox() {
        return gearBox;
    }

    public void setGearBox(GearBox gearBox) {
        this.gearBox = gearBox;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public Integer getTorque() {
        return torque;
    }

    public void setTorque(Integer torque) {
        this.torque = torque;
    }
}
