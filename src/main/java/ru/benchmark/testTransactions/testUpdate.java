package ru.benchmark.testTransactions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.jpa.tests.TestCollectionPerson.test.EclipseLinkTestPersonCollection;
import ru.jpa.tests.TestCollectionPerson.test.HibernateTestPersonCollection;
import ru.jpa.tests.TestCollectionPerson.test.OpenJPATestPersonCollection;
import ru.jpa.tests.TestIndexedPerson.test.EclipseLinkTestPersonIndexed;
import ru.jpa.tests.TestIndexedPerson.test.HibernateTestPersonIndexed;
import ru.jpa.tests.TestIndexedPerson.test.OpenJPATestPersonIndexed;
import ru.jpa.tests.TestOneToManyPerson.test.EclipseLinkTestPersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.test.HibernateTestPersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.test.MyBatisTestPersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.test.OpenJPATestPersonOneToMany;
import ru.jpa.tests.TestPerson.test.EclipseLinkTestPerson;
import ru.jpa.tests.TestPerson.test.HibernateTestPerson;
import ru.jpa.tests.TestPerson.test.MyBatisTestPerson;
import ru.jpa.tests.TestPerson.test.OpenJPATestPerson;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class testUpdate {
    public int num = 1000;

    public static void main(String[] args) throws RunnerException {
        testUpdate test = new testUpdate();

        Options opt = new OptionsBuilder()
                .include(testUpdate.class.getSimpleName())
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
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteMethod() {
        new EclipseLinkTestPerson().updatePerson();
        new HibernateTestPerson().updatePerson();
        new MyBatisTestPerson().updatePerson();
        new OpenJPATestPerson().updatePerson();

        new EclipseLinkTestPersonOneToMany().updatePerson();
        new HibernateTestPersonOneToMany().updatePerson();
        new MyBatisTestPersonOneToMany().updatePerson();
        new OpenJPATestPersonOneToMany().updatePerson();

        new EclipseLinkTestPersonIndexed().updatePerson();
        new HibernateTestPersonIndexed().updatePerson();
        new HibernateTestPersonIndexed().updatePerson();
        new OpenJPATestPersonIndexed().updatePerson();

        new EclipseLinkTestPersonCollection().updatePerson();
        new HibernateTestPersonCollection().updatePerson();
        new OpenJPATestPersonCollection().updatePerson();
    }
}
