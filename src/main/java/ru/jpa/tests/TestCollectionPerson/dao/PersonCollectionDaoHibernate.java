package ru.jpa.tests.TestCollectionPerson.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.jpa.tests.TestCollectionPerson.model.PersonCollection;
import ru.jpa.utils.HibernateUtil;
import java.util.List;

public class PersonCollectionDaoHibernate {

    public void save(int num) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        for (int i = 0; i < num; i++) {
            session.save(new PersonCollection());
        }
        tx1.commit();
        session.close();
    }

    public void update(PersonCollection person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(person);
        tx1.commit();
        session.close();
    }

    public void delete(PersonCollection person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(person);

        tx1.commit();
        session.close();
    }

    public List<PersonCollection> getAllPersons() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PersonCollection> persons = (List<PersonCollection>)  session.createQuery("From PersonCollection").list();
        session.close();
        return persons;
    }

}
