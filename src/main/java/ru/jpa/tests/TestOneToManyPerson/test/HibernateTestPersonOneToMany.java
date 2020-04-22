package ru.jpa.tests.TestOneToManyPerson.test;

import ru.jpa.tests.TestOneToManyPerson.dao.PersonOneToManyDaoHibernate;
import ru.jpa.tests.TestOneToManyPerson.model.AddressOneToMany;
import ru.jpa.tests.TestOneToManyPerson.model.PersonOneToManyHib;
import ru.jpa.tests.imp.ITestOneToManyAndCollection;

import java.util.List;

public class HibernateTestPersonOneToMany implements ITestOneToManyAndCollection {
    private PersonOneToManyDaoHibernate dao;
    private List<PersonOneToManyHib> personsWithAddress;
    private AddressOneToMany address;

    @Override
    public void createPerson(int num) {
        dao = new PersonOneToManyDaoHibernate();
        dao.save(num);
    }

    @Override
    public List<PersonOneToManyHib> getAllPersons() {
        dao = new PersonOneToManyDaoHibernate();
        List<PersonOneToManyHib> persons = dao.getAllPersons();
//        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    public List<PersonOneToManyHib> getAllPersonWithAddress() {
        dao = new PersonOneToManyDaoHibernate();
        personsWithAddress = dao.getAllPersons();

        for (PersonOneToManyHib person: personsWithAddress) {
            System.out.println(person);
//            System.out.println(person.getAddresses());
        }
        return personsWithAddress;
    }

    @Override
    public void deletePerson() {
        dao = new PersonOneToManyDaoHibernate();
        List<PersonOneToManyHib> persons = dao.getAllPersons();
        if(!persons.isEmpty() && persons != null){
            persons.forEach(person -> dao.delete(person));
        }
    }

    public void updatePerson() {
        dao = new PersonOneToManyDaoHibernate();
        List<PersonOneToManyHib> persons = dao.getAllPersons();
        for (PersonOneToManyHib person : persons) {
            person.setFirstName("testName");
            dao.update(person);
        }
    }
}
