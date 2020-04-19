package ru.jpa.tests.TestPerson.test;

import ru.jpa.tests.TestOneToManyPerson.dao.PersonOneToManyDaoMyBatis;
import ru.jpa.tests.TestPerson.dao.PersonDaoMyBatis;
import ru.jpa.tests.TestPerson.dao.PersonDaoOpenJpa;
import ru.jpa.tests.imp.ITeastPersonAndPersonIndexed;
import ru.jpa.tests.TestPerson.model.Person;

import java.util.List;

public class MyBatisTestPerson implements ITeastPersonAndPersonIndexed {
    private List<Person> persons;
    private PersonDaoMyBatis dao;

    @Override
    public void createPerson(int num) {
        dao= new PersonDaoMyBatis();
        dao.save(num);
    }

    @Override
    public List<Person> getAllPersons() {
        dao= new PersonDaoMyBatis();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao= new PersonDaoMyBatis();
        dao.update("testName");
    }

    @Override
    public void deletePerson() {
        dao= new PersonDaoMyBatis();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}
