package benchmark;
import org.openjdk.jmh.annotations.*;

public class TestBM {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2) // Итераций прогрева = 2 (прогрев JVM, результат игнорируется)
    @Measurement(iterations = 10) // Итераций измерения = 10 (для расчета)
    public void init() {

        fib(22);
        //fibbonaci(300);
    }

    static int fib(int n) {
        if (n<2) return 1;
        else return fib(n-1) + fib(n-2);
    }

}
