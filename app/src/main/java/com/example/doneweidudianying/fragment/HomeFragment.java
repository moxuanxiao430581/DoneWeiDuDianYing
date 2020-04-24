package com.example.doneweidudianying.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.doneweidudianying.R;
import com.example.doneweidudianying.base.BaseFragment;
import com.example.doneweidudianying.base.BasePresenter;
import com.example.doneweidudianying.bean.XBannerBean;
import com.example.doneweidudianying.mvp.IPresenterImpl;
import com.example.doneweidudianying.net.NetGlide;
import com.example.doneweidudianying.url.BaseUrl;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private XBanner xBanner;
    private List<XBannerBean.ResultBean> list = new ArrayList<>();

    @Override
    protected void initData() {
        //查询banner
        mPresenter.PresenterGetXBannerInfo(BaseUrl.XBannerUrl, XBannerBean.class);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new IPresenterImpl();
    }

    @Override
    protected void initViews(View inflate) {
        //查询banner
        xBanner = inflate.findViewById(R.id.xxbanner);
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
                    }
                });

            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
