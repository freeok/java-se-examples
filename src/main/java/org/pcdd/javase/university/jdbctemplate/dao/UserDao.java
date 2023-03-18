package org.pcdd.javase.university.jdbctemplate.dao;

import org.pcdd.javase.university.jdbctemplate.entity.User;

import java.util.List;


public interface UserDao {

    public boolean add(String id, String name, String pwd);

    public boolean update(String id, String name, String pwd);

    public boolean delete(String id);

    public List<User> getUserAll();

    public List<User> getUserById(String id);
}
