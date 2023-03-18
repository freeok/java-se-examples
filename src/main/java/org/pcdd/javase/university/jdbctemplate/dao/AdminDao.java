package org.pcdd.javase.university.jdbctemplate.dao;


import org.pcdd.javase.university.jdbctemplate.entity.Admin;

import java.util.List;

public interface AdminDao {
    public boolean login(String id, String pwd);

    public List<Admin> getAdminById(String id);
}
