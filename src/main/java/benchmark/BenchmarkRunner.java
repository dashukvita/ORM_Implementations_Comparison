package benchmark;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        System.err.close();
        System.setErr(System.out);
        org.openjdk.jmh.Main.main(args);
    }
}