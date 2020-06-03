package ru.jpa.tests.TestPerson.test;

import ru.jpa.tests.TestOneToManyPerson.dao.PersonOneToManyDaoMyBatis;
import ru.jpa.tests.TestPerson.dao.PersonDaoMyBatis;
import ru.jpa.tests.imp.ITeastPersonAndPersonIndexed;
import ru.jpa.tests.TestPerson.model.Person;

import java.util.List;

public class TestPersonMyBatis implements ITeastPersonAndPersonIndexed {
    private PersonDaoMyBatis dao;
    public String entityManagerName = "mybatis";

    @Override
    public void createPerson(int num) {
        for (int i = 0; i < num; i++) {
            dao= new PersonDaoMyBatis();
            dao.save();
        }
    }

    @Override
    public List<Person> getAllPersons() {
        dao= new PersonDaoMyBatis();
        List<Person> persons = dao.getAllPersons();
//        persons.forEach(person -> System.out.println(person));
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
        List<Person> persons = dao.getAllPersons();
        persons.forEach(person -> dao.delete(person));
    }
}
