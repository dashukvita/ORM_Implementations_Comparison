package ru.jpa.tests.TestIndexedPerson.test;

import ru.jpa.tests.TestIndexedPerson.dao.PersonIndexedDaoEclipseLink;
import ru.jpa.tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.tests.imp.ITeastPersonAndPersonIndexed;

import java.util.List;

public class EclipseLinkTestPersonIndexed implements ITeastPersonAndPersonIndexed {
    private PersonIndexedDaoEclipseLink dao;

    @Override
    public void createPerson(int num) {
        dao = new PersonIndexedDaoEclipseLink();
        dao.save(num);
    }

    @Override
    public List<PersonIndexed> getAllPersons() {
        dao = new PersonIndexedDaoEclipseLink();
        List<PersonIndexed> persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao = new PersonIndexedDaoEclipseLink();
        List<PersonIndexed> persons = dao.getAllPersons();
        for (PersonIndexed person : persons) {
            person.setFirstName("testName");
            dao.update(person);
        }
    }

    @Override
    public void deletePerson() {
        dao = new PersonIndexedDaoEclipseLink();
        List<PersonIndexed> persons = dao.getAllPersons();
        persons.forEach(person -> dao.delete(person));
    }
}
