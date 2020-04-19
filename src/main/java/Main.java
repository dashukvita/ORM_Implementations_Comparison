import org.apache.ibatis.session.SqlSession;
import ru.jpa.Tests.TestOneToManyPerson.model.AddressOneToMany;
import ru.jpa.Tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.Tests.TestOneToManyPerson.test.EclipseLinkTestPersonOneToMany;
import ru.jpa.Tests.TestOneToManyPerson.test.HibernateTestPersonOneToMany;
import ru.jpa.Tests.TestOneToManyPerson.test.MyBatisTestPersonOneToMany;
import ru.jpa.Tests.TestOneToManyPerson.test.OpenJPATestPersonOneToMany;
import ru.jpa.utils.MyBatisUtil;

public class Main {

    public static void main(String[] args) {

        new MyBatisTestPersonOneToMany().createPerson();
//        new HibernateTestPersonOneToMany().crudEntity(10);

//        Test Person Indexed
        //CRUD for 10 Persons
//        new HibernateTestPersonIndexed().crudEntity(10);
//        new EclipseLinkTestPersonIndexed().crudEntity(10);
//        new OpenJPATestPersonIndexed().crudEntity(10);
//        new MyBatisTestPersonIndexed().crudEntity(10);
//      //CRUD for 1000 Persons
//        new HibernateTestPersonIndexed().crudEntity(1000)
//        new EclipseLinkTestPersonIndexed().crudEntity(1000);
//        new OpenJPATestPersonIndexed().crudEntity(1000);
//        new MyBatisTestPersonIndexed().crudEntity(1000);
//      //CRUD for 10000 Persons
//        new HibernateTestPersonIndexed().crudEntity(10000)
//        new EclipseLinkTestPersonIndexed().crudEntity(10000);
//        new OpenJPATestPersonIndexed().crudEntity(10000);
//        new MyBatisTestPersonIndexed().crudEntity(10000);

//        Test JPQL
        //CRUD for 10 Persons
//        new HibernateTestPersonHQL().crudEntity(10);
//        new EclipseLinkTestPersonJPQL().crudEntity(10);
//        new OpenJPATestPersonJPQL().crudEntity(10);
//      //CRUD for 1000 Persons
//        new HibernateTestPersonHQL().crudEntity(1000);
//        new EclipseLinkTestPersonJPQL().crudEntity(1000);
//        new OpenJPATestPersonJPQL().crudEntity(1000);
//      //CRUD for 10000 Persons
//        new HibernateTestPersonHQL().crudEntity(10000);
//        new EclipseLinkTestPersonJPQL().crudEntity(10000);
//        new OpenJPATestPersonJPQL().crudEntity(10000);

//        Test Inheritance
        //CRUD for 10 Persons
//        new HibernateTestPersonExt().crudEntity(10);
//        new OpenJPATestPersonExt().crudEntity(10);
//        new EclipseLinkTestPersonExt().crudEntity(10);
//      //CRUD for 1000 Persons
//        new HibernateTestPersonExt().crudEntity(1000);
//        new OpenJPATestPersonExt().crudEntity(1000);
//        new EclipseLinkTestPersonExt().crudEntity(1000);
//        //CRUD for 10000 Persons
//        new HibernateTestPersonExt().crudEntity(10000);
//        new OpenJPATestPersonExt().crudEntity(10000);
//        new EclipseLinkTestPersonExt().crudEntity(10000);

        //Collection Test Person
        //CRUD for 10 Persons
//        new HibernateTestPersonCollection().crudEntity(10);
//        new EclipseLinkTestPersonCollection().crudEntity(10);
//        new OpenJPATestPersonCollection().crudEntity(10);
//      //CRUD for 1000 Persons
//        new HibernateTestPersonCollection().crudEntity(1000);
//        new EclipseLinkTestPersonCollection().crudEntity(1000);
//        new OpenJPATestPersonCollection().crudEntity(1000);
//        //CRUD for 10000 Persons
//        new HibernateTestPersonCollection().crudEntity(10000);
//        new EclipseLinkTestPersonCollection().crudEntity(10000);
//        new OpenJPATestPersonCollection().crudEntity(10000);

        //One to Many Test Person
        //CRUD for 10 Persons
//        new HibernateTestPersonOneToMany().crudEntity(10);
//        new OpenJPATestPersonOneToMany().crudEntity(10);
//        new EclipseLinkTestPersonOneToMany().crudEntity(10);
//      //CRUD for 1000 Persons
//        new HibernateTestPersonOneToMany().crudEntity(1000);
//        new OpenJPATestPersonOneToMany().crudEntity(1000);
//        new EclipseLinkTestPersonOneToMany().crudEntity(1000);
//      //CRUD for 10000 Persons
//        new HibernateTestPersonOneToMany().crudEntity(10000);
//        new OpenJPATestPersonOneToMany().crudEntity(10000);
//        new EclipseLinkTestPersonOneToMany().crudEntity(10000);

        //Basic Test Person
        //CRUD for 10 Persons
//        new HibernateTestPerson().crudEntity(10);
//        new EclipseLinkTestPerson().crudEntity(10);
//        new OpenJPATestPerson().crudEntity(10);
//        new MyBatisTestPerson().crudEntity(10);
//      //CRUD for 1000 Persons
//        new HibernateTestPerson().crudEntity(1000);
//        new EclipseLinkTestPerson().crudEntity(1000);
//        new OpenJPATestPerson().crudEntity(1000);
//        new MyBatisTestPerson().crudEntity(1000);
//      //CRUD for 10000 Persons
//        new HibernateTestPerson().crudEntity(10000);
//        new EclipseLinkTestPerson().crudEntity(10000);
//        new OpenJPATestPerson().crudEntity(10000);
//        new MyBatisTestPerson().crudEntity(10000);
    }
}

