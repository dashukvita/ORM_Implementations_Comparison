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
public class testGet {
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
                .include(testGet.class.getSimpleName())
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
    public void getTestPersonEclipseMethod() { new TestPersonJPA(ECLIPSELINK).getAllPersons(); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonHibernateMethod() { new TestPersonJPA(HIBERNATE).getAllPersons(); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonOpenJPAMethod() { new TestPersonJPA(OPENJPA).getAllPersons(); }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonMyBatisMethod() {
        new TestPersonMyBatis().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonOtmEclipseMethod() {
        new TestPersonOneToManyJPA(ECLIPSELINK).getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonOtmHibernateMethod() {
        new TestPersonOneToManyJPA(HIBERNATE).getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonOtmOpenJPAMethod() {
        new TestPersonOneToManyJPA(OPENJPA).getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonOtmMyBatisMethod() {
        new TestPersonOneToManyMyBatis().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonIndexedEclipseMethod() {
        new TestPersonIndexedJPA(ECLIPSELINK).getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonIndexedHibernateMethod() {
        new TestPersonIndexedJPA(HIBERNATE).getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonIndexedOpenJPAMethod() {
        new TestPersonIndexedJPA(OPENJPA).getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonIndexedMyBatisMethod() {
        new TestPersonIndexedMyBatis().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonExtEclipseMethod() {
        new TestPersonExtJPA(ECLIPSELINK).getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonExtHibernateMethod() {
        new TestPersonExtJPA(HIBERNATE).getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonExtOpenJPAMethod() {
        new TestPersonExtJPA(OPENJPA).getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonColEclipseMethod() {
        new TestPersonCollectionJPA(ECLIPSELINK).getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonColHibernateMethod() {
        new TestPersonCollectionJPA(HIBERNATE).getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonColOpenJPAMethod() {
        new TestPersonCollectionJPA(OPENJPA).getAllPersons();
    }
}
