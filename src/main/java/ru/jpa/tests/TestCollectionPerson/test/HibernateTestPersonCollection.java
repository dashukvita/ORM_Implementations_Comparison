package ru.jpa.tests.TestCollectionPerson.test;

import ru.jpa.tests.TestCollectionPerson.dao.PersonCollectionDaoHibernate;
import ru.jpa.tests.TestCollectionPerson.model.PersonCollection;
import ru.jpa.tests.imp.ITestOneToManyAndCollection;

import java.util.List;

public class HibernateTestPersonCollection implements ITestOneToManyAndCollection {
    private List<PersonCollection> persons;
    private List<PersonCollection> personsWithAddress;
    private PersonCollectionDaoHibernate dao;

    @Override
    public void createPerson(int num) {
        PersonCollection person = new PersonCollection();
        dao = new PersonCollectionDaoHibernate();
        dao.save(person);
    }

    @Override
    public List<PersonCollection> getAllPersons() {
        dao = new PersonCollectionDaoHibernate();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao = new PersonCollectionDaoHibernate();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        for (PersonCollection person : persons) {
            person.setFirstName("testName");
            dao.update(person);
        }
    }

    @Override
    public void deletePerson() {
        dao = new PersonCollectionDaoHibernate();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}
