package ru.jpa.Tests.TestOneToManyPerson.test;

import ru.jpa.Tests.TestCollectionPerson.dao.PersonCollectionDaoOpenJPA;
import ru.jpa.Tests.TestCollectionPerson.model.PersonCollection;
import ru.jpa.Tests.TestOneToManyPerson.dao.PersonOneToManyDaoOpenJPA;
import ru.jpa.Tests.TestOneToManyPerson.model.AddressOneToMany;
import ru.jpa.Tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.Tests.imp.ITestOneToManyAndCollection;

import java.util.List;

public class OpenJPATestPersonOneToMany implements ITestOneToManyAndCollection {
    private PersonOneToManyDaoOpenJPA dao;
    private List<PersonOneToMany> persons;

    @Override
    public void createPerson() {
        PersonOneToMany person = new PersonOneToMany();
        dao = new PersonOneToManyDaoOpenJPA();
        dao.save(person);
    }

    @Override
    public List<PersonOneToMany> getAllPersons() {
        dao = new PersonOneToManyDaoOpenJPA();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void deletePerson() {
        dao = new PersonOneToManyDaoOpenJPA();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }

    public void updatePerson() {
        dao = new PersonOneToManyDaoOpenJPA();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.update(person));
    }
}
