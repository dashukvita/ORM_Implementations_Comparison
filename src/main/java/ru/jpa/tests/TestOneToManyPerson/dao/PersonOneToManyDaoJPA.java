package ru.jpa.tests.TestOneToManyPerson.dao;

import ru.jpa.tests.TestOneToManyPerson.model.AddressOneToMany;
import ru.jpa.tests.TestOneToManyPerson.model.PersonOneToMany;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

public class PersonOneToManyDaoJPA {
    private List<PersonOneToMany> persons;
    private EntityManager entityManager;

    public void save(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        PersonOneToMany person = new PersonOneToMany();
        AddressOneToMany homeAddress = new AddressOneToMany();
        AddressOneToMany workAddress = new AddressOneToMany();
        person.getAddresses().add(homeAddress);
        person.getAddresses().add(workAddress);
        entityManager.persist(person);

        homeAddress.setPerson(person);
        workAddress.setPerson(person);
        entityManager.persist(homeAddress);
        entityManager.persist(workAddress);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<PersonOneToMany> getAllPersons(EntityManager entityManager){
        Query q = entityManager.createQuery("SELECT p from PersonOneToMany p");
        persons = (List<PersonOneToMany>)q.getResultList();
        entityManager.close();
        return persons;
    }

    public void delete(PersonOneToMany person, EntityManager entityManager) {
        entityManager.getTransaction().begin();

        PersonOneToMany findPerson = entityManager.find(PersonOneToMany.class, person.getPerson_id());
        Iterator iterator = findPerson.getAddresses().iterator();
        while (iterator.hasNext()) {
            AddressOneToMany addressOneToMany = (AddressOneToMany) iterator.next();
            entityManager.remove(addressOneToMany);
        }
        entityManager.remove(findPerson);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(PersonOneToMany person, EntityManager entityManager) {
        entityManager.getTransaction().begin();

        PersonOneToMany findPerson = entityManager.find(PersonOneToMany.class, person.getPerson_id());
        findPerson.setFirstName("testName");

        entityManager.merge(findPerson);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
