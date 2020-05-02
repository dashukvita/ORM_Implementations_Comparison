package ru.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilJPA {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static EntityManager getEntityManager(String unitName){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(unitName);
        }
        if(entityManager == null || !entityManager.isOpen()){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
}
