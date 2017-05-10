package com.xzh.mvpdemo.view;

import com.xzh.mvpdemo.bean.UserBean;

/**
 * Created by zhenghangxia on 17-5-10.
 *
 *  自定义视图接口，用于 view 数据的获取与显示操作
 */

public interface ILoginView {

    // 获取用户名
    String getUserName();
    // 获取密码
    String getPassword();
    // 显示加载进度框
    void showLoading();
    // 隐藏加载进度框
    void hideLoading();
    // 登录成功
    void showSuccess(UserBean userBean);
    // 登录失败
    void showFailedError();

}
