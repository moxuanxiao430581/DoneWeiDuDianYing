package com.example.doneweidudianying.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doneweidudianying.R;
import com.example.doneweidudianying.base.BaseActivity;
import com.example.doneweidudianying.base.BasePresenter;
import com.example.doneweidudianying.base64.EncryptUtil;
import com.example.doneweidudianying.bean.EmailBean;
import com.example.doneweidudianying.bean.RegisterBean;
import com.example.doneweidudianying.mvp.IPresenterImpl;
import com.example.doneweidudianying.url.BaseUrl;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends BaseActivity {

    private TextView code;
    private EditText emailcode;
    private EditText edname;
    private EditText email;
    private EditText pass;
    private TextView login;
    private Button register;
    private ImageView imagebt;
    private String encrypt;

    @Override
    protected void initData() {

        //邮箱
        //点击获取验证码
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = email.getText().toString().trim();
                if (trim.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    mPresenter.PresenterPostEmailInfo(BaseUrl.CodeUrl,trim, EmailBean.class);
                }
            }
        });
        //注册
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> map = new HashMap<>();
                String name = edname.getText().toString().trim();
                String email1 = email.getText().toString().trim();
                String emailcode2 = emailcode.getText().toString().trim();
                String pwd = pass.getText().toString().trim();
                if (name.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "昵称不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    map.put("nickName",name);
                }
                if (email1.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    map.put("email",email1);
                }
                if (pwd.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    encrypt = EncryptUtil.encrypt(pwd);
                    Log.i("密码加密", encrypt);
                    map.put("pwd",encrypt);
                }
                if(emailcode2.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    map.put("code",emailcode2);
                }
                mPresenter.PresenterPostRegisterInfo(BaseUrl.ResignUrl,map, RegisterBean.class);

            }
        });

        //点击已有账号
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭页面
                finish();
            }
        });
        //点击返回
        imagebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭页面
                finish();
            }
        });

    }

    @Override
    protected BasePresenter initPresenter() {
        return new IPresenterImpl();
    }

    @Override
    protected void initViews() {
        code = findViewById(R.id.tvcode);
        emailcode = findViewById(R.id.edemail);
        edname = findViewById(R.id.edname);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        imagebt = findViewById(R.id.imagebt);
    }

    @Override
    protected int initLaout() {
        return R.layout.activity_register;
    }

    @Override
    public void onSuccess(Object o) {
        //请求邮箱
        if (o instanceof EmailBean){
            if (((EmailBean) o).getStatus().equals("0000")){
                Toast.makeText(this, ((EmailBean) o).getMessage()+"", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, ((EmailBean) o).getMessage()+"", Toast.LENGTH_SHORT).show();
            }
        }
        //注册
        if (o instanceof RegisterBean){
            if (((RegisterBean) o).getStatus().equals("0000")){
                Toast.makeText(this, ((RegisterBean) o).getMessage()+"", Toast.LENGTH_SHORT).show();
                return;
            }else {
                Toast.makeText(this, ((RegisterBean) o).getMessage()+"", Toast.LENGTH_SHORT).show();
                return;
            }
        }

    }

    @Override
    public void onError(String error) {

    }
}
