package ru.jpa.Tests.TestPerson.test;

import ru.jpa.Tests.TestPerson.dao.PersonDaoOpenJpa;
import ru.jpa.Tests.imp.ITeastPersonAndPersonIndexed;
import ru.jpa.Tests.TestPerson.model.Person;

import java.util.List;

public class OpenJPATestPerson implements ITeastPersonAndPersonIndexed {
    private List<Person> persons;
    private PersonDaoOpenJpa dao;
    private Person person;

    @Override
    public void createPerson() {
        person = new Person();
        dao = new PersonDaoOpenJpa();
        dao.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        dao = new PersonDaoOpenJpa();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public Person getLastPerson() {
        dao = new PersonDaoOpenJpa();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        return dao.getLastPerson(persons.size());
    }

    @Override
    public void updatePerson() {
        dao = new PersonDaoOpenJpa();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        for (Person person : persons) {
            person.setFirstName("testName");
            dao.update(person);
        }
    }

    @Override
    public void deletePerson() {
        dao = new PersonDaoOpenJpa();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}
