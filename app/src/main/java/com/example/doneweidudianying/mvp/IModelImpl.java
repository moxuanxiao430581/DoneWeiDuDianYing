package com.example.doneweidudianying.mvp;

import com.example.doneweidudianying.contract.IContract;
import com.example.doneweidudianying.net.NetUtlis;

import java.util.Map;

public class IModelImpl implements IContract.IModel {
    //邮箱
    @Override
    public void ModelPostEmailInfo(String url, String email, Class cls, final IContract.ICallBack callBack) {
        NetUtlis.getInstance().PostEmailInfo(url, email, cls, new NetUtlis.NetCallBack() {
            @Override
            public void onSuccess(Object o) {
                callBack.onSuccess(o);
            }

            @Override
            public void onError(String error) {

            }
        });
    }
    //注册
    @Override
    public void ModelPostRegisterInfo(String url, Map<String, Object> map, Class cls, final IContract.ICallBack callBack) {
        NetUtlis.getInstance().PostRegisterInfo(url, map, cls, new NetUtlis.NetCallBack() {
            @Override
            public void onSuccess(Object o) {
                callBack.onSuccess(o);
            }

            @Override
            public void onError(String error) {

            }
        });
    }
    //登录
    @Override
    public void ModelPostLoginInfo(String url, Map<String, Object> map, Class cls, final IContract.ICallBack callBack) {
        NetUtlis.getInstance().PostLoginInfo(url, map, cls, new NetUtlis.NetCallBack() {
            @Override
            public void onSuccess(Object o) {
                callBack.onSuccess(o);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

}
