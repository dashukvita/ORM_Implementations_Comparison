package ru.jpa.tests.TestCollectionPerson.test;

import ru.jpa.tests.TestCollectionPerson.dao.PersonCollectionDaoHibernate;
import ru.jpa.tests.TestCollectionPerson.model.PersonCollection;
import ru.jpa.tests.imp.ITestOneToManyAndCollection;

import java.util.List;

public class HibernateTestPersonCollection implements ITestOneToManyAndCollection {
    private PersonCollectionDaoHibernate dao;

    @Override
    public void createPerson(int num) {
        dao = new PersonCollectionDaoHibernate();
        dao.save(num);
    }

    @Override
    public List<PersonCollection> getAllPersons() {
        dao = new PersonCollectionDaoHibernate();
        List<PersonCollection> persons= dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao = new PersonCollectionDaoHibernate();
        List<PersonCollection> persons= dao.getAllPersons();
        for (PersonCollection person : persons) {
            person.setFirstName("testName");
            dao.update(person);
        }
    }

    @Override
    public void deletePerson() {
        dao = new PersonCollectionDaoHibernate();
        List<PersonCollection> persons= dao.getAllPersons();
        persons.forEach(person -> dao.delete(person));
    }
}
