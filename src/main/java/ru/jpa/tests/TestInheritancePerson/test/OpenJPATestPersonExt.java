package ru.jpa.tests.TestInheritancePerson.test;

import ru.jpa.tests.TestInheritancePerson.dao.PersonExtDaoOpenJPA;
import ru.jpa.tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.tests.imp.ITestPersonInheritance;

import java.util.List;

public class OpenJPATestPersonExt implements ITestPersonInheritance {
    private PersonExtDaoOpenJPA dao;

    @Override
    public void createPerson(int num) {
        dao = new PersonExtDaoOpenJPA();
        dao.save(num);
    }

    @Override
    public List<PersonExtExt> getAllPersons() {
        dao = new PersonExtDaoOpenJPA();
        List<PersonExtExt> persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void deletePerson() {
        dao = new PersonExtDaoOpenJPA();
        List<PersonExtExt> persons = dao.getAllPersons();
        persons.forEach(person -> dao.delete(person));
    }
}
