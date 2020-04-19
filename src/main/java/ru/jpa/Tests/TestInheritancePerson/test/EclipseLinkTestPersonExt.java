package ru.jpa.Tests.TestInheritancePerson.test;

import ru.jpa.Tests.TestInheritancePerson.dao.PersonExtDaoEclipseLink;
import ru.jpa.Tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.Tests.imp.ITestPersonInheritance;

import java.util.List;

public class EclipseLinkTestPersonExt implements ITestPersonInheritance {
    
    private List<PersonExtExt> persons;
    private PersonExtDaoEclipseLink dao;

    @Override
    public void createPerson() {
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
