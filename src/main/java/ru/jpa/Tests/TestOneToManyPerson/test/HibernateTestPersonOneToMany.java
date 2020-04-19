package ru.jpa.Tests.TestOneToManyPerson.test;

import ru.jpa.Tests.TestOneToManyPerson.dao.PersonOneToManyDaoHibernate;
import ru.jpa.Tests.TestOneToManyPerson.model.AddressOneToMany;
import ru.jpa.Tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.Tests.imp.ITestOneToManyAndCollection;

import java.util.List;

public class HibernateTestPersonOneToMany implements ITestOneToManyAndCollection {
    private PersonOneToManyDaoHibernate dao;
    private List<PersonOneToMany> persons;
    private List<PersonOneToMany> personsWithAddress;
    private AddressOneToMany address;

    @Override
    public void createPerson() {
        PersonOneToMany person = new PersonOneToMany();
        dao = new PersonOneToManyDaoHibernate();
        dao.save(person);
    }

    @Override
    public List<PersonOneToMany> getAllPersons() {
        dao = new PersonOneToManyDaoHibernate();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    public List<PersonOneToMany> getAllPersonWithAddress() {
        dao = new PersonOneToManyDaoHibernate();
        personsWithAddress = dao.getAllPersons();

        for (PersonOneToMany person: personsWithAddress) {
            System.out.println(person);
//            System.out.println(person.getAddresses());
        }
        return personsWithAddress;
    }

    @Override
    public void deletePerson() {
        dao = new PersonOneToManyDaoHibernate();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }

    public void updatePerson() {
        dao = new PersonOneToManyDaoHibernate();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        for (PersonOneToMany person : persons) {
            person.setFirstName("testName");
            dao.update(person);
        }
    }
}
