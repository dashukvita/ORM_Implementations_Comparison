package ru.jpa.tests.TestJPQLPerson.test;

import ru.jpa.tests.TestJPQLPerson.model.SimplePerson;
import ru.jpa.tests.TestPerson.model.Person;
import ru.jpa.tests.imp.ITestJPQLPerson;
import ru.jpa.utils.EclipseLinkUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EclipseLinkTestPersonJPQL implements ITestJPQLPerson {

    @Override
    public void JPQLUpdate(){
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update SimplePerson set firstName = :nameParam");
        query.setParameter("nameParam", "testName");
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void JPQLDelete(){
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from SimplePerson").executeUpdate();;
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void JPQLSelect(){
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
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
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
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
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        entityManager.getTransaction().begin();
        for (int i = 0; i < num; i++) {
            entityManager.persist(new SimplePerson());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
