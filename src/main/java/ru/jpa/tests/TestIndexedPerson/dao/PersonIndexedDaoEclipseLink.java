package ru.jpa.tests.TestIndexedPerson.dao;

import ru.jpa.tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.tests.TestPerson.model.Person;
import ru.jpa.utils.EclipseLinkUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonIndexedDaoEclipseLink {

    public void save(int num) {
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        entityManager.getTransaction().begin();
        for (int i = 0; i < num; i++) {
            entityManager.persist(new PersonIndexed());
        }
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

    public List<PersonIndexed> getAllPersons() {
        EntityManager em = EclipseLinkUtil.getEntityManager();
        Query q = em.createQuery("SELECT p from PersonIndexed p");
        return (List<PersonIndexed>)q.getResultList();
    }
}
