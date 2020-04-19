package ru.jpa.tests.TestCollectionPerson.test;

import ru.jpa.tests.TestCollectionPerson.dao.PersonCollectionDaoEclipseLink;
import ru.jpa.tests.TestCollectionPerson.model.PersonCollection;
import ru.jpa.tests.imp.ITestOneToManyAndCollection;

import java.util.List;

public class EclipseLinkTestPersonCollection implements ITestOneToManyAndCollection {
    private List<PersonCollection> persons;
    private List<PersonCollection> personsWithAddress;
    private PersonCollectionDaoEclipseLink dao;

    @Override
    public void createPerson(int num) {

        PersonCollection person = new PersonCollection();
        dao = new PersonCollectionDaoEclipseLink();
        dao.save(person);
    }

    @Override
    public List<PersonCollection> getAllPersons() {
        dao = new PersonCollectionDaoEclipseLink();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao = new PersonCollectionDaoEclipseLink();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.update(person));
    }

    @Override
    public void deletePerson() {
        dao = new PersonCollectionDaoEclipseLink();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}
