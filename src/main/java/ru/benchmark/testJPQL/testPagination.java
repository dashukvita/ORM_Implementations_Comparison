package ru.benchmark.testJPQL;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.jpa.tests.TestJPQLPerson.model.SimplePerson;
import ru.jpa.tests.TestJPQLPerson.test.EclipseLinkTestPersonJPQL;
import ru.jpa.tests.TestJPQLPerson.test.HibernateTestPersonHQL;
import ru.jpa.tests.TestJPQLPerson.test.OpenJPATestPersonJPQL;
import ru.jpa.utils.EclipseLinkUtil;

import javax.persistence.EntityManager;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class testPagination {
    public int num = 1000;

    public static void main(String[] args) throws RunnerException {
        testPagination test = new testPagination();

        Options opt = new OptionsBuilder()
                .include(testSelect.class.getSimpleName())
                .forks(1)
                .build();
        test.createEntityForTest();
        new Runner(opt).run();
    }

    public void createEntityForTest(){
        EntityManager entityManager = EclipseLinkUtil.getEntityManager();
        entityManager.getTransaction().begin();
        for (int i = 0; i < num; i++) {
            entityManager.persist(new SimplePerson());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void paginationMethod() {
        new EclipseLinkTestPersonJPQL().JPQLWithPagination();
//        new HibernateTestPersonHQL().JPQLWithPagination();
//        new OpenJPATestPersonJPQL().JPQLWithPagination();
    }
}
