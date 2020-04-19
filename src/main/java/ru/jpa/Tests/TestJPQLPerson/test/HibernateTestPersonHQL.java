package ru.jpa.Tests.TestJPQLPerson.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.jpa.Tests.TestJPQLPerson.model.SimplePerson;
import ru.jpa.Tests.imp.ITestJPQLPerson;
import ru.jpa.utils.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class HibernateTestPersonHQL implements ITestJPQLPerson {

    @Override
    public void JPQLUpdate(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Query query = session.createQuery("update SimplePerson set firstName = :nameParam");
        query.setParameter("nameParam", "testName");
        query.executeUpdate();
        tx1.commit();
        session.close();
    }

    @Override
    public void JPQLDelete(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createQuery("delete SimplePerson").executeUpdate();;
        tx1.commit();
        session.close();
    }

    @Override
    public void JPQLSelect(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Query query = session.createQuery( "select firstName from SimplePerson" );
        query.getResultList();
        List<String> list = (List<String>) query.getResultList();
        list.forEach(personName -> System.out.println(personName));

        tx1.commit();
        session.close();
    }

    @Override
    public void JPQLWithPagination()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Query query = session.createQuery( "select firstName from SimplePerson" );
        query.setFirstResult( 1 );
        query.setMaxResults( 9 );
        List<String> list = (List<String>) query.getResultList();
        list.forEach(personName -> System.out.println(personName));

        tx1.commit();
        session.close();
    }

    @Override
    public void save() {
        SimplePerson person = new SimplePerson();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(person);
        tx1.commit();
        session.close();
    }

}
