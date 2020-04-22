package ru.jpa.tests.TestPerson.test;

import ru.jpa.tests.TestPerson.dao.PersonDaoOpenJpa;
import ru.jpa.tests.imp.ITeastPersonAndPersonIndexed;
import ru.jpa.tests.TestPerson.model.Person;

import java.util.List;

public class OpenJPATestPerson implements ITeastPersonAndPersonIndexed {
    private PersonDaoOpenJpa dao;

    @Override
    public void createPerson(int num) {
        dao = new PersonDaoOpenJpa();
        dao.save(num);
    }

    @Override
    public List<Person> getAllPersons() {
        dao = new PersonDaoOpenJpa();
        List<Person> persons = dao.getAllPersons();
//        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao = new PersonDaoOpenJpa();
        List<Person> persons = dao.getAllPersons();
        for (Person person : persons) {
            person.setFirstName("testName");
            dao.update(person);
        }
    }

    @Override
    public void deletePerson() {
        dao = new PersonDaoOpenJpa();
        List<Person> persons = dao.getAllPersons();
        persons.forEach(person -> dao.delete(person));
    }
}
