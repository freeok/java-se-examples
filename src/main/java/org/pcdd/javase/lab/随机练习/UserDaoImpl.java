package org.pcdd.javase.lab.随机练习;

import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean login(String id, String pwd) {
        String sql = "select sid,sname,pwd from stu where sid='" + id + "'and pwd='" + pwd + "'";
        boolean flag = false;
        try {
            Jdbc.init();
            ResultSet rs = Jdbc.selectSql(sql);
            String name = null;

            while (rs.next()) {
                if (rs.getString("sid").equals(id) && rs.getString("pwd").equals(pwd)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Jdbc.close();
            return flag;
            // or return rs.newt();
        }
    }
}
