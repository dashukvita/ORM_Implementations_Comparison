package ru.jpa.tests.TestInheritancePerson.test;

import ru.jpa.tests.TestInheritancePerson.dao.PersonExtDaoHibernate;
import ru.jpa.tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.tests.imp.ITestPersonInheritance;

import java.util.List;

public class HibernateTestPersonExt implements ITestPersonInheritance {
    private PersonExtDaoHibernate dao;

    @Override
    public void createPerson(int num) {
        dao = new PersonExtDaoHibernate();
        dao.save(num);
    }

    @Override
    public List<PersonExtExt> getAllPersons() {
        dao = new PersonExtDaoHibernate();
        List<PersonExtExt> persons = dao.getAllPersons();
//        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void deletePerson() {
        dao = new PersonExtDaoHibernate();
        List<PersonExtExt> persons = dao.getAllPersons();
        persons.forEach(person -> dao.delete(person));
    }
}
