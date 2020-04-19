package ru.jpa.tests.TestIndexedPerson.test;

import ru.jpa.tests.TestIndexedPerson.dao.PersonIndexedDaoHibernate;
import ru.jpa.tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.tests.imp.ITeastPersonAndPersonIndexed;
import java.util.List;

public class HibernateTestPersonIndexed implements ITeastPersonAndPersonIndexed {
    private List<PersonIndexed> persons;
    private PersonIndexedDaoHibernate dao;

    @Override
    public void createPerson(int num) {
        PersonIndexed person = new PersonIndexed();
        dao = new PersonIndexedDaoHibernate();
        dao.save(person);
    }

    @Override
    public List<PersonIndexed> getAllPersons() {
        dao = new PersonIndexedDaoHibernate();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao = new PersonIndexedDaoHibernate();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }

        for (PersonIndexed person : persons) {
            person.setFirstName("testName");
            dao.update(person);
        }
    }

    @Override
    public void deletePerson() {
        dao = new PersonIndexedDaoHibernate();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}
