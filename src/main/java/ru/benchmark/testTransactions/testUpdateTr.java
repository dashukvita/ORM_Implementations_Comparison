package ru.benchmark.testTransactions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.jpa.tests.TestCollectionPerson.test.TestPersonCollectionJPA;
import ru.jpa.tests.TestIndexedPerson.test.TestPersonIndexedJPA;
import ru.jpa.tests.TestOneToManyPerson.test.TestPersonOneToManyJPA;
import ru.jpa.tests.TestOneToManyPerson.test.TestPersonOneToManyMyBatis;
import ru.jpa.tests.TestPerson.test.TestPersonJPA;
import ru.jpa.tests.TestPerson.test.TestPersonMyBatis;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class testUpdateTr {
    public static int num = 1000;
    private final String HIBERNATE = "hibernate";
    private final String ECLIPSELINK = "eclipselink";
    private final String OPENJPA = "openjpa";

    public static void main(String[] args) throws RunnerException {
        System.err.close();
        System.setErr(System.out);
        EntityForTest entityForTest = new EntityForTest();
        entityForTest.createEntityForTest(num);

        Options opt = new OptionsBuilder()
                .include(testUpdateTr.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateEclipseLinkTestPerson() {
        new TestPersonJPA(ECLIPSELINK).updatePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateHibernateTestPerson() {
        new TestPersonJPA(HIBERNATE).updatePerson();
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateOpenJPATestPerson() {
        new TestPersonJPA(OPENJPA).updatePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateMyBatisTestPerson() {
        new TestPersonMyBatis().updatePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateEclipseLinkTestPersonOneToMan() {
        new TestPersonOneToManyJPA(ECLIPSELINK).updatePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateHibernateTestPersonOneToMany() {
        new TestPersonOneToManyJPA(HIBERNATE).updatePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateMyBatisTestPersonOneToMan() {
        new TestPersonOneToManyMyBatis().updatePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateOpenJPATestPersonOneToMany() {
        new TestPersonOneToManyJPA(OPENJPA).updatePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateEclipseLinkTestPersonIndexed() {
        new TestPersonIndexedJPA(ECLIPSELINK).updatePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateHibernateTestPersonIndexed() {
        new TestPersonIndexedJPA(HIBERNATE).updatePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateOpenJPATestPersonIndexed() {
        new TestPersonIndexedJPA(OPENJPA).updatePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateEclipseLinkTestPersonCollection() {
        new TestPersonCollectionJPA(ECLIPSELINK).updatePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateHibernateTestPersonCollection() {
        new TestPersonCollectionJPA(HIBERNATE).updatePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateOpenJPATestPersonCollection() {
        new TestPersonCollectionJPA(OPENJPA).updatePerson();
    }
}
