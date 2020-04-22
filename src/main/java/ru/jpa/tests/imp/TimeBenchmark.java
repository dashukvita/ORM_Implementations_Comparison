package ru.jpa.tests.imp;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class TimeBenchmark {
    private BigDecimal timeStart;
    private BigDecimal nanos;
    private BigDecimal millis;

    public void measure(Runnable methodRun) {
        waitTime();
        timeStart = new BigDecimal(System.nanoTime());
        methodRun.run();
        nanos = new BigDecimal(System.nanoTime()).subtract(timeStart);
        millis = nanos.divide(new BigDecimal(1000000));

        printResult();
    }

    private void waitTime(){
        try {
//            Thread.sleep(60000);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printResult(){
//        System.out.println("Nanoseconds:" + nanos);
        System.out.println("Milliseconds:" + millis);
    }

}
