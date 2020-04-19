package ru.jpa.Tests.TestIndexedPerson.test;

import ru.jpa.Tests.TestIndexedPerson.dao.PersonIndexedDaoMyBatis;
import ru.jpa.Tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.Tests.imp.ITeastPersonAndPersonIndexed;

import java.util.List;

public class MyBatisTestPersonIndexed implements ITeastPersonAndPersonIndexed {
    private List<PersonIndexed> persons;
    private PersonIndexedDaoMyBatis dao;

    @Override
    public void createPerson() {
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
    public PersonIndexed getLastPerson() {
        dao= new PersonIndexedDaoMyBatis();
        if(persons == null || !persons.isEmpty()){
            getAllPersons();
        }
//        System.out.println(dao.getLastPerson(persons.size()));
        return dao.getLastPerson(persons.size());
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
