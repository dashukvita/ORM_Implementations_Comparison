package ru.jpa.tests.TestOneToManyPerson.dao;

import org.apache.ibatis.session.SqlSession;
import ru.jpa.tests.TestOneToManyPerson.model.AddressOneToMany;
import ru.jpa.tests.TestOneToManyPerson.model.PersonOneToMany;
import ru.jpa.utils.MyBatisUtil;

import java.util.List;

public class PersonOneToManyDaoMyBatis {

    public void save(PersonOneToMany person){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        AddressOneToMany homeAddress = new AddressOneToMany();
        AddressOneToMany workAddress = new AddressOneToMany();
        session.insert("ru.mapper.mybatis.PersonOneToManyMapper.insertPerson", person);
        homeAddress.setPerson(person);
        workAddress.setPerson(person);
        session.insert("ru.mapper.mybatis.AddressOneToManyMapper.insertPerson", homeAddress);
        session.insert("ru.mapper.mybatis.AddressOneToManyMapper.insertPerson", workAddress);
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

    public void delete(PersonOneToMany person){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.selectList("ru.mapper.mybatis.AddressOneToManyMapper.deleteAddressById", person.getPerson_id());
        session.selectList("ru.mapper.mybatis.PersonOneToManyMapper.deletePersonById", person.getPerson_id());

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
