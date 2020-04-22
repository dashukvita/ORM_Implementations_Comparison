package ru.benchmark.testTransactions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.jpa.tests.TestCollectionPerson.dao.PersonCollectionDaoEclipseLink;
import ru.jpa.tests.TestCollectionPerson.test.EclipseLinkTestPersonCollection;
import ru.jpa.tests.TestCollectionPerson.test.HibernateTestPersonCollection;
import ru.jpa.tests.TestCollectionPerson.test.OpenJPATestPersonCollection;
import ru.jpa.tests.TestIndexedPerson.dao.PersonIndexedDaoEclipseLink;
import ru.jpa.tests.TestIndexedPerson.test.EclipseLinkTestPersonIndexed;
import ru.jpa.tests.TestIndexedPerson.test.HibernateTestPersonIndexed;
import ru.jpa.tests.TestIndexedPerson.test.MyBatisTestPersonIndexed;
import ru.jpa.tests.TestIndexedPerson.test.OpenJPATestPersonIndexed;
import ru.jpa.tests.TestInheritancePerson.dao.PersonExtDaoEclipseLink;
import ru.jpa.tests.TestInheritancePerson.test.EclipseLinkTestPersonExt;
import ru.jpa.tests.TestInheritancePerson.test.HibernateTestPersonExt;
import ru.jpa.tests.TestInheritancePerson.test.OpenJPATestPersonExt;
import ru.jpa.tests.TestOneToManyPerson.dao.PersonOneToManyDaoEclipseLink;
import ru.jpa.tests.TestOneToManyPerson.test.EclipseLinkTestPersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.test.HibernateTestPersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.test.MyBatisTestPersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.test.OpenJPATestPersonOneToMany;
import ru.jpa.tests.TestPerson.dao.PersonDaoEclipseLink;
import ru.jpa.tests.TestPerson.test.EclipseLinkTestPerson;
import ru.jpa.tests.TestPerson.test.HibernateTestPerson;
import ru.jpa.tests.TestPerson.test.MyBatisTestPerson;
import ru.jpa.tests.TestPerson.test.OpenJPATestPerson;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class testDeleteTr {
    public int num = 1000;

    public static void main(String[] args) throws RunnerException {
        System.err.close();
        System.setErr(System.out);
        testDeleteTr test = new testDeleteTr();

        Options opt = new OptionsBuilder()
                .include(testDeleteTr.class.getSimpleName())
                .forks(1)
                .build();
        test.createEntityForTest();
        new Runner(opt).run();
    }

    public void createEntityForTest(){
//        PersonDaoEclipseLink dao = new PersonDaoEclipseLink();
//        dao.save(num);

//        PersonOneToManyDaoEclipseLink daoOtM = new PersonOneToManyDaoEclipseLink();
//        daoOtM.save(num);
//
//        PersonExtDaoEclipseLink daoExt = new PersonExtDaoEclipseLink();
//        daoExt.save(num);
////
//        PersonIndexedDaoEclipseLink daoInd = new PersonIndexedDaoEclipseLink();
//        daoInd.save(num);
//
        PersonCollectionDaoEclipseLink daoCol = new PersonCollectionDaoEclipseLink();
        daoCol.save(num);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteMethod() {
//        new EclipseLinkTestPerson().deletePerson();
//        new HibernateTestPerson().deletePerson();
//        new MyBatisTestPerson().deletePerson();
//        new OpenJPATestPerson().deletePerson();

//        new EclipseLinkTestPersonOneToMany().deletePerson();
//        new HibernateTestPersonOneToMany().deletePerson();
//        new MyBatisTestPersonOneToMany().deletePerson();
//        new OpenJPATestPersonOneToMany().deletePerson();
//
//        new EclipseLinkTestPersonIndexed().deletePerson();
//        new HibernateTestPersonIndexed().deletePerson();
//        new MyBatisTestPersonIndexed().deletePerson();
//        new OpenJPATestPersonIndexed().deletePerson();
//
//        new EclipseLinkTestPersonExt().deletePerson();
//        new HibernateTestPersonExt().deletePerson();
//        new OpenJPATestPersonExt().deletePerson();
//
//        new EclipseLinkTestPersonCollection().deletePerson();
//        new HibernateTestPersonCollection().deletePerson();
//        new OpenJPATestPersonCollection().deletePerson();
    }
}