package ru.jpa.tests.TestInheritancePerson.model;

import ru.helpclasses.Randomizer;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class PersonExtExt extends PersonExt {

    // Fields:
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.DATE)
    private Date joinDate;

    @Temporal(TemporalType.DATE)
    private Date lastLoginDate;

    @Basic
    private int loginCount;

    // Constructors:
    public PersonExtExt() {
        super();
        Date[] dates = Randomizer.randomDates(3);
        birthDate = dates[0];
        joinDate =  dates[1];
        lastLoginDate = dates[2];
        loginCount = Randomizer.randomInt(1, 100);
    }

    // Methods:
    @Override
    public String toString() {
        return " birthDate = " + birthDate +
                " joinDate = " + joinDate +
                " lastLoginDate = " + lastLoginDate +
                " loginCount = " + loginCount;
    }
}
