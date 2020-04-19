package ru.jpa.Tests.TestPerson.dao;

import ru.jpa.Tests.TestPerson.model.Person;
import ru.jpa.utils.EclipseLinkUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonDaoEclipseLink {

    public void save(Person person) {
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Person person) {
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Person person) {
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Person findPerson = entityManager.find(Person.class, person.getId());
        entityManager.remove(findPerson);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Person getLastPerson(int id) {
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        return entityManager.find(Person.class, id);
    }

    public List<Person> getAllPersons() {
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        Query q = entityManager.createQuery("SELECT p from Person p");
        return (List<Person>)q.getResultList();
    }
}
