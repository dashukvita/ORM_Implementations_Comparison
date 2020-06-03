package ru.jpa.tests.TestIndexedPerson.test;

import ru.jpa.tests.TestIndexedPerson.dao.PersonIndexedDaoJPA;
import ru.jpa.tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.tests.imp.ITeastPersonAndPersonIndexed;
import ru.jpa.utils.UtilJPA;

import javax.persistence.EntityManager;
import java.util.List;

public class TestPersonIndexedJPA implements ITeastPersonAndPersonIndexed {
    private PersonIndexedDaoJPA dao;
    public String entityManagerName;

    public TestPersonIndexedJPA(String entityManagerName) {
        this.entityManagerName = entityManagerName;
    }

    @Override
    public void createPerson(int num) {
        dao = new PersonIndexedDaoJPA();
        for (int i = 0; i < num; i++) {
            EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
            dao.save(entityManager);
        }
    }

    @Override
    public List<PersonIndexed> getAllPersons() {
        EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
        dao = new PersonIndexedDaoJPA();
        List<PersonIndexed> persons = dao.getAllPersons(entityManager);
//        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao = new PersonIndexedDaoJPA();
        EntityManager entMgr = UtilJPA.getEntityManager(this.entityManagerName);
        List<PersonIndexed> persons = dao.getAllPersons(entMgr);
        persons.forEach(person -> {
            EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
            person.setFirstName("testName");
            dao.update(person, entityManager);
        });
    }

    @Override
    public void deletePerson() {
        dao = new PersonIndexedDaoJPA();
        EntityManager entMgr = UtilJPA.getEntityManager(this.entityManagerName);
        List<PersonIndexed> persons = dao.getAllPersons(entMgr);
        persons.forEach(person -> {
            EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
            dao.delete(person, entityManager);
        });
    }
}
