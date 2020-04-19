package ru.jpa.tests.TestIndexedPerson.test;

import ru.jpa.tests.TestIndexedPerson.dao.PersonIndexedDaoOpenJpa;
import ru.jpa.tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.tests.imp.ITeastPersonAndPersonIndexed;

import java.util.List;

public class OpenJPATestPersonIndexed implements ITeastPersonAndPersonIndexed {
    private List<PersonIndexed> persons;
    private PersonIndexedDaoOpenJpa dao;
    private PersonIndexed person;

    @Override
    public void createPerson(int num) {
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
