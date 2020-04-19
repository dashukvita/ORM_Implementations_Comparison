package ru.jpa.Tests.TestIndexedPerson.test;

import ru.jpa.Tests.TestIndexedPerson.dao.PersonIndexedDaoHibernate;
import ru.jpa.Tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.Tests.imp.ITeastPersonAndPersonIndexed;
import java.util.List;

public class HibernateTestPersonIndexed implements ITeastPersonAndPersonIndexed {
    private List<PersonIndexed> persons;
    private PersonIndexedDaoHibernate dao;

    @Override
    public void createPerson() {
        PersonIndexed person = new PersonIndexed();
        dao = new PersonIndexedDaoHibernate();
        dao.save(person);
    }

    @Override
    public List<PersonIndexed> getAllPersons() {
        dao = new PersonIndexedDaoHibernate();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public PersonIndexed getLastPerson() {
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        PersonIndexed person = dao.getLastPerson(persons.size());
        System.out.println(person);
        return dao.getLastPerson(persons.size());
    }

    @Override
    public void updatePerson() {
        dao = new PersonIndexedDaoHibernate();
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
        dao = new PersonIndexedDaoHibernate();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}
