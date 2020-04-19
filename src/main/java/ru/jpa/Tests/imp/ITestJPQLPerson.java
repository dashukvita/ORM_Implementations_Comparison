package ru.jpa.Tests.imp;

public interface ITestJPQLPerson {

    void save();
    void JPQLUpdate();
    void JPQLWithPagination();
    void JPQLSelect();
    void JPQLDelete();

    default void crudEntity(int num) {
        TimeBenchmark timeBenchmark = new TimeBenchmark();
        System.out.println("------------------Save------------------");
        timeBenchmark.measure(this::save, num);
        System.out.println("------------------JPQL Update------------------");
        timeBenchmark.measureOneTime(this::JPQLUpdate);
        System.out.println("------------------JPQL Select------------------");
        timeBenchmark.measureOneTime(this::JPQLSelect);
        System.out.println("------------------JPQL With Pagination------------------");
        timeBenchmark.measureOneTime(this::JPQLWithPagination);
        System.out.println("------------------JPQL Delete------------------");
        timeBenchmark.measureOneTime(this::JPQLDelete);
    }

}
