package ru.jpa.tests.TestOneToManyPerson.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.jpa.tests.TestOneToManyPerson.model.AddressOneToMany;
import ru.jpa.tests.TestOneToManyPerson.model.AddressOneToManyHib;
import ru.jpa.tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.model.PersonOneToManyHib;
import ru.jpa.utils.HibernateUtil;

import java.util.Iterator;
import java.util.List;

public class PersonOneToManyDaoHibernate {
    private AddressOneToManyHib address;
    private List<PersonOneToManyHib> persons;

    public void save(int num) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        for (int i = 0; i < num; i++) {
            PersonOneToManyHib person = new PersonOneToManyHib();
            AddressOneToManyHib homeAddress = new AddressOneToManyHib();
            AddressOneToManyHib workAddress = new AddressOneToManyHib();
            person.getAddresses().add(homeAddress);
            person.getAddresses().add(workAddress);
            session.save(person);

            homeAddress.setPerson(person);
            workAddress.setPerson(person);
            session.save(homeAddress);
            session.save(workAddress);
        }

        tx1.commit();
        session.close();
    }

    public List<PersonOneToManyHib> getAllPersons(){
        Session session  = HibernateUtil.getSessionFactory().openSession();
        persons = (List<PersonOneToManyHib>)  session.createQuery("From PersonOneToManyHib").list();
        session.close();
        return persons;
    }

    private void deleteAddress(PersonOneToManyHib person){
        Session session  = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        while(person.getAddresses().iterator().hasNext()){
            address = person.getAddresses().iterator().next();
            person.getAddresses().remove(address);
            session.delete(address);
        }
        tx1.commit();
        session.close();
    }

    public void delete(PersonOneToManyHib person) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        while(person.getAddresses().iterator().hasNext()){
            address = person.getAddresses().iterator().next();
            person.getAddresses().remove(address);
            session.delete(address);
        }
        session.delete(person);
        tx1.commit();
        session.close();
    }

    public void update(PersonOneToManyHib person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(person);
        tx1.commit();
        session.close();
    }
}
