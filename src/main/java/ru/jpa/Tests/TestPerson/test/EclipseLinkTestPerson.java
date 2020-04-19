package ru.jpa.Tests.TestPerson.test;

import ru.jpa.Tests.TestPerson.dao.PersonDaoEclipseLink;
import ru.jpa.Tests.imp.ITeastPersonAndPersonIndexed;
import ru.jpa.Tests.TestPerson.model.Person;

import java.util.List;

public class EclipseLinkTestPerson implements ITeastPersonAndPersonIndexed {
    private List<Person> persons;
    private PersonDaoEclipseLink dao;

    @Override
    public void createPerson() {
        Person person = new Person();
        dao = new PersonDaoEclipseLink();
        dao.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        dao = new PersonDaoEclipseLink();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public Person getLastPerson() {
        dao = new PersonDaoEclipseLink();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        return dao.getLastPerson(persons.size());
    }

    @Override
    public void updatePerson() {
        dao = new PersonDaoEclipseLink();
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
        dao = new PersonDaoEclipseLink();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}
