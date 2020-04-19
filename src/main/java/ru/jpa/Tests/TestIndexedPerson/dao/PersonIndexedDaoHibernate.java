package ru.jpa.Tests.TestIndexedPerson.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.jpa.Tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.utils.HibernateUtil;

import java.util.List;

public class PersonIndexedDaoHibernate {

    public void save(PersonIndexed person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(person);
        tx1.commit();
        session.close();
    }

    public void update(PersonIndexed person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(person);
        tx1.commit();
        session.close();
    }

    public void delete(PersonIndexed person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(person);
        tx1.commit();
        session.close();
    }

    public PersonIndexed getLastPerson(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        PersonIndexed person = session.get(PersonIndexed.class, id);
        session.close();
        return person;
    }

    public List<PersonIndexed> getAllPersons() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PersonIndexed> persons = (List<PersonIndexed>)  session.createQuery("From PersonIndexed").list();
        session.close();
        return persons;
    }
}
