package com.example.doneweidudianying.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doneweidudianying.R;
import com.example.doneweidudianying.base.BaseActivity;
import com.example.doneweidudianying.base.BasePresenter;
import com.example.doneweidudianying.base64.EncryptUtil;
import com.example.doneweidudianying.bean.LoginBean;
import com.example.doneweidudianying.mvp.IPresenterImpl;
import com.example.doneweidudianying.url.BaseUrl;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity {

    private TextView resigntx;
    private Button loginbt;
    private EditText loginpass;
    private EditText loginemail;

    @Override
    protected void initData() {
        //点击无账号
        resigntx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        //点击登录
        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> map = new HashMap<>();
                //判空
                String emial = loginemail.getText().toString().trim();
                String pwd = loginpass.getText().toString().trim();
                if (emial.isEmpty()){
                    Toast.makeText(LoginActivity.this, "请填写邮箱", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    map.put("email",emial);
                }
                if (pwd.isEmpty()){
                    Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    map.put("pwd",pwd);
                }
                mPresenter.PresenterPostLoginInfo(BaseUrl.LoginUrl,map, LoginBean.class);
            }
        });


    }

    @Override
    protected BasePresenter initPresenter() {
        return new IPresenterImpl();
    }

    @Override
    protected void initViews() {
        resigntx = findViewById(R.id.resigntx);
        loginemail = findViewById(R.id.loginemail);
        loginpass = findViewById(R.id.loginpass);
        loginbt = findViewById(R.id.loginbt);
    }

    @Override
    protected int initLaout() {
        return R.layout.activity_login;
    }

    @Override
    public void onSuccess(Object o) {
        //登录
        if (o instanceof LoginBean){
            if (((LoginBean) o).getStatus().equals("0000")){
                Toast.makeText(this, ((LoginBean) o).getMessage()+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,TabActivity.class);
                startActivity(intent);
                //关闭当前页面
                finish();
            }else {
                Toast.makeText(this, ((LoginBean) o).getMessage()+"", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
