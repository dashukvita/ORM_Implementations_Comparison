package ru.jpa.Tests.TestOneToManyPerson.model;

import ru.helpclasses.Randomizer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="personOtM")
public class PersonOneToMany implements Serializable {

    // Fields:

    private static final long serialVersionUID = -5170875020617735653L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="person_id", unique = true, nullable = false)
    private int person_id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;

    //    @OneToMany(mappedBy = "person", fetch=FetchType.EAGER)
    @OneToMany(mappedBy = "person", targetEntity = AddressOneToMany.class)
    private Collection<AddressOneToMany> addresses = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Temporal(TemporalType.DATE)
    private Date lastLoginDate;

    @Basic
    private int loginCount;

    // Constructors:

    public PersonOneToMany() {
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
    }


    public String getFirstName() {
        return firstName;
    }

    public PersonOneToMany setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonOneToMany setAddresses(Collection<AddressOneToMany> addresses) {
        this.addresses = addresses;
        return this;
    }

    public Collection<AddressOneToMany> getAddresses() {
        return addresses;
    }
//
//    public PersonOneToMany setAddresses(Collection<AddressOneToMany> addresses) {
//        this.addresses = addresses;
//        return this;
//    }

    public int getPerson_id() {
        return person_id;
    }

    public PersonOneToMany setPerson_id(int person_id) {
        this.person_id = person_id;
        return this;
    }

    // Methods:

    @Override
    public String toString() {
        return "person id = " + person_id +
                "firstName = " + firstName +
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

