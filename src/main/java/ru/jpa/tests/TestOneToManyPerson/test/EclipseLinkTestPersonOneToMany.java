package ru.jpa.tests.TestOneToManyPerson.test;

import ru.jpa.tests.TestOneToManyPerson.dao.PersonOneToManyDaoEclipseLink;
import ru.jpa.tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.tests.imp.ITestOneToManyAndCollection;

import java.util.List;

public class EclipseLinkTestPersonOneToMany implements ITestOneToManyAndCollection {
    private PersonOneToManyDaoEclipseLink dao;

    @Override
    public void createPerson(int num) {
        dao = new PersonOneToManyDaoEclipseLink();
        dao.save(num);
    }

    @Override
    public List<PersonOneToMany> getAllPersons() {
        dao = new PersonOneToManyDaoEclipseLink();
        List<PersonOneToMany> persons = dao.getAllPersons();
//        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void deletePerson() {
        dao = new PersonOneToManyDaoEclipseLink();
        List<PersonOneToMany> persons = dao.getAllPersons();
        persons.forEach(person -> dao.delete(person));
    }

    public void updatePerson() {
        dao = new PersonOneToManyDaoEclipseLink();
        List<PersonOneToMany> persons = dao.getAllPersons();
        persons.forEach(person -> dao.update(person));
    }
}
