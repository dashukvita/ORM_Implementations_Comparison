package ru.jpa.tests.TestPerson.test;

import ru.jpa.tests.TestPerson.dao.PersonDaoJPA;
import ru.jpa.tests.TestPerson.model.Person;
import ru.jpa.tests.imp.ITeastPersonAndPersonIndexed;
import ru.jpa.utils.UtilJPA;

import javax.persistence.EntityManager;
import java.util.List;

public class TestPersonJPA implements ITeastPersonAndPersonIndexed {
    private PersonDaoJPA dao;
    public String entityManagerName;

    public TestPersonJPA(String entityManagerName) {
        this.entityManagerName = entityManagerName;
    }

    @Override
    public void createPerson(int num) {
        dao = new PersonDaoJPA();
        for (int i = 0; i < num; i++) {
            EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
            dao.save(entityManager);
        }
    }

    @Override
    public List<Person> getAllPersons() {
        EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
        dao = new PersonDaoJPA();
        List<Person> persons = dao.getAllPersons(entityManager);
        //        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao = new PersonDaoJPA();
        EntityManager entMgr = UtilJPA.getEntityManager(this.entityManagerName);
        List<Person> persons = dao.getAllPersons(entMgr);
        persons.forEach(person -> {
            EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
            person.setFirstName("testName");
            dao.update(person, entityManager);
        });
    }

    @Override
    public void deletePerson() {
        dao = new PersonDaoJPA();
        EntityManager entMgr = UtilJPA.getEntityManager(this.entityManagerName);
        List<Person> persons = dao.getAllPersons(entMgr);
        persons.forEach(person -> {
            EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
            dao.delete(person, entityManager);
        });
    }
}
