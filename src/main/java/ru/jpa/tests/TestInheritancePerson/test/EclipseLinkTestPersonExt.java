package ru.jpa.tests.TestInheritancePerson.test;

import ru.jpa.tests.TestInheritancePerson.dao.PersonExtDaoEclipseLink;
import ru.jpa.tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.tests.imp.ITestPersonInheritance;

import java.util.List;

public class EclipseLinkTestPersonExt implements ITestPersonInheritance {
    private PersonExtDaoEclipseLink dao;

    @Override
    public void createPerson(int num) {
        dao = new PersonExtDaoEclipseLink();
        dao.save(num);
    }

    @Override
    public List<PersonExtExt> getAllPersons() {
        dao = new PersonExtDaoEclipseLink();
        List<PersonExtExt> persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void deletePerson() {
        dao = new PersonExtDaoEclipseLink();
        List<PersonExtExt> persons = dao.getAllPersons();
        persons.forEach(person -> dao.delete(person));
    }
}
