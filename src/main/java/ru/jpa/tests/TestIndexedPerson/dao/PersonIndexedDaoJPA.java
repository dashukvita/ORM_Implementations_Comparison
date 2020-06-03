package ru.jpa.tests.TestIndexedPerson.dao;

import ru.jpa.tests.TestIndexedPerson.model.PersonIndexed;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonIndexedDaoJPA {

    public void save(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.persist(new PersonIndexed());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(PersonIndexed person, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.merge(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(PersonIndexed person, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        PersonIndexed findPerson = entityManager.find(PersonIndexed.class, person.getId());
        entityManager.remove(findPerson);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<PersonIndexed> getAllPersons(EntityManager entityManager) {
        Query q = entityManager.createQuery("SELECT p from PersonIndexed p");
        return (List<PersonIndexed>)q.getResultList();
    }
}
