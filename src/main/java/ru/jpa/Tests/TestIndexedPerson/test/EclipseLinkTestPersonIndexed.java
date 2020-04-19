package ru.jpa.Tests.TestIndexedPerson.test;

import ru.jpa.Tests.TestIndexedPerson.dao.PersonIndexedDaoEclipseLink;
import ru.jpa.Tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.Tests.imp.ITeastPersonAndPersonIndexed;

import java.util.List;

public class EclipseLinkTestPersonIndexed implements ITeastPersonAndPersonIndexed {
    private List<PersonIndexed> persons;
    private PersonIndexedDaoEclipseLink dao;

    @Override
    public void createPerson() {
        PersonIndexed person = new PersonIndexed();
        dao = new PersonIndexedDaoEclipseLink();
        dao.save(person);
    }

    @Override
    public List<PersonIndexed> getAllPersons() {
        dao = new PersonIndexedDaoEclipseLink();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public PersonIndexed getLastPerson() {
        dao = new PersonIndexedDaoEclipseLink();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        System.out.println(dao.getLastPerson(persons.size()));
        return dao.getLastPerson(persons.size());
    }

    @Override
    public void updatePerson() {
        dao = new PersonIndexedDaoEclipseLink();
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
        dao = new PersonIndexedDaoEclipseLink();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}
