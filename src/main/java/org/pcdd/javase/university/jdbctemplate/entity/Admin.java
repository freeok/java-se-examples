package org.pcdd.javase.university.jdbctemplate.entity;

public class Admin {
    private String aid;
    private String aname;
    private String pwd;

    public Admin() {
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid='" + aid + '\'' +
                ", aname='" + aname + '\'' +
                '}';
    }
}
