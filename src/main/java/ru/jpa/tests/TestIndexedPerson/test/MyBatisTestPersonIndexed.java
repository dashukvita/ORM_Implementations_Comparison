package ru.jpa.tests.TestIndexedPerson.test;

import ru.jpa.tests.TestIndexedPerson.dao.PersonIndexedDaoMyBatis;
import ru.jpa.tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.tests.imp.ITeastPersonAndPersonIndexed;

import java.util.List;

public class MyBatisTestPersonIndexed implements ITeastPersonAndPersonIndexed {
    private List<PersonIndexed> persons;
    private PersonIndexedDaoMyBatis dao;

    @Override
    public void createPerson(int num) {
        PersonIndexed person = new PersonIndexed();
        dao= new PersonIndexedDaoMyBatis();
        dao.save(person);
    }

    @Override
    public List<PersonIndexed> getAllPersons() {
        dao= new PersonIndexedDaoMyBatis();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao= new PersonIndexedDaoMyBatis();
        dao.update("testName");
    }

    @Override
    public void deletePerson() {
        dao= new PersonIndexedDaoMyBatis();
        dao.delete();
    }
}
