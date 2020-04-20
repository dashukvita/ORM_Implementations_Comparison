package ru.jpa.utils;

import ru.jpa.tests.TestCollectionPerson.model.AddressCollection;
import ru.jpa.tests.TestCollectionPerson.model.PersonCollection;
import ru.jpa.tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.tests.TestInheritancePerson.model.PersonBase;
import ru.jpa.tests.TestInheritancePerson.model.PersonExt;
import ru.jpa.tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.tests.TestJPQLPerson.model.SimplePerson;
import ru.jpa.tests.TestOneToManyPerson.model.AddressOneToMany;
import ru.jpa.tests.TestOneToManyPerson.model.AddressOneToManyHib;
import ru.jpa.tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.model.PersonOneToManyHib;
import ru.jpa.tests.TestPerson.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(AddressCollection.class);
                configuration.addAnnotatedClass(PersonCollection.class);
                configuration.addAnnotatedClass(PersonOneToManyHib.class);
                configuration.addAnnotatedClass(AddressOneToManyHib.class);
                configuration.addAnnotatedClass(PersonBase.class);
                configuration.addAnnotatedClass(PersonExt.class);
                configuration.addAnnotatedClass(PersonExtExt.class);
                configuration.addAnnotatedClass(SimplePerson.class);
                configuration.addAnnotatedClass(PersonIndexed.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
