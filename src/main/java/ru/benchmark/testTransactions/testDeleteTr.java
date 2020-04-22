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
        test.createEntityForTest();

        Options opt = new OptionsBuilder()
                .include(testDeleteTr.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    public void createEntityForTest(){
        PersonDaoEclipseLink dao = new PersonDaoEclipseLink();
        dao.save(num);

        PersonOneToManyDaoEclipseLink daoOtM = new PersonOneToManyDaoEclipseLink();
        daoOtM.save(num);

        PersonExtDaoEclipseLink daoExt = new PersonExtDaoEclipseLink();
        daoExt.save(num);

        PersonIndexedDaoEclipseLink daoInd = new PersonIndexedDaoEclipseLink();
        daoInd.save(num);

        PersonCollectionDaoEclipseLink daoCol = new PersonCollectionDaoEclipseLink();
        daoCol.save(num);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteEclipseLinkTestPerson() {
        new EclipseLinkTestPerson().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteHibernateTestPerson() {
        new HibernateTestPerson().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteMyBatisTestPerson() {
        new MyBatisTestPerson().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteOpenJPATestPerson() {
        new OpenJPATestPerson().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteEclipseLinkTestPersonOneToMany() {
        new EclipseLinkTestPersonOneToMany().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteHibernateTestPersonOneToMany() {
        new HibernateTestPersonOneToMany().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteMyBatisTestPersonOneToMany() {
        new MyBatisTestPersonOneToMany().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteOpenJPATestPersonOneToMany() {
        new OpenJPATestPersonOneToMany().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteEclipseLinkTestPersonIndexed() {
        new EclipseLinkTestPersonIndexed().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteMyBatisTestPersonIndexed() {
        new MyBatisTestPersonIndexed().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteOpenJPATestPersonIndexed() {
        new OpenJPATestPersonIndexed().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteEclipseLinkTestPersonExt() {
        new EclipseLinkTestPersonExt().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteHibernateTestPersonExt() {
        new HibernateTestPersonExt().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteOpenJPATestPersonExt() {
        new OpenJPATestPersonExt().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteEclipseLinkTestPersonCollection() {
        new EclipseLinkTestPersonCollection().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteHibernateTestPersonCollection() {
        new HibernateTestPersonCollection().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteOpenJPATestPersonCollection() {
        new OpenJPATestPersonCollection().deletePerson();
    }
}
