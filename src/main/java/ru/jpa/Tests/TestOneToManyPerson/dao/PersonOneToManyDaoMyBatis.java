package ru.jpa.Tests.TestOneToManyPerson.dao;

import org.apache.ibatis.session.SqlSession;
import ru.jpa.Tests.TestOneToManyPerson.model.AddressOneToMany;
import ru.jpa.Tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.utils.MyBatisUtil;

import java.util.List;

public class PersonOneToManyDaoMyBatis {

    public void save(PersonOneToMany person){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        AddressOneToMany address = new AddressOneToMany();
        session.insert("ru.mapper.mybatis.PersonOneToManyMapper.insertPerson", person);
        address.setPerson(person);
        address.setPerson_id(person.getPerson_id());
        session.insert("ru.mapper.mybatis.AddressOneToManyMapper.insertPerson", address);
        session.commit();
        session.close();
    }

    public List<PersonOneToMany> getAllPersons() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<PersonOneToMany> personsList = session.selectList("ru.mapper.mybatis.PersonOneToManyMapper.findAllPersons");
        session.commit();
        session.close();
        return personsList;
    }

    public void delete(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("ru.mapper.mybatis.PersonOneToManyMapper.deletePerson");
        session.commit();
        session.close();
    }

    public void update(String personName){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("ru.mapper.mybatis.PersonOneToManyMapper.updatePerson", personName);
        session.commit();
        session.close();
    }
}
