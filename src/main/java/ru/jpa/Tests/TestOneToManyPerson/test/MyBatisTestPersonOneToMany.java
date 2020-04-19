package ru.jpa.Tests.TestOneToManyPerson.test;

import ru.jpa.Tests.TestOneToManyPerson.dao.PersonOneToManyDaoMyBatis;
import ru.jpa.Tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.Tests.imp.ITestOneToManyAndCollection;

import java.util.List;

public class MyBatisTestPersonOneToMany implements ITestOneToManyAndCollection{
    private List<PersonOneToMany> persons;
    PersonOneToManyDaoMyBatis dao;

    @Override
    public void createPerson() {
        PersonOneToMany person = new PersonOneToMany();
        dao= new PersonOneToManyDaoMyBatis();
        dao.save(person);
    }

    @Override
    public List<PersonOneToMany> getAllPersons() {
        dao= new PersonOneToManyDaoMyBatis();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void deletePerson() {
        dao= new PersonOneToManyDaoMyBatis();
        dao.delete();
    }

    @Override
    public void updatePerson() {
        dao= new PersonOneToManyDaoMyBatis();
        dao.update("testName");
    }
    
}
