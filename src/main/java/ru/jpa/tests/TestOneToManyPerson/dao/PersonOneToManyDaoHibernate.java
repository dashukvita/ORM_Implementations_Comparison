package ru.jpa.tests.TestOneToManyPerson.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.jpa.tests.TestOneToManyPerson.model.AddressOneToMany;
import ru.jpa.tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.utils.HibernateUtil;

import java.util.List;

public class PersonOneToManyDaoHibernate {
    private AddressOneToMany address;
    private List<PersonOneToMany> persons;

    public void save(PersonOneToMany person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        AddressOneToMany homeAddress = new AddressOneToMany();
        AddressOneToMany workAddress = new AddressOneToMany();
        person.getAddresses().add(homeAddress);
        person.getAddresses().add(workAddress);
        session.save(person);

        homeAddress.setPerson(person);
        workAddress.setPerson(person);
        session.save(homeAddress);
        session.save(workAddress);

        tx1.commit();
        session.close();
    }

    public List<PersonOneToMany> getAllPersons(){
        Session session  = HibernateUtil.getSessionFactory().openSession();
        persons = (List<PersonOneToMany>)  session.createQuery("From PersonOneToMany").list();
        session.close();
        return persons;
    }

    private void deleteAddress(PersonOneToMany person){
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

    public void delete(PersonOneToMany person) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        deleteAddress(person);
        session.delete(person);
        tx1.commit();
        session.close();
    }

    public void update(PersonOneToMany person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(person);
        tx1.commit();
        session.close();
    }
}
