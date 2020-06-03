package ru.benchmark.testTransactions;

import ru.jpa.tests.TestCollectionPerson.dao.PersonCollectionDaoJPA;
import ru.jpa.tests.TestCollectionPerson.test.TestPersonCollectionJPA;
import ru.jpa.tests.TestIndexedPerson.dao.PersonIndexedDaoJPA;
import ru.jpa.tests.TestIndexedPerson.test.TestPersonIndexedJPA;
import ru.jpa.tests.TestInheritancePerson.dao.PersonExtDaoJPA;
import ru.jpa.tests.TestInheritancePerson.test.TestPersonExtJPA;
import ru.jpa.tests.TestOneToManyPerson.dao.PersonOneToManyDaoJPA;
import ru.jpa.tests.TestOneToManyPerson.test.TestPersonOneToManyJPA;
import ru.jpa.tests.TestPerson.dao.PersonDaoJPA;
import ru.jpa.tests.TestPerson.test.TestPersonJPA;
import ru.jpa.tests.TestPerson.test.TestPersonMyBatis;
import ru.jpa.utils.UtilJPA;

import javax.persistence.EntityManager;

public class EntityForTest {
    private final String ENTITYNAME = "hibernate";

    public void createEntityForTest(int num){
        TestPersonJPA testPersonJPA = new TestPersonJPA(ENTITYNAME);
        testPersonJPA.createPerson(num);

        TestPersonOneToManyJPA testPersonOneToManyJPA = new TestPersonOneToManyJPA(ENTITYNAME);
        testPersonOneToManyJPA.createPerson(num);

        TestPersonExtJPA testPersonExtJPA = new TestPersonExtJPA(ENTITYNAME);
        testPersonExtJPA.createPerson(num);

        TestPersonIndexedJPA testPersonIndexedJPA = new TestPersonIndexedJPA(ENTITYNAME);
        testPersonIndexedJPA.createPerson(num);

        TestPersonCollectionJPA testPersonCollectionJPA = new TestPersonCollectionJPA(ENTITYNAME);
        testPersonCollectionJPA.createPerson(num);
    }
}
