package com.xzh.mvpdemo.model;

import com.xzh.mvpdemo.bean.UserBean;

/**
 * Created by zhenghangxia on 17-5-10.
 *
 *  自定义监听接口
 */
public interface OnLoginListener {

    // 登录成功
    void loginSuccess(UserBean userBean);

    // 登录失败
    void loginFailed();

}
