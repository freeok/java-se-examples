package org.pcdd.javase.chapter20_数据库编程.jdbctemplate.dao;

import org.pcdd.javase.chapter20_数据库编程.jdbctemplate.entity.User;

import java.util.List;


public interface UserDao {

    public boolean add(String id, String name, String pwd);

    public boolean update(String id, String name, String pwd);

    public boolean delete(String id);

    public List<User> getUserAll();

    public List<User> getUserById(String id);
}
