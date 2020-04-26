package com.example.doneweidudianying.mvp;

import com.example.doneweidudianying.base.BasePresenter;
import com.example.doneweidudianying.contract.IContract;

import java.util.Map;

public class IPresenterImpl extends BasePresenter {

    private IModelImpl iModel;

    @Override
    protected void initModel() {
        iModel = new IModelImpl();
    }
    //邮箱
    @Override
    public void PresenterPostEmailInfo(String url,String email ,Class cls) {
        iModel.ModelPostEmailInfo(url, email, cls, new IContract.ICallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {

            }
        });
    }
    //注册
    @Override
    public void PresenterPostRegisterInfo(String url, Map<String, Object> map, Class cls) {
        iModel.ModelPostRegisterInfo(url, map, cls, new IContract.ICallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {

            }
        });
    }
    //登录
    @Override
    public void PresenterPostLoginInfo(String url, Map<String, Object> map, Class cls) {
        iModel.ModelPostLoginInfo(url, map, cls, new IContract.ICallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {

            }
        });
    }
    //根据用户ID查询用户信息
    @Override
    public void PresenterGetQueryuserInfo(String url, Class cls) {
        iModel.ModelGetQueryuserInfo(url, cls, new IContract.ICallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {

            }
        });
    }
    //查询banner
    @Override
    public void PresenterGetXBannerInfo(String url, Class cls) {
        iModel.ModelGetXBannerInfo(url, cls, new IContract.ICallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {

            }
        });
    }
    //查询正在上映电影列表
    @Override
    public void PresenterGetReceivedInfo(String url, Map<String, Object> map, Class cls) {
        iModel.ModelGettReceivedInfo(url, map, cls, new IContract.ICallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

}
