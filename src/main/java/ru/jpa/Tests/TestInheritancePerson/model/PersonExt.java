package ru.jpa.Tests.TestInheritancePerson.model;

import ru.helpclasses.Randomizer;
import javax.persistence.Entity;

@Entity
public class PersonExt extends PersonBase{

    // Fields:
    private String street;
    private String city;
    private String zip;
    private String country;
    private String phone;
    private String email;

    // Constructor:
    public PersonExt() {
        super();
        street = Randomizer.randomStreet();
        city = Randomizer.randomCity();
        zip = Randomizer.randomZip();
        country = Randomizer.randomCountry();
        phone = Randomizer.randomPhone();
        email = Randomizer.randomEmail();
    }

    // Methods:
    @Override
    public String toString() {
        return " street = " + street +
                " city = " + city +
                " zip = " + zip +
                " country = " + country +
                " phone = " + phone +
                " email = " + email;
    }
}
