package ru.jpa.tests.TestIndexedPerson.dao;

import ru.jpa.tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.utils.OpenJPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonIndexedDaoOpenJpa {

    public void save(int num) {
        EntityManager entityMgr = OpenJPAUtil.getEntityManager();
        entityMgr.getTransaction().begin();
        for (int i = 0; i < num; i++) {
            entityMgr.persist(new PersonIndexed());
        }
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

    public List<PersonIndexed> getAllPersons() {
        EntityManager em = OpenJPAUtil.getEntityManager();
        Query q = em.createQuery("SELECT p from PersonIndexed p");
        return (List<PersonIndexed>)q.getResultList();
    }
}
