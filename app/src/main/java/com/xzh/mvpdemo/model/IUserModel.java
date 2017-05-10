package com.xzh.mvpdemo.model;

/**
 * Created by zhenghangxia on 17-5-10.
 *
 *  自定义用户登录接口
 */

public interface IUserModel {

    /**
     *  登录操作
     *
     * @param username
     *              用户名
     * @param password
     *              密码
     * @param loginListener
     *              自定义监听事件
     */
    void login(String username, String password, OnLoginListener loginListener);

}
