package ru.jpa.tests.TestJPQLPerson.test;

import ru.jpa.tests.TestJPQLPerson.model.SimplePerson;
import ru.jpa.tests.imp.ITestJPQLPerson;
import ru.jpa.utils.UtilJPA;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TestPersonJPQL implements ITestJPQLPerson {
    public String entityManagerName;

    public TestPersonJPQL(String entityManagerName) {
        this.entityManagerName = entityManagerName;
    }

    @Override
    public void JPQLUpdate(){
        EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update SimplePerson sp set sp.firstName = :nameParam");
        query.setParameter("nameParam", "testName");
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void JPQLDelete(){
        EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from SimplePerson").executeUpdate();;
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void JPQLSelect(){
        EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery( "select sp.firstName from SimplePerson sp" );
        query.getResultList();
        List<String> list = (List<String>) query.getResultList();
//        list.forEach(personName -> System.out.println(personName));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void JPQLWithPagination()
    {
        EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery( "select sp.lastName from SimplePerson sp" );
        query.getResultList();
        List<String> list = (List<String>) query.getResultList();
//        list.forEach(personName -> System.out.println(personName));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void save(int num) {
        EntityManager entityManager = UtilJPA.getEntityManager(this.entityManagerName);
        entityManager.getTransaction().begin();
        for (int i = 0; i < num; i++) {
            entityManager.persist(new SimplePerson());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
