package ru.jpa.tests.TestPerson.dao;

import ru.jpa.tests.TestPerson.model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.jpa.utils.HibernateUtil;

import java.util.List;

public class PersonDaoHibernate {

    public void save(int num) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        for (int i = 0; i < num; i++) {
            session.save(new Person());
        }
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

    public List<Person> getAllPersons() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Person> persons = (List<Person>)  session.createQuery("From Person").list();
        session.close();
        return persons;
    }
}
