package ru.jpa.tests.TestInheritancePerson.dao;

import ru.jpa.tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.utils.OpenJPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonExtDaoOpenJPA {

    public void save(int num) {
        EntityManager entityMgr = OpenJPAUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        for (int i = 0; i < num; i++) {
            entityMgr.persist(new PersonExtExt());
        }
        entityMgr.getTransaction().commit();
        entityMgr.close();
    }

    public void delete(PersonExtExt person) {
        EntityManager entityMgr = OpenJPAUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        PersonExtExt findPerson = entityMgr.find(PersonExtExt.class, person.getId());
        entityMgr.remove(findPerson);
        entityMgr.getTransaction().commit();
        entityMgr.close();
    }

    public List<PersonExtExt> getAllPersons() {
        EntityManager em = OpenJPAUtil.getEntityManager();
        Query q = em.createQuery("SELECT p from PersonExtExt p");
        return (List<PersonExtExt>)q.getResultList();
    }
}
