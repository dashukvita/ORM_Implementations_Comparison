package ru.jpa.tests.TestInheritancePerson.test;

import ru.jpa.tests.TestInheritancePerson.dao.PersonExtDaoJPA;
import ru.jpa.tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.tests.imp.ITestPersonInheritance;
import ru.jpa.utils.UtilJPA;

import javax.persistence.EntityManager;
import java.util.List;

public class TestPersonExtJPA implements ITestPersonInheritance {
    private PersonExtDaoJPA dao;
    public String entityManagerName;

    public TestPersonExtJPA(String entityManagerName) {
        this.entityManagerName = entityManagerName;
    }

    @Override
    public void createPerson(int num) {
        EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
        dao = new PersonExtDaoJPA();
        dao.save(num, entityManager);
    }

    @Override
    public List<PersonExtExt> getAllPersons() {
        EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
        dao = new PersonExtDaoJPA();
        List<PersonExtExt> persons = dao.getAllPersons(entityManager);
//        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void deletePerson() {
        dao = new PersonExtDaoJPA();
        EntityManager entMgr= UtilJPA.getEntityManager(this.entityManagerName);
        List<PersonExtExt> persons = dao.getAllPersons(entMgr);
        persons.forEach(person -> {
            EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
            dao.delete(person, entityManager);
        });
    }
}
