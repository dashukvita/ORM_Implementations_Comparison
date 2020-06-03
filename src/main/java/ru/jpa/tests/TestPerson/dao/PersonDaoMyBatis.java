package ru.jpa.tests.TestPerson.dao;

import org.apache.ibatis.session.SqlSession;
import ru.jpa.tests.TestPerson.model.Person;
import ru.jpa.utils.MyBatisUtil;

import java.util.List;

public class PersonDaoMyBatis {
    public void save(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("ru.mapper.mybatis.PersonMapper.insertPerson", new Person());
        session.commit();
        session.close();
    }

    public void update(String personName){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("ru.mapper.mybatis.PersonMapper.updatePerson", personName);
        session.commit();
        session.close();
    }

    public void delete(Person person){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.selectList("ru.mapper.mybatis.PersonMapper.deletePersonById", person.getId());

        session.commit();
        session.close();
    }

    public List<Person> getAllPersons() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<Person> personsList = session.selectList("ru.mapper.mybatis.PersonMapper.findAllPersons");
        session.commit();
        session.close();
        return personsList;
    }
}
