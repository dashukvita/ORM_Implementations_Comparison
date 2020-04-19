package ru.jpa.Tests.TestCollectionPerson.test;

import ru.jpa.Tests.TestCollectionPerson.dao.PersonCollectionDaoOpenJPA;
import ru.jpa.Tests.TestCollectionPerson.model.AddressCollection;
import ru.jpa.Tests.TestCollectionPerson.model.PersonCollection;
import ru.jpa.Tests.TestOneToManyPerson.model.AddressOneToMany;
import ru.jpa.Tests.imp.ITestOneToManyAndCollection;
import ru.jpa.utils.OpenJPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class OpenJPATestPersonCollection implements ITestOneToManyAndCollection {
    private List<PersonCollection> persons;
    private List<PersonCollection> personsWithAddress;
    private PersonCollectionDaoOpenJPA dao;

    @Override
    public void createPerson() {
        PersonCollection person = new PersonCollection();
        dao = new PersonCollectionDaoOpenJPA();
        dao.save(person);
    }

    @Override
    public List<PersonCollection> getAllPersons() {
        dao = new PersonCollectionDaoOpenJPA();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao = new PersonCollectionDaoOpenJPA();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.update(person));
    }

    @Override
    public void deletePerson() {
        dao = new PersonCollectionDaoOpenJPA();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}
