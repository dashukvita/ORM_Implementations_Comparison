package ru.jpa.tests.TestCollectionPerson.test;

import ru.jpa.tests.TestCollectionPerson.dao.PersonCollectionDaoJPA;
import ru.jpa.tests.TestCollectionPerson.model.PersonCollection;
import ru.jpa.tests.imp.ITestOneToManyAndCollection;
import ru.jpa.utils.UtilJPA;

import javax.persistence.EntityManager;
import java.util.List;

public class TestPersonCollectionJPA implements ITestOneToManyAndCollection {
    private PersonCollectionDaoJPA dao;
    public String entityManagerName;

    public TestPersonCollectionJPA(String entityManagerName) {
        this.entityManagerName = entityManagerName;
    }

    @Override
    public void createPerson(int num) {
        EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
        dao = new PersonCollectionDaoJPA();
        dao.save(num, entityManager);
    }

    @Override
    public List<PersonCollection> getAllPersons() {
        EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
        dao = new PersonCollectionDaoJPA();
        List<PersonCollection> persons = dao.getAllPersons(entityManager);
//        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao = new PersonCollectionDaoJPA();
        EntityManager entMgr = UtilJPA.getEntityManager(this.entityManagerName);
        List<PersonCollection> persons = dao.getAllPersons(entMgr);
        persons.forEach(person -> {
            EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
            person.setFirstName("testName");
            dao.update(person, entityManager);
        });
    }

    @Override
    public void deletePerson() {
        dao = new PersonCollectionDaoJPA();
        EntityManager entMgr = UtilJPA.getEntityManager(this.entityManagerName);
        List<PersonCollection> persons = dao.getAllPersons(entMgr);
        persons.forEach(person -> {
            EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
            dao.delete(person, entityManager);
        });
    }
}
