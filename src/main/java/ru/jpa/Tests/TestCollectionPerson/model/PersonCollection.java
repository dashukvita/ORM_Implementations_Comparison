package ru.jpa.Tests.TestCollectionPerson.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import ru.helpclasses.Randomizer;

/**
 * A simple entity class with a simple element collection.
 */

@Entity
@Table(name="personCol")
public class PersonCollection {

    // Fields:

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;

//    @ElementCollection(fetch=FetchType.EAGER) doesn't work with OpenJPA
    @ElementCollection
//    @JoinTable(name="addressCol",joinColumns=@JoinColumn(name="id")) doesn't work with EclipseLink
    @CollectionTable(name="addressCol", joinColumns=@JoinColumn(name="id"))
    private Collection<AddressCollection> addresses = new ArrayList<AddressCollection>();

    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Temporal(TemporalType.DATE)
    private Date lastLoginDate;

    @Basic
    private int loginCount;

    // Constructors:

    public PersonCollection() {
        firstName = Randomizer.randomFirstName();
        middleName = Randomizer.randomMiddleName();
        lastName = Randomizer.randomLastName();
        email = Randomizer.randomEmail();
        phone = Randomizer.randomPhone();
        Date[] dates = Randomizer.randomDates(3);
        birthDate = dates[0];
        joinDate =  dates[1];
        lastLoginDate = dates[2];
        loginCount = Randomizer.randomInt(1, 100);
        addresses.add(new AddressCollection());
        addresses.add(new AddressCollection());
    }

    public Collection<AddressCollection> getAddresses() {
        return addresses;
    }
    public void setAddresses(Collection<AddressCollection> addresses) {
        this.addresses = addresses;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonCollection setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    // Methods:

    @Override
    public String toString() {
        return "firstName = " + firstName +
                " middleName = " + middleName +
                " lastName = " + lastName +
                " email = " + email +
                " phone = " + phone +
                " birthDate = " + birthDate +
                " joinDate = " + joinDate +
                " lastLoginDate = " + lastLoginDate +
                " loginCount = " + loginCount;
    }
}
