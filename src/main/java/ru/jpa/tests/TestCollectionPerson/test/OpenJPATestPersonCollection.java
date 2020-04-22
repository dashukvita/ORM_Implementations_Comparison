package ru.jpa.tests.TestCollectionPerson.test;

import ru.jpa.tests.TestCollectionPerson.dao.PersonCollectionDaoOpenJPA;
import ru.jpa.tests.TestCollectionPerson.model.PersonCollection;
import ru.jpa.tests.imp.ITestOneToManyAndCollection;

import java.util.List;

public class OpenJPATestPersonCollection implements ITestOneToManyAndCollection {
    private PersonCollectionDaoOpenJPA dao;

    @Override
    public void createPerson(int num) {
        dao = new PersonCollectionDaoOpenJPA();
        dao.save(num);
    }

    @Override
    public List<PersonCollection> getAllPersons() {
        dao = new PersonCollectionDaoOpenJPA();
        List<PersonCollection> persons = dao.getAllPersons();
//        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao = new PersonCollectionDaoOpenJPA();
        List<PersonCollection> persons= dao.getAllPersons();
        persons.forEach(person -> dao.update(person));
    }

    @Override
    public void deletePerson() {
        dao = new PersonCollectionDaoOpenJPA();
        List<PersonCollection> persons= dao.getAllPersons();
        persons.forEach(person -> dao.delete(person));
    }
}
