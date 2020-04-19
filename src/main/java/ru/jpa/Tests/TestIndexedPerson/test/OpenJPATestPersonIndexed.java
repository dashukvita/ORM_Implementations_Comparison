package ru.jpa.Tests.TestIndexedPerson.test;

import ru.jpa.Tests.TestIndexedPerson.dao.PersonIndexedDaoOpenJpa;
import ru.jpa.Tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.Tests.imp.ITeastPersonAndPersonIndexed;

import java.util.List;

public class OpenJPATestPersonIndexed implements ITeastPersonAndPersonIndexed {
    private List<PersonIndexed> persons;
    private PersonIndexedDaoOpenJpa dao;
    private PersonIndexed person;

    @Override
    public void createPerson() {
        person = new PersonIndexed();
        dao = new PersonIndexedDaoOpenJpa();
        dao.save(person);
    }

    @Override
    public List<PersonIndexed> getAllPersons() {
        dao = new PersonIndexedDaoOpenJpa();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public PersonIndexed getLastPerson() {
        dao = new PersonIndexedDaoOpenJpa();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        System.out.println(dao.getLastPerson(persons.size()));
        return dao.getLastPerson(persons.size());
    }

    @Override
    public void updatePerson() {
        dao = new PersonIndexedDaoOpenJpa();
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
        dao = new PersonIndexedDaoOpenJpa();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}
