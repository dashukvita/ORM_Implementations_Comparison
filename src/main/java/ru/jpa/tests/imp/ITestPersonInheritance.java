package ru.jpa.tests.imp;

import ru.jpa.tests.TestInheritancePerson.model.PersonExtExt;

import java.util.List;

public interface ITestPersonInheritance extends CrudEntitier {

    void createPerson(int num);
    List<?> getAllPersons();
    void deletePerson();

    default void crudEntity(int num) {
        TimeBenchmark timeBenchmark = new TimeBenchmark();
        System.out.println("------------------Create Entities");
        timeBenchmark.measure(() -> createPerson(num));
        System.out.println("------------------Get All Entities");
        timeBenchmark.measure(this::getAllPersons);
        System.out.println("------------------Delete Entities");
        timeBenchmark.measure(this::deletePerson);
    }
}
