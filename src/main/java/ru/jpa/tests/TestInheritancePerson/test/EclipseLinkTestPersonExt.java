package ru.jpa.tests.TestInheritancePerson.test;

import ru.jpa.tests.TestInheritancePerson.dao.PersonExtDaoEclipseLink;
import ru.jpa.tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.tests.imp.ITestPersonInheritance;

import java.util.List;

public class EclipseLinkTestPersonExt implements ITestPersonInheritance {
    
    private List<PersonExtExt> persons;
    private PersonExtDaoEclipseLink dao;

    @Override
    public void createPerson(int num) {
        PersonExtExt person = new PersonExtExt();
        dao = new PersonExtDaoEclipseLink();
        dao.save(person);
    }

    public List<PersonExtExt> getAllPersons() {
        dao = new PersonExtDaoEclipseLink();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void deletePerson() {
        dao = new PersonExtDaoEclipseLink();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}
