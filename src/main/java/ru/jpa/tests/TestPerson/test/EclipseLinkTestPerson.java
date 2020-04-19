package ru.jpa.tests.TestPerson.test;

import ru.jpa.tests.TestPerson.dao.PersonDaoEclipseLink;
import ru.jpa.tests.imp.ITeastPersonAndPersonIndexed;
import ru.jpa.tests.TestPerson.model.Person;

import java.util.List;

public class EclipseLinkTestPerson implements ITeastPersonAndPersonIndexed {
    private List<Person> persons;
    private PersonDaoEclipseLink dao;

    @Override
    public void createPerson(int num) {
        dao = new PersonDaoEclipseLink();
        dao.save(num);
    }

    @Override
    public List<Person> getAllPersons() {
        dao = new PersonDaoEclipseLink();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
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
