package ru.jpa.tests.imp;

public class TimeBenchmark {
    private long millis_startTime;
    private long startTime;
    private long elapsedTime;
    private long millis_endTime;
    private double secondDecimalPrecision;
    private double minutes;

    public void measure(Runnable methodRun) {
        waitTime();
        millis_startTime = System.currentTimeMillis();
        startTime = System.nanoTime();
        methodRun.run();
        elapsedTime = System.nanoTime() - startTime;
        millis_endTime = System.currentTimeMillis() - millis_startTime;

        printResult();
    }

    private void waitTime(){
//        System.out.println("Waiting 1 minutes to prepare for monitoring...");
        try {
            //Thread.sleep(60000);
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("Starting:");
    }

    private void printResult(){
        secondDecimalPrecision = (double) elapsedTime / 1000000000.0;
        //double minutes = TimeUnit.MINUTES.convert(elapsedTime, TimeUnit.NANOSECONDS);

        //Output in different formats: ms, ns, seconds, minutes
        //System.out.printf("Milliseconds: %d s\n", millis_endTime);
        //System.out.printf("Nanoseconds: %d ms\n", elapsedTime);
        System.out.printf("Second: %f ms\n", secondDecimalPrecision);
        //System.out.printf("Minutes: %f ms\n", minutes);
    }

}
