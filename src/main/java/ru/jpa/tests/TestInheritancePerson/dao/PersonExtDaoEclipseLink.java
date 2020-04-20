package ru.jpa.tests.TestInheritancePerson.dao;

import ru.jpa.tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.tests.TestPerson.model.Person;
import ru.jpa.utils.EclipseLinkUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonExtDaoEclipseLink {

    public void save(int num) {
        EntityManager entityMgr = EclipseLinkUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        for (int i = 0; i < num; i++) {
            entityMgr.persist(new PersonExtExt());
        }
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

    public List<PersonExtExt> getAllPersons() {
        EntityManager em = EclipseLinkUtil.getEntityManager();
        Query q = em.createQuery("SELECT p from PersonExtExt p");
        return (List<PersonExtExt>)q.getResultList();
    }
}
