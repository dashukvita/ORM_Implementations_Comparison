package ru.jpa.tests.TestIndexedPerson.test;

import ru.jpa.tests.TestIndexedPerson.dao.PersonIndexedDaoMyBatis;
import ru.jpa.tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.tests.imp.ITeastPersonAndPersonIndexed;

import java.util.List;

public class TestPersonIndexedMyBatis implements ITeastPersonAndPersonIndexed {
    private PersonIndexedDaoMyBatis dao;
    public String entityManagerName = "mybatis";

    @Override
    public void createPerson(int num) {
        dao= new PersonIndexedDaoMyBatis();
        dao.save(num);
    }

    @Override
    public List<PersonIndexed> getAllPersons() {
        dao= new PersonIndexedDaoMyBatis();
        List<PersonIndexed> persons = dao.getAllPersons();
//        persons.forEach(person -> System.out.println(person));
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
        List<PersonIndexed> persons = dao.getAllPersons();
        persons.forEach(person -> dao.delete(person));
    }
}
