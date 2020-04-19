package ru.jpa.Tests.TestInheritancePerson.test;

import ru.jpa.Tests.TestInheritancePerson.dao.PersonExtDaoHibernate;
import ru.jpa.Tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.Tests.imp.ITestPersonInheritance;

import java.util.List;

public class HibernateTestPersonExt implements ITestPersonInheritance {

    private List<PersonExtExt> persons;
    private PersonExtDaoHibernate dao;

    @Override
    public void createPerson() {
        PersonExtExt person = new PersonExtExt();
        dao = new PersonExtDaoHibernate();
        dao.save(person);
    }

    public List<PersonExtExt> getAllPersons() {
        dao = new PersonExtDaoHibernate();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void deletePerson() {
        dao = new PersonExtDaoHibernate();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}
