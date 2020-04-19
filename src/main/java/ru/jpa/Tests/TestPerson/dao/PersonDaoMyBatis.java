package ru.jpa.Tests.TestPerson.dao;

import org.apache.ibatis.session.SqlSession;
import ru.jpa.Tests.TestPerson.model.Person;
import ru.jpa.utils.MyBatisUtil;

import java.util.List;

public class PersonDaoMyBatis {
    public void save(Person person){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("ru.mapper.mybatis.PersonMapper.insertPerson", person);
        session.commit();
        session.close();
    }

    public void update(String personName){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("ru.mapper.mybatis.PersonMapper.updatePerson", personName);
        session.commit();
        session.close();
    }

    public void delete(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("ru.mapper.mybatis.PersonMapper.deletePerson");
        session.commit();
        session.close();
    }

    public Person getLastPerson(int id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        Person person = session.selectOne("ru.mapper.mybatis.PersonMapper.findLastPerson", id);
        session.commit();
        session.close();
        return person;
    }

    public List<Person> getAllPersons() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<Person> personsList = session.selectList("ru.mapper.mybatis.PersonMapper.findAllPersons");
        session.commit();
        session.close();
        return personsList;
    }
}
