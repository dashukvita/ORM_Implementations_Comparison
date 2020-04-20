package ru.jpa.tests.TestInheritancePerson.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractIdentifiableObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public AbstractIdentifiableObject setId(Integer id) {
        this.id = id;
        return this;
    }

    // Methods:
    @Override
    public String toString() {
        return "fid = " + id;
    }
}
