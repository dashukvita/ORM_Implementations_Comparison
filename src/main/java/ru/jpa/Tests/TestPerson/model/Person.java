package ru.jpa.Tests.TestPerson.model;

import javax.persistence.*;
import java.util.Date;

import ru.helpclasses.Randomizer;

/**
 * A simple entity class with no inheritance/collections/indexes.
 */

@Entity
@Table(name="person")
public class Person{

    // Fields:

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String street;
    private String city;
    private String zip;
    private String country;
    private String phone;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Temporal(TemporalType.DATE)
    private Date lastLoginDate;

    @Basic
    private int loginCount;

    // Constructors:

    public Person() {
        firstName = Randomizer.randomFirstName();
        middleName = Randomizer.randomMiddleName();
        lastName = Randomizer.randomLastName();
        street = Randomizer.randomStreet();
        city = Randomizer.randomCity();
        zip = Randomizer.randomZip();
        country = Randomizer.randomCountry();
        phone = Randomizer.randomPhone();
        email = Randomizer.randomEmail();
        Date[] dates = Randomizer.randomDates(3);
        birthDate = dates[0];
        joinDate =  dates[1];
        lastLoginDate = dates[2];
        loginCount = Randomizer.randomInt(1, 100);
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    // Methods:

    @Override
    public String toString() {
        return "id = " + id +
                "firstName = " + firstName +
                " middleName = " + middleName +
                " lastName = " + lastName +
                " street = " + street +
                " city = " + city +
                " zip = " + zip +
                " country = " + country +
                " phone = " + phone +
                " email = " + email +
                " birthDate = " + birthDate +
                " joinDate = " + joinDate +
                " lastLoginDate = " + lastLoginDate +
                " loginCount = " + loginCount;
    }
}
