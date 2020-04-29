package com.example.doneweidudianying.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doneweidudianying.R;
import com.example.doneweidudianying.adapter.SearchAdapter;
import com.example.doneweidudianying.base.BaseActivity;
import com.example.doneweidudianying.base.BasePresenter;
import com.example.doneweidudianying.bean.SearchBean;
import com.example.doneweidudianying.mvp.IPresenterImpl;
import com.example.doneweidudianying.url.BaseUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchActivity extends BaseActivity {

    private EditText searched;
    private ImageView searchimage;
    private RecyclerView searchrecy;
    private TextView searchtv;
    private ImageView searchwang;
    private String dianname;
    private SearchAdapter adapter;
    private TextView bt;

    @Override
    protected void initData() {
        //回退
        searchimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //搜索
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dianname = searched.getText().toString().trim();
                if (dianname.isEmpty()){
                    Toast.makeText(SearchActivity.this, "请填写关键词", Toast.LENGTH_SHORT).show();
                    searchrecy.setAdapter(null);
                    return;
                }else {
                    Map<String,Object> searchmap = new HashMap<>();
                    searchmap.put("keyword",dianname);
                    searchmap.put("page",1);
                    searchmap.put("count",5);
                    mPresenter.PresenterGetReceivedInfo(BaseUrl.InformationUrl,searchmap,SearchBean.class);
                    //设置
                    searchrecy.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
                }
            }
        });



    }

    @Override
    protected BasePresenter initPresenter() {
        return new IPresenterImpl();
    }

    @Override
    protected void initViews() {
        searched = findViewById(R.id.searched);
        searchimage = findViewById(R.id.searchimage);
        searchwang = findViewById(R.id.searchwang);
        searchtv = findViewById(R.id.searchtv);
        searchrecy = findViewById(R.id.searchrecy);
        bt = findViewById(R.id.searchimagebt);

    }

    @Override
    protected int initLaout() {
        return R.layout.activity_search;
    }

    @Override
    public void onSuccess(Object o) {
        //判空
        if (dianname.isEmpty()){

        }else {
            if (o instanceof SearchBean){
                if (((SearchBean) o).getMessage().equals("查询成功")){
                    adapter = new SearchAdapter(this,((SearchBean) o).getResult());
                    searchrecy.setAdapter(adapter);
                    searchtv.setText(null);
                    searchwang.setImageResource(0);
                    adapter.notifyDataSetChanged();
                }else {
                    searchrecy.setAdapter(null);
                    searchwang.setImageResource(R.mipmap.searchwang);
                    searchtv.setText(((SearchBean) o).getMessage()+"");
                }

            }
        }

    }

    @Override
    public void onError(String error) {

    }
}
