package com.example.doneweidudianying.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.example.doneweidudianying.R;
import com.example.doneweidudianying.fragment.CinemaFragment;
import com.example.doneweidudianying.fragment.HomeFragment;
import com.example.doneweidudianying.fragment.MyFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> stringList = new ArrayList<>();
    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        initViews();
        initData();
    }

    private void initViews() {
        vp = findViewById(R.id.vp);
        tab = findViewById(R.id.tab);
    }
    //数据
    private void initData(){

        //创建fragment对象
        HomeFragment homeFragment = new HomeFragment();
        CinemaFragment cinemaFragment = new CinemaFragment();
        MyFragment myFragment = new MyFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(cinemaFragment);
        fragmentList.add(myFragment);
        //添加标题
        stringList.add("电影");
        stringList.add("影院");
        stringList.add("我的");
        //设置适配器
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        //默认选中第一个
        vp.setCurrentItem(0);
        //选择指示灯
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override//当选中的时候加载图片
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.mipmap.movered);
                        tab.setText(stringList.get(0));

                        break;
                    case 1:
                        tab.setIcon(R.mipmap.cinemared);
                        tab.setText(stringList.get(1));
                        break;
                    case 2:
                        tab.setIcon(R.mipmap.myred);
                        tab.setText(stringList.get(2));
                        break;
                }

            }

            @Override//未选中的时候加载图片
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.mipmap.movebat);
                        tab.setText(null);
                        break;
                    case 1:

                        tab.setIcon(R.mipmap.cinemabat);
                        tab.setText(null);
                        break;
                    case 2:
                        tab.setIcon(R.mipmap.mybat);
                        tab.setText(null);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //关联
        tab.setupWithViewPager(vp);
        //默认加载  关联后才能获取getTabAt
        tab.getTabAt(1).setIcon(R.mipmap.cinemabat);
        tab.getTabAt(2).setIcon(R.mipmap.mybat);
    }
}
