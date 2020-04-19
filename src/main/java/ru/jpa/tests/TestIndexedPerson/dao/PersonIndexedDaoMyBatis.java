package ru.jpa.tests.TestIndexedPerson.dao;

import org.apache.ibatis.session.SqlSession;
import ru.jpa.tests.TestIndexedPerson.model.PersonIndexed;
import ru.jpa.utils.MyBatisUtil;
import java.util.List;

public class PersonIndexedDaoMyBatis {
    public void save(PersonIndexed person) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("ru.mapper.mybatis.PersonIndexedMapper.insertPerson", person);
        session.commit();
        session.close();
    }

    public void update(String personName) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("ru.mapper.mybatis.PersonIndexedMapper.updatePerson", personName);
        session.commit();
        session.close();
    }

    public void delete(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("ru.mapper.mybatis.PersonIndexedMapper.deletePerson");
        session.commit();
        session.close();
    }

    public List<PersonIndexed> getAllPersons() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<PersonIndexed> personsList = session.selectList("PersonIndexedMapper.findAllPersons");
        session.commit();
        session.close();
        return personsList;
    }
}
