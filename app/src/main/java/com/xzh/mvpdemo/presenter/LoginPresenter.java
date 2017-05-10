package com.xzh.mvpdemo.presenter;

import android.os.Handler;

import com.xzh.mvpdemo.bean.UserBean;
import com.xzh.mvpdemo.model.OnLoginListener;
import com.xzh.mvpdemo.model.UserModel;
import com.xzh.mvpdemo.view.ILoginView;

/**
 * Created by zhenghangxia on 17-5-10.
 *
 *  Model 与 View 之间的桥梁， 完成两者之间的交互
 *
 *      创建一个构造器，用于接受传递的 View ，并创建一个 UserModel 对象
 *      调用 userodel 的 login() 方法获取登录操作的返回结果，并执行对应的登录效果
 */

public class LoginPresenter {

    private final ILoginView iLoginView;
    private final UserModel userModel;
    private Handler mHandler = new Handler();

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        this.userModel = new UserModel();
    }

    public void login() {

        iLoginView.showLoading();
        userModel.login(iLoginView.getUserName(), iLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final UserBean userBean) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        iLoginView.showSuccess(userBean);
                        iLoginView.hideLoading();

                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        iLoginView.showFailedError();
                        iLoginView.hideLoading();
                    }
                });
            }
        });

    }

}
