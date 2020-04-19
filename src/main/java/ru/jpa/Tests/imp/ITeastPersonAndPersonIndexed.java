package ru.jpa.Tests.imp;

import ru.jpa.Tests.TestPerson.model.Person;

import java.util.List;

public interface ITeastPersonAndPersonIndexed {

    void createPerson();
    List<?> getAllPersons();
    Object getLastPerson();
    void updatePerson();
    void deletePerson();

    default void crudEntity(int num) {
        TimeBenchmark timeBenchmark = new TimeBenchmark();
        System.out.println("------------------Create Entities------------------");
//        timeBenchmark.measure(this::createPerson, num);
        System.out.println("------------------Find Entities------------------");
//        timeBenchmark.measureOneTime(this::getAllPersons);
        System.out.println("------------------Find Last Entity------------------");
//        timeBenchmark.measureOneTime(this::getLastPerson);
        System.out.println("------------------Update Entities------------------");
//        timeBenchmark.measureOneTime(this::updatePerson);
        System.out.println("------------------Delete Entities------------------");
        timeBenchmark.measureOneTime(this::deletePerson);
    }
}
