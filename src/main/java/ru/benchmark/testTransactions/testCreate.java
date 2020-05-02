package ru.benchmark.testTransactions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.jpa.tests.TestCollectionPerson.test.TestPersonCollectionJPA;
import ru.jpa.tests.TestIndexedPerson.test.TestPersonIndexedJPA;
import ru.jpa.tests.TestIndexedPerson.test.TestPersonIndexedMyBatis;
import ru.jpa.tests.TestInheritancePerson.test.TestPersonExtJPA;
import ru.jpa.tests.TestOneToManyPerson.test.TestPersonOneToManyJPA;
import ru.jpa.tests.TestOneToManyPerson.test.TestPersonOneToManyMyBatis;
import ru.jpa.tests.TestPerson.test.TestPersonJPA;
import ru.jpa.tests.TestPerson.test.TestPersonMyBatis;

import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
public class testCreate {
    @Param({"1000"})
    int num;
    private final String HIBERNATE = "hibernate";
    private final String ECLIPSELINK = "eclipselink";
    private final String OPENJPA = "openjpa";

    public static void main(String[] args) throws RunnerException {
        System.err.close();
        System.setErr(System.out);
        Options opt = new OptionsBuilder()
                .include(testCreate.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createEclipseLinkTestPerson() { new TestPersonJPA(ECLIPSELINK).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createHibernateTestPerson() { new TestPersonJPA(HIBERNATE).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createMyBatisTestPerson() { new TestPersonMyBatis().createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createOpenJPATestPerson() { new TestPersonJPA(OPENJPA).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createEclipseLinkTestPersonOneToMany() { new TestPersonOneToManyJPA(ECLIPSELINK).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createHibernateTestPersonOneToMany() { new TestPersonOneToManyJPA(HIBERNATE).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createMyBatisTestPersonOneToMany() { new TestPersonOneToManyMyBatis().createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createOpenJPATestPersonOneToMany() { new TestPersonOneToManyJPA(OPENJPA).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createEclipseLinkTestPersonIndexed() { new TestPersonIndexedJPA(ECLIPSELINK).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createHibernateTestPersonIndexed() { new TestPersonIndexedJPA(HIBERNATE).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createMyBatisTestPersonIndexed() { new TestPersonIndexedMyBatis().createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createOpenJPATestPersonIndexed() { new TestPersonIndexedJPA(OPENJPA).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createEclipseLinkTestPersonExt() { new TestPersonExtJPA(ECLIPSELINK).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createHibernateTestPersonExt() { new TestPersonExtJPA(HIBERNATE).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createOpenJPATestPersonExt() { new TestPersonExtJPA(OPENJPA).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createEclipseLinkTestPersonCollection() { new TestPersonCollectionJPA(ECLIPSELINK).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createHibernateTestPersonCollection() { new TestPersonCollectionJPA(HIBERNATE).createPerson(num); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createOpenJPATestPersonCollection() { new TestPersonCollectionJPA(OPENJPA).createPerson(num); }
}
