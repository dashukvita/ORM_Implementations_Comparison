package ru.jpa.tests.TestCollectionPerson.dao;

import ru.jpa.tests.TestCollectionPerson.model.PersonCollection;
import ru.jpa.utils.OpenJPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonCollectionDaoOpenJPA {
    private EntityManager entityManager;

    public void save(int num) {
        entityManager = OpenJPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        for (int i = 0; i < num; i++) {
            entityManager.persist(new PersonCollection());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(PersonCollection person) {
        entityManager = OpenJPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        PersonCollection findPerson = entityManager.find(PersonCollection.class, person.getId());
        findPerson.setFirstName("testName");
        entityManager.merge(findPerson);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(PersonCollection person) {
        entityManager = OpenJPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        PersonCollection findPerson = entityManager.find(PersonCollection.class, person.getId());
        entityManager.remove(findPerson);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<PersonCollection> getAllPersons() {
        entityManager = OpenJPAUtil.getEntityManager();
        Query q = entityManager.createQuery("SELECT p from PersonCollection p");
        List<PersonCollection> persons = (List<PersonCollection>)q.getResultList();
        entityManager.close();
        return persons;
    }
}
