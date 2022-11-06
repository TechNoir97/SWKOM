package at.fhtw.swen3.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity(name = "recipient")
@Table
public class RecipientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")
    private String name;

    @Pattern(regexp = "[A-Z][a-z-äöüÄÖÜßéÉèÈêÊ...]+ ([a-z]?\\d?\\/?)+")
    private String street;

    @Pattern(regexp = "A-\\d{4}")
    private String postalCode;

    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")
    private String city;
    @Column
    @Pattern(regexp = ".*((\\bAustria\\b)|(\\bÖsterreich\\b))$")
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
