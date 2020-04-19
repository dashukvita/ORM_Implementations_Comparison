package ru.jpa.Tests.imp;

import java.util.List;

public interface ITestOneToManyAndCollection {

    void createPerson();
    List<?> getAllPersons();
    void updatePerson();
    void deletePerson();

    default void crudEntity(int num) {
        TimeBenchmark timeBenchmark = new TimeBenchmark();
        System.out.println("------------------Create Entities------------------");
        timeBenchmark.measure(this::createPerson, num);
        System.out.println("------------------Find Entities------------------");
//        timeBenchmark.measureOneTime(this::getAllPersons);
        System.out.println("------------------Find Entities with Address------------------");
//        timeBenchmark.measureOneTime(this::updatePerson);
        System.out.println("------------------Delete Entities------------------");
//        timeBenchmark.measureOneTime(this::deletePerson);
    }
}
