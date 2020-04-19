package ru.jpa.Tests.TestPerson.dao;

import ru.jpa.Tests.TestPerson.model.Person;
import ru.jpa.utils.OpenJPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonDaoOpenJpa {

    public void save(Person person) {
        EntityManager entityMgr = OpenJPAUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        entityMgr.persist(person);
        entityMgr.getTransaction().commit();
        entityMgr.close();
    }

    public void update(Person person) {
        EntityManager entityMgr = OpenJPAUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        entityMgr.merge(person);
        entityMgr.getTransaction().commit();
        entityMgr.close();
    }

    public void delete(Person person) {
        EntityManager entityMgr = OpenJPAUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        Person findPerson = entityMgr.find(Person.class, person.getId());
        entityMgr.remove(findPerson);
        entityMgr.getTransaction().commit();
        entityMgr.close();
    }

    public Person getLastPerson(int id) {
        EntityManager em = OpenJPAUtil.getEntityManager();
        return em.find(Person.class, id);
    }

    public List<Person> getAllPersons() {
        EntityManager em = OpenJPAUtil.getEntityManager();
        Query q = em.createQuery("SELECT p from Person p");
        return (List<Person>)q.getResultList();
    }
}
