package ru.jpa.Tests.TestInheritancePerson.model;

import ru.helpclasses.Randomizer;

import javax.persistence.*;

@Entity
@Table(name = "personBase")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonBase extends AbstractIdentifiableObject{

    private String firstName;
    private String middleName;
    private String lastName;

    // Constructors:
    public PersonBase() {
        firstName = Randomizer.randomFirstName();
        middleName = Randomizer.randomMiddleName();
        lastName = Randomizer.randomLastName();
    }

    // Methods:
    @Override
    public String toString() {
        return "firstName = " + firstName +
                " middleName = " + middleName +
                " lastName = " + lastName;
    }

    public void setFirstName(String testName) {
    }
}