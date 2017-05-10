package com.xzh.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.xzh.mvpdemo.bean.UserBean;
import com.xzh.mvpdemo.presenter.LoginPresenter;
import com.xzh.mvpdemo.view.ILoginView;

/**
 *  LoginActivity 登录操作的 View 实现
 *
 *      实现 ILoginView 接口，并重写对应的方法
 *      创建 LoginPresenter 对象，将当前的 View 传递过去
 *      点击事件调用 LoginPresenter 的 login() 方法进行登录操作
 */
public class LoginActivity extends AppCompatActivity implements ILoginView {

    private EditText mAccountET;
    private EditText mPasswordET;
    private Button mLoginBtn;
    private LoginPresenter mLoginPresenter = new LoginPresenter(this);
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();
        setListener();

    }

    /**
     *  设置点击事件
     */
    private void setListener() {

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mLoginPresenter.login();

            }
        });

    }

    /**
     *  初始化控件
     */
    private void initUI() {

        mAccountET = (EditText) findViewById(R.id.accountET);
        mPasswordET = (EditText) findViewById(R.id.passwordET);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

    }

    @Override
    public String getUserName() {
        return mAccountET.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return mPasswordET.getText().toString().trim();
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSuccess(UserBean userBean) {
        Toast.makeText(this, userBean.getUserName() +
                " login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
