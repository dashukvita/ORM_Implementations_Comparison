package ru.jpa.Tests.TestCollectionPerson.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.jpa.Tests.TestCollectionPerson.model.AddressCollection;
import ru.jpa.Tests.TestCollectionPerson.model.PersonCollection;
import ru.jpa.Tests.TestOneToManyPerson.model.AddressOneToMany;
import ru.jpa.Tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.utils.HibernateUtil;
import java.util.List;

public class PersonCollectionDaoHibernate {

    public void save(PersonCollection person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(person);
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
