package ru.benchmark.testTransactions;

import ru.jpa.tests.TestCollectionPerson.dao.PersonCollectionDaoJPA;
import ru.jpa.tests.TestIndexedPerson.dao.PersonIndexedDaoJPA;
import ru.jpa.tests.TestInheritancePerson.dao.PersonExtDaoJPA;
import ru.jpa.tests.TestOneToManyPerson.dao.PersonOneToManyDaoJPA;
import ru.jpa.tests.TestPerson.dao.PersonDaoJPA;
import ru.jpa.utils.UtilJPA;

import javax.persistence.EntityManager;

public class EntityForTest {
    private final String ENTITYNAME = "hibernate";
    private EntityManager entityManager;

    public void createEntityForTest(int num){
        PersonDaoJPA dao = new PersonDaoJPA();
        entityManager = UtilJPA.getEntityManager(ENTITYNAME);
        dao.save(num, entityManager);

        PersonOneToManyDaoJPA daoOtM = new PersonOneToManyDaoJPA();
        entityManager = UtilJPA.getEntityManager(ENTITYNAME);
        daoOtM.save(num, entityManager);

        PersonExtDaoJPA daoExt = new PersonExtDaoJPA();
        entityManager = UtilJPA.getEntityManager(ENTITYNAME);
        daoExt.save(num, entityManager);

        PersonIndexedDaoJPA daoInd = new PersonIndexedDaoJPA();
        entityManager = UtilJPA.getEntityManager(ENTITYNAME);
        daoInd.save(num, entityManager);

        PersonCollectionDaoJPA daoCol = new PersonCollectionDaoJPA();
        entityManager = UtilJPA.getEntityManager(ENTITYNAME);
        daoCol.save(num, entityManager);
    }
}
