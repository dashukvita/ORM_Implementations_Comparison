package ru.benchmark.testTransactions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.jpa.tests.TestPerson.dao.PersonDaoEclipseLink;
import ru.jpa.tests.TestPerson.test.EclipseLinkTestPerson;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class testGet {
    public int num = 1000;

    public static void main(String[] args) throws RunnerException {
        testGet test = new testGet();

        Options opt = new OptionsBuilder()
                .include(testGet.class.getSimpleName())
                .forks(1)
                .build();
        test.createEntityForTest();
        new Runner(opt).run();
    }

    public void createEntityForTest(){
        PersonDaoEclipseLink dao = new PersonDaoEclipseLink();
        dao.save(num);
//
//        PersonOneToManyDaoEclipseLink daoOtM = new PersonOneToManyDaoEclipseLink();
//        daoOtM.save(num);
//
//        PersonExtDaoEclipseLink daoExt = new PersonExtDaoEclipseLink();
//        daoExt.save(num);
//
//        PersonIndexedDaoEclipseLink daoInd = new PersonIndexedDaoEclipseLink();
//        daoInd.save(num);
//
//        PersonCollectionDaoEclipseLink daoCol = new PersonCollectionDaoEclipseLink();
//        daoCol.save(num);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getMethod() {
        new EclipseLinkTestPerson().getAllPersons();
//        new HibernateTestPerson().getAllPersons();
//        new MyBatisTestPerson().getAllPersons();
//        new OpenJPATestPerson().getAllPersons();
//
//        new EclipseLinkTestPersonOneToMany().getAllPersons();
//        new HibernateTestPersonOneToMany().getAllPersons();
//        new MyBatisTestPersonOneToMany().getAllPersons();
//        new OpenJPATestPersonOneToMany().getAllPersons();
//
//        new EclipseLinkTestPersonIndexed().getAllPersons();
//        new HibernateTestPersonIndexed().getAllPersons();
//        new HibernateTestPersonIndexed().getAllPersons();
//        new OpenJPATestPersonIndexed().getAllPersons();
//
//        new EclipseLinkTestPersonExt().getAllPersons();
//        new HibernateTestPersonExt().getAllPersons();
//        new OpenJPATestPersonExt().getAllPersons();
//
//        new EclipseLinkTestPersonCollection().getAllPersons();
//        new HibernateTestPersonCollection().getAllPersons();
//        new OpenJPATestPersonCollection().getAllPersons();
    }
}
