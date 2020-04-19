package ru.jpa.Tests.imp;

public interface ITestPersonInheritance {

    void createPerson();
    void deletePerson();

    default void crudEntity(int num) {
        TimeBenchmark timeBenchmark = new TimeBenchmark();
        System.out.println("------------------Create Entities------------------");
        timeBenchmark.measure(this::createPerson, num);
        System.out.println("------------------Delete Entities------------------");
        timeBenchmark.measureOneTime(this::deletePerson);
    }
}
