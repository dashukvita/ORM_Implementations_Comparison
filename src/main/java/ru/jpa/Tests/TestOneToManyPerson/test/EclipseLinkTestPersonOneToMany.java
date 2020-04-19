package ru.jpa.Tests.TestOneToManyPerson.test;

import ru.jpa.Tests.TestOneToManyPerson.dao.PersonOneToManyDaoEclipseLink;
import ru.jpa.Tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.Tests.imp.ITestOneToManyAndCollection;

import java.util.List;

public class EclipseLinkTestPersonOneToMany implements ITestOneToManyAndCollection {
    private PersonOneToManyDaoEclipseLink dao;
    private List<PersonOneToMany> persons;

    @Override
    public void createPerson() {
        PersonOneToMany person = new PersonOneToMany();
        dao = new PersonOneToManyDaoEclipseLink();
        dao.save(person);
    }

    @Override
    public List<PersonOneToMany> getAllPersons() {
        dao = new PersonOneToManyDaoEclipseLink();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void deletePerson() {
        dao = new PersonOneToManyDaoEclipseLink();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }

    public void updatePerson() {
        dao = new PersonOneToManyDaoEclipseLink();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.update(person));
    }
}
