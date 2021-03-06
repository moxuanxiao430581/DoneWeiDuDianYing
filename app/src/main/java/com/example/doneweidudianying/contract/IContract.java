package com.example.doneweidudianying.contract;

import java.util.Map;

public interface IContract {
    //Model
    interface IModel{
        //邮箱
        void ModelPostEmailInfo(String url,String email,Class cls,ICallBack callBack);
        //注册
        void ModelPostRegisterInfo(String url, Map<String,Object> map, Class cls, ICallBack callBack);
        //登录
        void ModelPostLoginInfo(String url, Map<String,Object> map, Class cls, ICallBack callBack);
        //根据用户ID查询用户信息
        void ModelGetQueryuserInfo(String url, Class cls, ICallBack callBack);
        //查询banner
        void ModelGetXBannerInfo(String url, Class cls, ICallBack callBack);
        //查询正在上映电影列表
        void ModelGettReceivedInfo(String url, Map<String,Object> map, Class cls, ICallBack callBack);
    }

    //接口回调
    interface ICallBack<T>{
        void onSuccess(T t);
        void onError(String error);
    }

    //view
    interface IView<T>{
        void onSuccess(T t);
        void onError(String error);
    }
    //P层
    //接口回调
    interface IPresenter{
        //邮箱
        void PresenterPostEmailInfo(String url,String email,Class cls);
        //注册
        void PresenterPostRegisterInfo(String url, Map<String,Object> map, Class cls);
        //登录
        void PresenterPostLoginInfo(String url, Map<String,Object> map, Class cls);
        //根据用户ID查询用户信息
        void PresenterGetQueryuserInfo(String url, Class cls);
        //查询banner
        void PresenterGetXBannerInfo(String url, Class cls);
        //查询正在上映电影列表
        void PresenterGetReceivedInfo(String url, Map<String,Object> map, Class cls);
    }


}
