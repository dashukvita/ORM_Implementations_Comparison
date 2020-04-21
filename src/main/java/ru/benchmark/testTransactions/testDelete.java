package ru.benchmark.testTransactions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class testDelete {
    public int num = 1000;

    public static void main(String[] args) throws RunnerException {
        testDelete test = new testDelete();

        Options opt = new OptionsBuilder()
                .include(testDelete.class.getSimpleName())
                .forks(1)
                .build();
        test.createEntityForTest();
        new Runner(opt).run();
    }

    public void createEntityForTest(){
//        PersonDaoEclipseLink dao = new PersonDaoEclipseLink();
//        dao.save(num);
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
//        new HibernateTestPersonIndexed().deletePerson();
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
