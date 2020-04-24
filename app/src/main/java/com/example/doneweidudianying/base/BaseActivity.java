package com.example.doneweidudianying.base;

import android.os.Bundle;

import com.example.doneweidudianying.R;
import com.example.doneweidudianying.contract.IContract;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IContract.IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLaout());
        initViews();
        mPresenter=initPresenter();
        if (mPresenter!=null){
            mPresenter.onBinding(this);
        }
        initData();
    }

    protected abstract void initData();

    protected abstract P initPresenter();

    protected abstract void initViews();

    protected abstract int initLaout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestruction();
    }
}
