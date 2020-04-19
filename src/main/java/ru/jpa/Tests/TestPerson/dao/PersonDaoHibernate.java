package ru.jpa.Tests.TestPerson.dao;

import ru.jpa.Tests.TestPerson.model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.jpa.utils.HibernateUtil;

import java.util.List;

public class PersonDaoHibernate {

    public void save(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(person);
        tx1.commit();
        session.close();
    }

    public void update(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(person);
        tx1.commit();
        session.close();
    }

    public void delete(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(person);
        tx1.commit();
        session.close();
    }

    public Person getLastPerson(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

    public List<Person> getAllPersons() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Person> persons = (List<Person>)  session.createQuery("From Person").list();
        session.close();
        return persons;
    }
}
