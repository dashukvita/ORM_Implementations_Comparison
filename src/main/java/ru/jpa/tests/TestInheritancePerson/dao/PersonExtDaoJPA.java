package ru.jpa.tests.TestInheritancePerson.dao;

import ru.jpa.tests.TestInheritancePerson.model.PersonExtExt;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonExtDaoJPA {

    public void save(int num, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        for (int i = 0; i < num; i++) {
            entityManager.persist(new PersonExtExt());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(PersonExtExt person, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        PersonExtExt findPerson = entityManager.find(PersonExtExt.class, person.getId());
        entityManager.remove(findPerson);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<PersonExtExt> getAllPersons(EntityManager entityManager) {
        Query q = entityManager.createQuery("SELECT p from PersonExtExt p");
        return (List<PersonExtExt>)q.getResultList();
    }
}
