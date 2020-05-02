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
public class testDeleteTr {
    public  static int num = 1000;
    private final String HIBERNATE = "hibernate";
    private final String ECLIPSELINK = "eclipselink";
    private final String OPENJPA = "openjpa";

    public static void main(String[] args) throws RunnerException {
        System.err.close();
        System.setErr(System.out);
        EntityForTest entityForTest = new EntityForTest();
        entityForTest.createEntityForTest(num);

        Options opt = new OptionsBuilder()
                .include(testDeleteTr.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteEclipseLinkTestPerson() {
        new TestPersonJPA(ECLIPSELINK).deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteHibernateTestPerson() {
        new TestPersonJPA(HIBERNATE).deletePerson();
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteOpenJPATestPerson() {
        new TestPersonJPA(OPENJPA).deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteMyBatisTestPerson() {
        new TestPersonMyBatis().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteEclipseLinkTestPersonOneToMany() {
        new TestPersonOneToManyJPA(ECLIPSELINK).deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteHibernateTestPersonOneToMany() {
        new TestPersonOneToManyJPA(HIBERNATE).deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteOpenJPATestPersonOneToMany() {
        new TestPersonOneToManyJPA(OPENJPA).deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteMyBatisTestPersonOneToMany() {
        new TestPersonOneToManyMyBatis().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteEclipseLinkTestPersonIndexed() {
        new TestPersonIndexedJPA(ECLIPSELINK).deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteHibernateTestPersonIndexed() {
        new TestPersonIndexedJPA(HIBERNATE).deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteOpenJPATestPersonIndexed() {
        new TestPersonIndexedJPA(OPENJPA).deletePerson();
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteMyBatisTestPersonIndexed() {
        new TestPersonIndexedMyBatis().deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteEclipseLinkTestPersonExt() {
        new TestPersonExtJPA(ECLIPSELINK).deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteHibernateTestPersonExt() {
        new TestPersonExtJPA(HIBERNATE).deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteOpenJPATestPersonExt() {
        new TestPersonExtJPA(OPENJPA).deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteEclipseLinkTestPersonCollection() {
        new TestPersonCollectionJPA(ECLIPSELINK).deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteHibernateTestPersonCollection() {
        new TestPersonCollectionJPA(HIBERNATE).deletePerson();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteOpenJPATestPersonCollection() { new TestPersonCollectionJPA(OPENJPA).deletePerson(); }
}
