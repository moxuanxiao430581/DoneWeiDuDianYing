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
    }


}
