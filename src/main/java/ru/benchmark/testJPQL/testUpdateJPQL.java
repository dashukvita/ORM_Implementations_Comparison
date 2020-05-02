package ru.benchmark.testJPQL;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.jpa.tests.TestJPQLPerson.model.SimplePerson;
import ru.jpa.tests.TestJPQLPerson.test.TestPersonJPQL;
import ru.jpa.utils.UtilJPA;

import javax.persistence.EntityManager;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class testUpdateJPQL {
    public int num = 1000;
    private final String HIBERNATE = "hibernate";
    private final String ECLIPSELINK = "eclipselink";
    private final String OPENJPA = "openjpa";

    public static void main(String[] args) throws RunnerException {
        System.err.close();
        System.setErr(System.out);
        testUpdateJPQL test = new testUpdateJPQL();
        test.createEntityForTest();

        Options opt = new OptionsBuilder()
                .include(testUpdateJPQL.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    public void createEntityForTest(){
        EntityManager entityManager = UtilJPA.getEntityManager(HIBERNATE);
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
    @Warmup(iterations = 2)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateEclipseLink() {
        new TestPersonJPQL(ECLIPSELINK).JPQLUpdate();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateHibernate() {
        new TestPersonJPQL(HIBERNATE).JPQLUpdate();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void updateOpenJPA() {
        new TestPersonJPQL(OPENJPA).JPQLUpdate();
    }
}
