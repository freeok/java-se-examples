package org.pcdd.javase.university.jdbctemplate.entity;

public class User {
    private String sid;
    private String sname;
    private String pwd;

    public User() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }
}
