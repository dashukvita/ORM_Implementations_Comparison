import ru.jpa.tests.TestCollectionPerson.test.TestPersonCollectionJPA;
import ru.jpa.tests.TestIndexedPerson.test.TestPersonIndexedJPA;
import ru.jpa.tests.TestIndexedPerson.test.TestPersonIndexedMyBatis;
import ru.jpa.tests.TestInheritancePerson.test.TestPersonExtJPA;
import ru.jpa.tests.TestJPQLPerson.test.TestPersonJPQL;
import ru.jpa.tests.TestOneToManyPerson.test.TestPersonOneToManyJPA;
import ru.jpa.tests.TestOneToManyPerson.test.TestPersonOneToManyMyBatis;
import ru.jpa.tests.TestPerson.test.*;
import ru.jpa.tests.imp.CrudEntitier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static final String HIBERNATE = "hibernate";
    public static final String ECLIPSELINK = "eclipselink";
    public static final String OPENJPA = "openjpa";

    public static void main(String[] args) {
        List<Integer> testAmounts = Arrays.asList(5);
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

    public static List<List<CrudEntitier>> initializeTest(){
        List<List<CrudEntitier>> allTests = new ArrayList<>();

//        allTests.add(generateTestPerson());
//        allTests.add(generateTestPersonIndexed());
//        allTests.add(generateTestPersonOneToMany());
        allTests.add(generateTestJPQL());
//        allTests.add(generateTestPersonInheritance());
//        allTests.add(generateTestPersonCollection());

        return allTests;
    }

    private static List<CrudEntitier> generateTestPerson(){
        return Arrays.asList(new TestPersonJPA(HIBERNATE), new TestPersonJPA(ECLIPSELINK),
                new TestPersonJPA(OPENJPA),new TestPersonMyBatis());
    }

    private static List<CrudEntitier> generateTestPersonIndexed(){
        return Arrays.asList(new TestPersonIndexedJPA(HIBERNATE), new TestPersonIndexedJPA(ECLIPSELINK),
                new TestPersonIndexedJPA(OPENJPA), new TestPersonIndexedMyBatis());
    }

    private static List<CrudEntitier> generateTestPersonOneToMany(){
        return Arrays.asList(new TestPersonOneToManyJPA(HIBERNATE), new TestPersonOneToManyJPA(ECLIPSELINK),
                new TestPersonOneToManyJPA(OPENJPA), new TestPersonOneToManyMyBatis());
    }

    private static List<CrudEntitier> generateTestJPQL(){
        return Arrays.asList(new TestPersonJPQL(HIBERNATE), new TestPersonJPQL(ECLIPSELINK),
                new TestPersonJPQL(OPENJPA));
    }

    private static List<CrudEntitier> generateTestPersonInheritance(){
        return Arrays.asList(new TestPersonExtJPA(HIBERNATE), new TestPersonExtJPA(ECLIPSELINK),
                new TestPersonExtJPA(OPENJPA));
    }

    private static List<CrudEntitier> generateTestPersonCollection(){
        return Arrays.asList(new TestPersonCollectionJPA(HIBERNATE), new TestPersonCollectionJPA(ECLIPSELINK),
                new TestPersonCollectionJPA(OPENJPA));
    }

    private static void runTestForDifferentORM(List<CrudEntitier> ormTest, int amount){
        String entityName = "";
        for (CrudEntitier orm: ormTest) {
            if(orm.getClass().getSimpleName().equals("TestPersonJPA")){
                entityName = ((TestPersonJPA) orm).entityManagerName.toUpperCase();
            } else if(orm.getClass().getSimpleName().equals("TestPersonMyBatis")){
                entityName = ((TestPersonMyBatis) orm).entityManagerName.toUpperCase();
            } else if(orm.getClass().getSimpleName().equals("TestPersonCollectionJPA")){
                entityName = ((TestPersonCollectionJPA) orm).entityManagerName.toUpperCase();
            } else if(orm.getClass().getSimpleName().equals("TestPersonIndexedJPA")){
                entityName = ((TestPersonIndexedJPA) orm).entityManagerName.toUpperCase();
            } else if(orm.getClass().getSimpleName().equals("TestPersonIndexedMyBatis")){
                entityName = ((TestPersonIndexedMyBatis) orm).entityManagerName.toUpperCase();
            } else if(orm.getClass().getSimpleName().equals("TestPersonExtJPA")){
                entityName = ((TestPersonExtJPA) orm).entityManagerName.toUpperCase();
            } else if(orm.getClass().getSimpleName().equals("TestPersonOneToManyJPA")){
                entityName = ((TestPersonOneToManyJPA) orm).entityManagerName.toUpperCase();
            } else if(orm.getClass().getSimpleName().equals("TestPersonOneToManyMyBatis")) {
                entityName = ((TestPersonOneToManyMyBatis) orm).entityManagerName.toUpperCase();
            } else if(orm.getClass().getSimpleName().equals("TestPersonJPQL")) {
                entityName = ((TestPersonJPQL) orm).entityManagerName.toUpperCase();
            }
            System.out.println("\n***************  " + entityName + "  ***************");
            orm.crudEntity(amount);
        }
    }

}

