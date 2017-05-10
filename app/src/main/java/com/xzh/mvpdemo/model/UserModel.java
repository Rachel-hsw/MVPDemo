package com.xzh.mvpdemo.model;

import com.xzh.mvpdemo.bean.UserBean;

/**
 * Created by zhenghangxia on 17-5-10.
 *
 *  用户登录接口实现类
 *      实现 IUserModel 接口
 *      重写 login 方法
 *          开启线程： 线程睡眠 2s 模拟网络请求操作
 *                   判断用户名和密码是否正确： 是： 将用户名和密码保存到实体类中，调用监听器的 loginSuccess() 方法提示成功
 *                                          否： 调用监听器的 loginFailed() 方法提示失败
 */

public class UserModel implements IUserModel {

    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if ("admin".equals(username) && "admin".equals(password)) {
                    UserBean userBean = new UserBean();
                    userBean.setUserName(username);
                    userBean.setPassWord(password);
                    loginListener.loginSuccess(userBean);
                } else {
                    loginListener.loginFailed();
                }

            }
        }).start();
    }
}
