package entity.passportOneToOne;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passportId;

    @Column(name = "passport_number")
    private String passportNumber;

    @OneToOne(mappedBy = "passport") //Customer is the owner and Passport is inverse end,
    //Passport is not responsible for OneToOne relationship
    private Customer customer;

    public Passport() {
    }

    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return passportId.equals(passport.passportId) &&
                passportNumber.equals(passport.passportNumber) &&
                customer.equals(passport.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportId, passportNumber, customer);
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passportId=" + passportId +
                ", passportNumber='" + passportNumber + '\'' +
                ", customer=" + customer +
                '}';
    }
}
