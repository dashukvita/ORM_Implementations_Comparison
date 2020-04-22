package ru.jpa.tests.TestOneToManyPerson.test;

import ru.jpa.tests.TestOneToManyPerson.dao.PersonOneToManyDaoOpenJPA;
import ru.jpa.tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.tests.imp.ITestOneToManyAndCollection;

import java.util.List;

public class OpenJPATestPersonOneToMany implements ITestOneToManyAndCollection {
    private PersonOneToManyDaoOpenJPA dao;

    @Override
    public void createPerson(int num) {
        PersonOneToMany person = new PersonOneToMany();
        dao = new PersonOneToManyDaoOpenJPA();
        dao.save(num);
    }

    @Override
    public List<PersonOneToMany> getAllPersons() {
        dao = new PersonOneToManyDaoOpenJPA();
        List<PersonOneToMany> persons = dao.getAllPersons();
//        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void deletePerson() {
        dao = new PersonOneToManyDaoOpenJPA();
        List<PersonOneToMany> persons = dao.getAllPersons();
        persons.forEach(person -> dao.delete(person));
    }

    public void updatePerson() {
        dao = new PersonOneToManyDaoOpenJPA();
        List<PersonOneToMany> persons = dao.getAllPersons();
        persons.forEach(person -> dao.update(person));
    }
}
