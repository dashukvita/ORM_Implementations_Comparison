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
import ru.jpa.tests.TestIndexedPerson.test.MyBatisTestPersonIndexed;
import ru.jpa.tests.TestIndexedPerson.test.OpenJPATestPersonIndexed;
import ru.jpa.tests.TestInheritancePerson.test.EclipseLinkTestPersonExt;
import ru.jpa.tests.TestInheritancePerson.test.HibernateTestPersonExt;
import ru.jpa.tests.TestInheritancePerson.test.OpenJPATestPersonExt;
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
public class testCreate {
    @Param({"1000"})
    int num;

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
    public void createMethod() {
//        new EclipseLinkTestPerson().createPerson(num);
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
