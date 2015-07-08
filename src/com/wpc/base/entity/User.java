package com.wpc.base.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-5-8
 * Time: 下午3:45
 * 此对象是所有系统的基础对象
 * 对应于 系统账户，区别于业务账户
 *
 */
public class User {
    int user_id;
    String user_name;
    String user_password;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + user_password + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
