package ru.jpa.tests.TestJPQLPerson.test;

import ru.jpa.tests.TestJPQLPerson.model.SimplePerson;
import ru.jpa.tests.TestPerson.model.Person;
import ru.jpa.tests.imp.ITestJPQLPerson;
import ru.jpa.utils.OpenJPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class OpenJPATestPersonJPQL implements ITestJPQLPerson {

    @Override
    public void JPQLUpdate(){
        EntityManager entityManager = OpenJPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update SimplePerson sp set sp.firstName = :nameParam");
        query.setParameter("nameParam", "testName");
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void JPQLDelete(){
        EntityManager entityManager = OpenJPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from SimplePerson").executeUpdate();;
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void JPQLSelect(){
        EntityManager entityManager = OpenJPAUtil.getEntityManager();
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
        EntityManager entityManager = OpenJPAUtil.getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery( "select sp.firstName from SimplePerson sp" );
        query.setFirstResult( 1 );
        query.setMaxResults( 9 );
        List<String> list = (List<String>) query.getResultList();
//        list.forEach(personName -> System.out.println(personName));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void save(int num) {
        EntityManager entityManager = OpenJPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        for (int i = 0; i < num; i++) {
            entityManager.persist(new SimplePerson());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
