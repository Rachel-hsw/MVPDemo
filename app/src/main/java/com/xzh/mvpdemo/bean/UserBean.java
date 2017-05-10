package com.xzh.mvpdemo.bean;

/**
 * Created by zhenghangxia on 17-5-10.
 *
 *  用户登录的数据实体类
 */

public class UserBean {

    // 用户名
    private String userName;
    // 密码
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
