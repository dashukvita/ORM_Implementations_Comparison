package ru.jpa.Tests.TestPerson.test;

import ru.jpa.Tests.TestPerson.dao.PersonDaoHibernate;
import ru.jpa.Tests.imp.ITeastPersonAndPersonIndexed;
import ru.jpa.Tests.TestPerson.model.Person;

import java.util.List;

public class HibernateTestPerson implements ITeastPersonAndPersonIndexed {
    private List<Person> persons;
    private PersonDaoHibernate dao;

    @Override
    public void createPerson() {
        Person person = new Person();
        dao = new PersonDaoHibernate();
        dao.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        dao = new PersonDaoHibernate();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public Person getLastPerson() {
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        Person person = dao.getLastPerson(persons.size());
        System.out.println(person);
        return person;
    }

    @Override
    public void updatePerson() {
        dao = new PersonDaoHibernate();
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
        dao = new PersonDaoHibernate();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}
