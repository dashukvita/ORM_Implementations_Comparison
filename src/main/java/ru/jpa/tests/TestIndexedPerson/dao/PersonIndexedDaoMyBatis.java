package ru.jpa.tests.TestIndexedPerson.dao;

import org.apache.ibatis.session.SqlSession;
import ru.jpa.tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.tests.TestPerson.model.Person;
import ru.jpa.utils.MyBatisUtil;
import java.util.List;

public class PersonIndexedDaoMyBatis {
    public void save(int num) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        for (int i = 0; i < num; i++) {
            session.insert("ru.mapper.mybatis.PersonIndexedMapper.insertPerson", new PersonIndexed());
        }
        session.commit();
        session.close();
    }

    public void update(String personName) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("ru.mapper.mybatis.PersonIndexedMapper.updatePerson", personName);
        session.commit();
        session.close();
    }

    public void delete(PersonIndexed person){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.selectList("ru.mapper.mybatis.PersonIndexedMapper.deletePersonById", person.getId());

        session.commit();
        session.close();
    }

    public List<PersonIndexed> getAllPersons() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<PersonIndexed> personsList = session.selectList("ru.mapper.mybatis.PersonIndexedMapper.findAllPersons");
        session.commit();
        session.close();
        return personsList;
    }
}
