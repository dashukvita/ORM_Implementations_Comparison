package ru.jpa.tests.imp;

import java.util.List;

public interface ITeastPersonAndPersonIndexed extends CrudEntitier {

    void createPerson(int num);
    List<?> getAllPersons();
    void updatePerson();
    void deletePerson();

    default void crudEntity(int num) {
        TimeBenchmark timeBenchmark = new TimeBenchmark();
        System.out.println("------------------Create Entities");
        timeBenchmark.measure(() -> createPerson(num));
        System.out.println("------------------Get All Entities");
        timeBenchmark.measure(this::getAllPersons);
        System.out.println("------------------Update Entities");
        timeBenchmark.measure(this::updatePerson);
        System.out.println("------------------Delete Entities");
        timeBenchmark.measure(this::deletePerson);
    }
}
