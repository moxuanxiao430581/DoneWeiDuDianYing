package com.example.doneweidudianying.base;

import com.example.doneweidudianying.contract.IContract;

import java.lang.ref.WeakReference;

public  abstract class BasePresenter<V extends IContract.IView> implements IContract.IPresenter {
    protected WeakReference<V> reference;

    public BasePresenter() {
        initModel();
    }
    protected void onBinding(V v){
        reference  =new WeakReference<>(v);
    }
    protected void onDestruction(){
        if (reference!=null){
            reference.clear();
            reference=null;
        }
    }
    public V getView(){
        return reference.get();
    }

    protected abstract void initModel();

}
