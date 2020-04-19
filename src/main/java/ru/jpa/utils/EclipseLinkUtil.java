package ru.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EclipseLinkUtil {
    private static final String PERSISTENCE_UNIT_NAME = "jpa_eclipselink";
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static EntityManager getEntityManager(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(entityManager == null || !entityManager.isOpen()){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
}
