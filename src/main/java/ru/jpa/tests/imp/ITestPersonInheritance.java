package ru.jpa.tests.imp;

public interface ITestPersonInheritance extends CrudEntitier {

    void createPerson(int num);
    void deletePerson();

    default void crudEntity(int num) {
        TimeBenchmark timeBenchmark = new TimeBenchmark();
        System.out.println("------------------Create Entities");
        timeBenchmark.measure(() -> createPerson(num));
        System.out.println("------------------Delete Entities");
        timeBenchmark.measure(this::deletePerson);
    }
}
