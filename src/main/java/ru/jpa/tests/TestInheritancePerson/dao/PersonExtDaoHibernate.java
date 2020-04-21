package ru.jpa.tests.TestInheritancePerson.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.jpa.tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.utils.HibernateUtil;

import java.util.List;

public class PersonExtDaoHibernate {

    public void save(int num) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        for (int i = 0; i < num; i++) {
            session.save(new PersonExtExt());
        }
        tx1.commit();
        session.close();
    }

    public void delete(PersonExtExt person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(person);
        tx1.commit();
        session.close();
    }

    public List<PersonExtExt> getAllPersons() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PersonExtExt> persons = (List<PersonExtExt>)  session.createQuery("From PersonExtExt").list();
        session.close();
        return persons;
    }
}