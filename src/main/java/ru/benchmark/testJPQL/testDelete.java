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
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteMethod() {
        new EclipseLinkTestPersonJPQL().JPQLDelete();
//        new HibernateTestPersonHQL().JPQLDelete();
//        new OpenJPATestPersonJPQL().JPQLDelete();
    }
}
