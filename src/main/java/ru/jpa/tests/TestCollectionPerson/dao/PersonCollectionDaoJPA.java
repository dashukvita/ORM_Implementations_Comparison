package ru.jpa.tests.TestCollectionPerson.dao;

import ru.jpa.tests.TestCollectionPerson.model.PersonCollection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonCollectionDaoJPA {

    public void save(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.persist(new PersonCollection());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(PersonCollection person, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        PersonCollection findPerson = entityManager.find(PersonCollection.class, person.getId());
        findPerson.setFirstName("testName");
        entityManager.merge(findPerson);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(PersonCollection person, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        PersonCollection findPerson = entityManager.find(PersonCollection.class, person.getId());
        entityManager.remove(findPerson);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<PersonCollection> getAllPersons(EntityManager entityManager) {
        Query q = entityManager.createQuery("SELECT p from PersonCollection p");
        return (List<PersonCollection>)q.getResultList();
    }
}
