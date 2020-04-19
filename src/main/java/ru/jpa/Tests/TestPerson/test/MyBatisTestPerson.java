package ru.jpa.Tests.TestPerson.test;

import ru.jpa.Tests.TestPerson.dao.PersonDaoMyBatis;
import ru.jpa.Tests.imp.ITeastPersonAndPersonIndexed;
import ru.jpa.Tests.TestPerson.model.Person;

import java.util.List;

public class MyBatisTestPerson implements ITeastPersonAndPersonIndexed {
    private List<Person> persons;
    PersonDaoMyBatis dao;

    @Override
    public void createPerson() {
        Person person = new Person();
        dao= new PersonDaoMyBatis();
        dao.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        dao= new PersonDaoMyBatis();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public Person getLastPerson() {
        dao= new PersonDaoMyBatis();
        if(persons == null || !persons.isEmpty()){
            getAllPersons();
        }
        return dao.getLastPerson(persons.size());
    }

    @Override
    public void updatePerson() {
        dao= new PersonDaoMyBatis();
        dao.update("testName");
    }

    @Override
    public void deletePerson() {
        dao= new PersonDaoMyBatis();
        dao.delete();
    }
}
