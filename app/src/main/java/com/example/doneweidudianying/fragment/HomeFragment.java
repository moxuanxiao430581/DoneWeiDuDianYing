package com.example.doneweidudianying.fragment;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doneweidudianying.R;
import com.example.doneweidudianying.activity.SearchActivity;
import com.example.doneweidudianying.adapter.PopularAdapter;
import com.example.doneweidudianying.adapter.ReceivedAdapter;
import com.example.doneweidudianying.adapter.SoonAdapter;
import com.example.doneweidudianying.base.BaseFragment;
import com.example.doneweidudianying.base.BasePresenter;
import com.example.doneweidudianying.bean.PopularBean;
import com.example.doneweidudianying.bean.ReceivedBean;
import com.example.doneweidudianying.bean.SoonBean;
import com.example.doneweidudianying.bean.XBannerBean;
import com.example.doneweidudianying.mvp.IPresenterImpl;
import com.example.doneweidudianying.net.NetGlide;
import com.example.doneweidudianying.url.BaseUrl;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private XBanner xBanner;
    private List<XBannerBean.ResultBean> list = new ArrayList<>();
    private TextView xbcount;
    private TextView xbpotin;
    private RecyclerView ryingrecy;
    private RecyclerView jijiangrecy;
    private RecyclerView rmenrecy;
    private ImageView homesearch;

    @Override
    protected void initData() {
        //查询banner
        mPresenter.PresenterGetXBannerInfo(BaseUrl.XBannerUrl, XBannerBean.class);
        //查询正在上映电影列表
        Map<String,Object> receivedmap = new HashMap<>();
        receivedmap.put("page",1);
        receivedmap.put("count",10);
        mPresenter.PresenterGetReceivedInfo(BaseUrl.ReceivedUrl,receivedmap, ReceivedBean.class);
        //即将上映
        Map<String,Object> soonmap = new HashMap<>();
        soonmap.put("page",1);
        soonmap.put("count",3);
        mPresenter.PresenterGetReceivedInfo(BaseUrl.SoonUrl,soonmap, SoonBean.class);
        //热门电影
        Map<String,Object> popularmap = new HashMap<>();
        popularmap.put("page",2);
        popularmap.put("count",3);
        mPresenter.PresenterGetReceivedInfo(BaseUrl.PopularUrl,popularmap, PopularBean.class);
        //根据关键字查询电影信息
        homesearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected BasePresenter initPresenter() {
        return new IPresenterImpl();
    }

    @Override
    protected void initViews(View inflate) {
        //banner
        xBanner = inflate.findViewById(R.id.xxbanner);
        //总数
        xbcount = inflate.findViewById(R.id.xbcount);
        //具体页面
        xbpotin = inflate.findViewById(R.id.xbpotin);
        //正在热映
        ryingrecy = inflate.findViewById(R.id.ryingrecy);
        ryingrecy.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        //即将上映
        jijiangrecy = inflate.findViewById(R.id.jijiangrecy);
        jijiangrecy.setLayoutManager(new LinearLayoutManager(getContext()));
        //热门电影
        rmenrecy = inflate.findViewById(R.id.rmenrecy);
        rmenrecy.setLayoutManager(new GridLayoutManager(getContext(),3));
        //根据关键字查询电影信息
        homesearch = inflate.findViewById(R.id.homesearch);

    }

    @Override
    protected int initLaout() {
        return R.layout.fragment_home;
    }

    @Override
    public void onSuccess(Object o) {
        //查询banner
        if (o instanceof XBannerBean){
            if (((XBannerBean) o).getStatus().equals("0000")){
                list.clear();
                list.addAll(((XBannerBean) o).getResult());
                //设置XBanner数据
                xBanner.setBannerData(list);
                //设置适配器
                xBanner.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        //设置数据
                        NetGlide.GlideImage(list.get(position).getImageUrl(), (ImageView) view);
                        xbcount.setText(list.size()+"");
                        xbpotin.setText(position+1+"");
                        //设置XBanner自动滑动速度
                        xBanner.setPageChangeDuration(1000);
                    }
                });
            }
        }
        //正在热映
        if (o instanceof ReceivedBean){
            if (((ReceivedBean) o).getStatus().equals("0000")){
                ReceivedAdapter adapter = new ReceivedAdapter(getContext(),((ReceivedBean) o).getResult());
                ryingrecy.setAdapter(adapter);
            }
        }
        //即将上映
        if (o instanceof SoonBean){
            SoonAdapter adapter = new SoonAdapter(getContext(),((SoonBean) o).getResult());
            jijiangrecy.setAdapter(adapter);
        }
        //热门电影
        if (o instanceof PopularBean){
            PopularAdapter adapter = new PopularAdapter(getContext(),((PopularBean) o).getResult());
            rmenrecy.setAdapter(adapter);
        }


    }

    @Override
    public void onError(String error) {

    }
}
