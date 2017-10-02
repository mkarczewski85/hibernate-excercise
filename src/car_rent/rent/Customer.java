package car_rent.rent;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "user")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String lastName;
    private LocalDateTime birthday;
    private LocalDateTime licenseCarDate;
    @Transient
    private Boolean isExperienced;
    private String phoneNumber;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "customer")
    Set<Rent> rentSet;

    public Customer() {
    }

    public Customer(String name, String lastName, LocalDateTime birthday, LocalDateTime licenseCarDate,
                    Boolean isExperienced, String phoneNumber) {

        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.licenseCarDate = licenseCarDate;
        this.isExperienced = isExperienced;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getLicenseCarDate() {
        return licenseCarDate;
    }

    public void setLicenseCarDate(LocalDateTime licenseCarDate) {
        this.licenseCarDate = licenseCarDate;
    }

    public Boolean getExperienced() {
        return isExperienced;
    }

    public void setExperienced(Boolean experienced) {
        isExperienced = experienced;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Rent> getRentSet() {
        return rentSet;
    }

    public void setRentSet(Set<Rent> rentSet) {
        this.rentSet = rentSet;
    }
}
