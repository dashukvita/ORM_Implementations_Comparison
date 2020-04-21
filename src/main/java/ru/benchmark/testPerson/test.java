package ru.benchmark.testPerson;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.jpa.tests.TestPerson.model.Person;
import ru.jpa.tests.TestPerson.test.EclipseLinkTestPerson;
import ru.jpa.utils.EclipseLinkUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@State(Scope.Benchmark)
public class test {
    @Param({"10000"})
    private int num;

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 3)
    @Measurement(iterations = 5)
    @OutputTimeUnit(TimeUnit.MINUTES)
    public void traditionalMethod(test T) {
        new EclipseLinkTestPerson().createPerson(10000);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(test.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
