package ru.jpa.tests.TestOneToManyPerson.test;

import ru.jpa.tests.TestOneToManyPerson.dao.PersonOneToManyDaoJPA;
import ru.jpa.tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.tests.imp.ITestOneToManyAndCollection;
import ru.jpa.utils.UtilJPA;

import javax.persistence.EntityManager;
import java.util.List;

public class TestPersonOneToManyJPA implements ITestOneToManyAndCollection {
    private PersonOneToManyDaoJPA dao;
    public String entityManagerName;

    public TestPersonOneToManyJPA(String entityManagerName) {
        this.entityManagerName = entityManagerName;
    }

    @Override
    public void createPerson(int num) {
        dao = new PersonOneToManyDaoJPA();
        for (int i = 0; i < num; i++) {
            EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
            dao.save(entityManager);
        }
    }

    @Override
    public List<PersonOneToMany> getAllPersons() {
        EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
        dao = new PersonOneToManyDaoJPA();
        List<PersonOneToMany> persons = dao.getAllPersons(entityManager);
//        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void updatePerson() {
        dao = new PersonOneToManyDaoJPA();
        EntityManager entMgr = UtilJPA.getEntityManager(this.entityManagerName);
        List<PersonOneToMany> persons = dao.getAllPersons(entMgr);
        persons.forEach(person -> {
            EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
            person.setFirstName("testName");
            dao.update(person, entityManager);
        });
    }

    public void deletePerson() {
        dao = new PersonOneToManyDaoJPA();
        EntityManager entMgr = UtilJPA.getEntityManager(this.entityManagerName);
        List<PersonOneToMany> persons = dao.getAllPersons(entMgr);
        persons.forEach(person -> {
            EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
            dao.delete(person, entityManager);
        });
    }
}
