package org.pcdd.javase.university.jdbctemplate.dao;

import org.pcdd.javase.university.jdbctemplate.entity.Admin;
import org.pcdd.javase.university.jdbctemplate.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AdminDaoImpl implements AdminDao {
    public String sql;
    JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    @Override
    public boolean login(String id, String pwd) {
        sql = " select count(*) from admin where aid = ? and pwd = ?";
        Long aLong = template.queryForObject(sql, Long.class, id, pwd);
        if (aLong == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<Admin> getAdminById(String id) {
        sql = "select aid,aname from admin where aid = ?";
        List<Admin> list = template.query(sql, new BeanPropertyRowMapper<>(Admin.class), id);
        return list;
    }
}
