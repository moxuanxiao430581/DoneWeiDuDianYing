package com.example.doneweidudianying.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doneweidudianying.R;
import com.example.doneweidudianying.adapter.QueryUserAdapter;
import com.example.doneweidudianying.base.BaseFragment;
import com.example.doneweidudianying.base.BasePresenter;
import com.example.doneweidudianying.bean.QueryuserBean;
import com.example.doneweidudianying.mvp.IPresenterImpl;
import com.example.doneweidudianying.url.BaseUrl;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment {


    private RecyclerView recy;
    private List<QueryuserBean.ResultBean> list = new ArrayList<>();

    @Override
    protected void initData() {
        //根据用户ID查询用户信息
        mPresenter.PresenterGetQueryuserInfo(BaseUrl.QueryuserUrl, QueryuserBean.class);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new IPresenterImpl();
    }

    @Override
    protected void initViews(View inflate) {
        recy = inflate.findViewById(R.id.myheadrecy);
        //布局管理器
        recy.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected int initLaout() {
        return R.layout.fragment_my;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof QueryuserBean){
            //根据用户ID查询用户信息
            if (((QueryuserBean) o).getStatus().equals("0000")){
                list.clear();
                list.add(((QueryuserBean) o).getResult());
               QueryUserAdapter adapter = new QueryUserAdapter(getContext(),list);
                recy.setAdapter(adapter);
            }
        }

    }

    @Override
    public void onError(String error) {

    }


}
