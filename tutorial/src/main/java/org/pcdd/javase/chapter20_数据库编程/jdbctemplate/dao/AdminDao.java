package org.pcdd.javase.chapter20_数据库编程.jdbctemplate.dao;


import org.pcdd.javase.chapter20_数据库编程.jdbctemplate.entity.Admin;

import java.util.List;

public interface AdminDao {
    public boolean login(String id, String pwd);

    public List<Admin> getAdminById(String id);
}
