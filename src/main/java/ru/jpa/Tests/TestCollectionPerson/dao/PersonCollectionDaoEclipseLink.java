package ru.jpa.Tests.TestCollectionPerson.dao;

import ru.jpa.Tests.TestCollectionPerson.model.PersonCollection;
import ru.jpa.utils.EclipseLinkUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonCollectionDaoEclipseLink {

    public void save(PersonCollection person) {
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(PersonCollection person) {
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        entityManager.getTransaction().begin();
        PersonCollection findPerson = entityManager.find(PersonCollection.class, person.getId());
        findPerson.setFirstName("testName");
        entityManager.merge(findPerson);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(PersonCollection person) {
        EntityManager entityMgr = EclipseLinkUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        PersonCollection findPerson = entityMgr.find(PersonCollection.class, person.getId());
        entityMgr.remove(findPerson);
        entityMgr.getTransaction().commit();
        entityMgr.close();
    }

    public List<PersonCollection> getAllPersons() {
        EntityManager em = EclipseLinkUtil.getEntityManager();
        Query q = em.createQuery("SELECT p from PersonCollection p");
        return (List<PersonCollection>)q.getResultList();
    }
}
