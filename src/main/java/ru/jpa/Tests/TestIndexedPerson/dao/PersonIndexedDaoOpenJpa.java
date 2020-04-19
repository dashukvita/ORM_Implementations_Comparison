package ru.jpa.Tests.TestIndexedPerson.dao;

import ru.jpa.Tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.utils.OpenJPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonIndexedDaoOpenJpa {

    public void save(PersonIndexed person) {
        EntityManager entityMgr = OpenJPAUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        entityMgr.persist(person);
        entityMgr.getTransaction().commit();
        entityMgr.close();
    }

    public void update(PersonIndexed person) {
        EntityManager entityMgr = OpenJPAUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        entityMgr.merge(person);
        entityMgr.getTransaction().commit();
        entityMgr.close();
    }

    public void delete(PersonIndexed person) {
        EntityManager entityMgr = OpenJPAUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        PersonIndexed findPerson = entityMgr.find(PersonIndexed.class, person.getId());
        entityMgr.remove(findPerson);
        entityMgr.getTransaction().commit();
        entityMgr.close();
    }

    public PersonIndexed getLastPerson(int id) {
        EntityManager em = OpenJPAUtil.getEntityManager();
        return em.find(PersonIndexed.class, id);
    }

    public List<PersonIndexed> getAllPersons() {
        EntityManager em = OpenJPAUtil.getEntityManager();
        Query q = em.createQuery("SELECT p from PersonIndexed p");
        return (List<PersonIndexed>)q.getResultList();
    }
}
