package ru.benchmark.testTransactions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.jpa.tests.TestPerson.test.EclipseLinkTestPerson;

import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
public class testCreate {
    @Param({"10000"})
    int num;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(testCreate.class.getSimpleName())
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
    public void createMethod() {
        new EclipseLinkTestPerson().createPerson(num);
//        new HibernateTestPerson().createPerson(num);
//        new MyBatisTestPerson().createPerson(num);
//        new OpenJPATestPerson().createPerson(num);

//        new EclipseLinkTestPersonOneToMany().createPerson(num);
//        new HibernateTestPersonOneToMany().createPerson(num);
//        new MyBatisTestPersonOneToMany().createPerson(num);
//        new OpenJPATestPersonOneToMany().createPerson(num);

//        new EclipseLinkTestPersonIndexed().createPerson(num);
//        new HibernateTestPersonIndexed().createPerson(num);
//        new MyBatisTestPersonIndexed().createPerson(num);
//        new OpenJPATestPersonIndexed().createPerson(num);

//        new EclipseLinkTestPersonExt().createPerson(num);
//        new HibernateTestPersonExt().createPerson(num);
//        new OpenJPATestPersonExt().createPerson(num);

//        new EclipseLinkTestPersonCollection().createPerson(num);
//        new HibernateTestPersonCollection().createPerson(num);
//        new OpenJPATestPersonCollection().createPerson(num);
    }
}
