import ru.jpa.tests.TestCollectionPerson.test.EclipseLinkTestPersonCollection;
import ru.jpa.tests.TestCollectionPerson.test.HibernateTestPersonCollection;
import ru.jpa.tests.TestCollectionPerson.test.OpenJPATestPersonCollection;
import ru.jpa.tests.TestIndexedPerson.test.EclipseLinkTestPersonIndexed;
import ru.jpa.tests.TestIndexedPerson.test.HibernateTestPersonIndexed;
import ru.jpa.tests.TestIndexedPerson.test.MyBatisTestPersonIndexed;
import ru.jpa.tests.TestIndexedPerson.test.OpenJPATestPersonIndexed;
import ru.jpa.tests.TestInheritancePerson.test.EclipseLinkTestPersonExt;
import ru.jpa.tests.TestInheritancePerson.test.HibernateTestPersonExt;
import ru.jpa.tests.TestInheritancePerson.test.OpenJPATestPersonExt;
import ru.jpa.tests.TestJPQLPerson.test.EclipseLinkTestPersonJPQL;
import ru.jpa.tests.TestJPQLPerson.test.HibernateTestPersonHQL;
import ru.jpa.tests.TestJPQLPerson.test.OpenJPATestPersonJPQL;
import ru.jpa.tests.TestOneToManyPerson.test.EclipseLinkTestPersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.test.HibernateTestPersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.test.MyBatisTestPersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.test.OpenJPATestPersonOneToMany;
import ru.jpa.tests.TestPerson.test.EclipseLinkTestPerson;
import ru.jpa.tests.TestPerson.test.HibernateTestPerson;
import ru.jpa.tests.TestPerson.test.MyBatisTestPerson;
import ru.jpa.tests.TestPerson.test.OpenJPATestPerson;
import ru.jpa.tests.imp.CrudEntitier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> testAmounts = Arrays.asList(10000);
        List<List<CrudEntitier>> allORMTest = initializeTest();

        for (List<CrudEntitier> ormTest: allORMTest) {
            runTests(testAmounts, ormTest);
        }

    }

    public static void runTests(List<Integer> amountList, List<CrudEntitier> tests) {
        for (int i = 0; i < amountList.size(); i++) {
            runTestForDifferentORM(tests, amountList.get(i));
        }
    }

    private static void runTestForDifferentORM(List<CrudEntitier> ormTest, int amount){
        for (CrudEntitier orm: ormTest) {
            System.out.println("\n***************************  " + orm.getClass().getSimpleName()+ "  ***************************");
            orm.crudEntity(amount);
        }
    }

    public static List<List<CrudEntitier>> initializeTest(){
        List<List<CrudEntitier>> allTests = new ArrayList<>();

        allTests.add(generateTestPerson());
        allTests.add(generateTestPersonIndexed());
        allTests.add(generateTestPersonOneToMany());
        allTests.add(generateTestJPQL());
        allTests.add(generateTestPersonInheritance());
        allTests.add(generateTestPersonCollection());

        return allTests;
    }

    private static List<CrudEntitier> generateTestPerson(){
        return Arrays.asList(new HibernateTestPerson(), new EclipseLinkTestPerson(),
                new OpenJPATestPerson(), new MyBatisTestPerson());
    }

    private static List<CrudEntitier> generateTestPersonIndexed(){
        return Arrays.asList(new HibernateTestPersonIndexed(), new EclipseLinkTestPersonIndexed(),
                new OpenJPATestPersonIndexed(), new MyBatisTestPersonIndexed());
    }

    private static List<CrudEntitier> generateTestPersonOneToMany(){
        return Arrays.asList(new HibernateTestPersonOneToMany(), new OpenJPATestPersonOneToMany(),
                new EclipseLinkTestPersonOneToMany(), new MyBatisTestPersonOneToMany());
    }

    private static List<CrudEntitier> generateTestJPQL(){
        return Arrays.asList(new HibernateTestPersonHQL(), new EclipseLinkTestPersonJPQL(),
                new OpenJPATestPersonJPQL());
    }

    private static List<CrudEntitier> generateTestPersonInheritance(){
        return Arrays.asList(new HibernateTestPersonExt(), new EclipseLinkTestPersonExt(),
                new OpenJPATestPersonExt());
    }

    private static List<CrudEntitier> generateTestPersonCollection(){
        return Arrays.asList(new HibernateTestPersonCollection(), new EclipseLinkTestPersonCollection(),
                new OpenJPATestPersonCollection());
    }

}

