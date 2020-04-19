package ru.jpa.utils;

import ru.jpa.Tests.TestCollectionPerson.model.AddressCollection;
import ru.jpa.Tests.TestCollectionPerson.model.PersonCollection;
import ru.jpa.Tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.Tests.TestInheritancePerson.model.PersonBase;
import ru.jpa.Tests.TestInheritancePerson.model.PersonExt;
import ru.jpa.Tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.Tests.TestJPQLPerson.model.SimplePerson;
import ru.jpa.Tests.TestOneToManyPerson.model.AddressOneToMany;
import ru.jpa.Tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.Tests.TestPerson.model.Person;
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
                configuration.addAnnotatedClass(PersonOneToMany.class);
                configuration.addAnnotatedClass(AddressOneToMany.class);
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
