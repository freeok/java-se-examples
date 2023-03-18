package org.pcdd.javase.university.jdbctemplate.dao;

import org.pcdd.javase.university.jdbctemplate.entity.User;
import org.pcdd.javase.university.jdbctemplate.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    public String sql;
    JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    /***
     * 添加用户
     * @param id 学号
     * @param name 姓名
     * @param pwd 密码
     * @return 添加成功返回true，否则false
     */
    @Override
    public boolean add(String id, String name, String pwd) {
        sql = "insert into stu values(?,?,?)";
        int count = template.update(sql, id, name, pwd);
        if (count > 0) {
            return true;
        }
        return false;
    }

    /***
     * 根据id修改用户信息
     * @param id 学号
     * @param name 姓名
     * @param pwd 密码
     * @return 修改成功返回true，否则false
     */
    @Override
    public boolean update(String id, String name, String pwd) {
        sql = "update stu set sname = ?,pwd = ? where sid =?";
        int count = template.update(sql, name, pwd, id);
        if (count >= 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据id删除用户
     *
     * @param id 学号
     * @return 成功返回true
     */
    @Override
    public boolean delete(String id) {
        sql = "delete from stu where sid = ?";
        int count = template.update(sql, id);
        if (count > 0) {
            return true;
        }
        return false;
    }

    /***
     * 获取所有用户信息
     * @return 返回List集合
     */
    @Override
    public List<User> getUserAll() {
        sql = "select sid,sname from stu where sid != ?";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class), "admin");
        return list;
    }

    /***
     * 根据id查询用户信息
     * @param id 学号
     * @return 返回List集合
     */
    @Override
    public List<User> getUserById(String id) {
        sql = "select sid,sname from stu where sid = ?";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class), id);
        return list;
    }
}
