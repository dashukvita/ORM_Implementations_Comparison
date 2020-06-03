package ru.jpa.tests.TestOneToManyPerson.test;

import ru.jpa.tests.TestOneToManyPerson.dao.PersonOneToManyDaoMyBatis;
import ru.jpa.tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.tests.imp.ITestOneToManyAndCollection;

import java.util.List;

public class TestPersonOneToManyMyBatis implements ITestOneToManyAndCollection{
    PersonOneToManyDaoMyBatis dao;
    public String entityManagerName = "mybatis";

    @Override
    public void createPerson(int num) {
        dao= new PersonOneToManyDaoMyBatis();
        for (int i = 0; i < num; i++) {
            dao.save();
        }
    }

    @Override
    public List<PersonOneToMany> getAllPersons() {
        dao= new PersonOneToManyDaoMyBatis();
        List<PersonOneToMany> persons = dao.getAllPersons();
//        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void deletePerson() {
        dao= new PersonOneToManyDaoMyBatis();
        List<PersonOneToMany> persons = dao.getAllPersons();
        persons.forEach(person -> dao.delete(person));
    }

    @Override
    public void updatePerson() {
        dao= new PersonOneToManyDaoMyBatis();
        dao.update("testName");
    }
    
}
