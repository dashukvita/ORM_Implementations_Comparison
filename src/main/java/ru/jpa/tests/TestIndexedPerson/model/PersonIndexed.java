package ru.jpa.tests.TestIndexedPerson.model;


import ru.helpclasses.Randomizer;
import javax.persistence.*;
import java.util.Date;

@Entity
@TableGenerator(name="personIndexed", indexes = {
        @Index(columnList = "lastName", name = "person_lastName")
})
public class PersonIndexed {

    // Fields:
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String middleName;

    public Integer getId() {
        return id;
    }

    public PersonIndexed setId(Integer id) {
        this.id = id;
        return this;
    }

    @org.eclipse.persistence.annotations.Indexes //eclipse
    @org.apache.openjpa.persistence.jdbc.Index   //openjpa
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

    public String getFirstName() {
        return firstName;
    }

    public PersonIndexed setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    // Constructors:
    public PersonIndexed() {
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

    // Methods:
    @Override
    public String toString() {
        return "firstName = " + firstName +
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