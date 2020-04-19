package ru.jpa.Tests.TestIndexedPerson.dao;

import ru.jpa.Tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.utils.EclipseLinkUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonIndexedDaoEclipseLink {

    public void save(PersonIndexed person) {
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(PersonIndexed person) {
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(PersonIndexed person) {
        EntityManager entityMgr = EclipseLinkUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        PersonIndexed findPerson = entityMgr.find(PersonIndexed.class, person.getId());
        entityMgr.remove(findPerson);
        entityMgr.getTransaction().commit();
        entityMgr.close();
    }

    public PersonIndexed getLastPerson(int id) {
        EntityManager em = EclipseLinkUtil.getEntityManager();
        return em.find(PersonIndexed.class, id);
    }

    public List<PersonIndexed> getAllPersons() {
        EntityManager em = EclipseLinkUtil.getEntityManager();
        Query q = em.createQuery("SELECT p from PersonIndexed p");
        return (List<PersonIndexed>)q.getResultList();
    }
}
