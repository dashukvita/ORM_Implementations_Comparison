package ru.jpa.tests.TestOneToManyPerson.test;

import ru.jpa.tests.TestOneToManyPerson.dao.PersonOneToManyDaoMyBatis;
import ru.jpa.tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.tests.imp.ITestOneToManyAndCollection;

import java.util.List;

public class MyBatisTestPersonOneToMany implements ITestOneToManyAndCollection{
    private List<PersonOneToMany> persons;
    PersonOneToManyDaoMyBatis dao;

    @Override
    public void createPerson(int num) {
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
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }

    @Override
    public void updatePerson() {
        dao= new PersonOneToManyDaoMyBatis();
        dao.update("testName");
    }
    
}
