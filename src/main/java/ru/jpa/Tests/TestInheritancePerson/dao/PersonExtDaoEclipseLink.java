package ru.jpa.Tests.TestInheritancePerson.dao;

import ru.jpa.Tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.utils.EclipseLinkUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonExtDaoEclipseLink {

    public void save(PersonExtExt person) {
        EntityManager entityMgr = EclipseLinkUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        entityMgr.persist(person);
        entityMgr.getTransaction().commit();
        entityMgr.close();
    }

    public void update(PersonExtExt person) {
        EntityManager entityMgr = EclipseLinkUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        entityMgr.merge(person);
        entityMgr.getTransaction().commit();
        entityMgr.close();
    }

    public void delete(PersonExtExt person) {
        EntityManager entityMgr = EclipseLinkUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        PersonExtExt findPerson = entityMgr.find(PersonExtExt.class, person.getId());
        entityMgr.remove(findPerson);
        entityMgr.getTransaction().commit();
        entityMgr.close();
    }

    public PersonExtExt getLastPerson(int id) {
        EntityManager em = EclipseLinkUtil.getEntityManager();
        return em.find(PersonExtExt.class, id);
    }

    public List<PersonExtExt> getAllPersons() {
        EntityManager em = EclipseLinkUtil.getEntityManager();
        Query q = em.createQuery("SELECT p from PersonExtExt p");
        return (List<PersonExtExt>)q.getResultList();
    }
}
