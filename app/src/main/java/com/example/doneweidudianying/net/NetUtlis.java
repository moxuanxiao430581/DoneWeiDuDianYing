package com.example.doneweidudianying.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.doneweidudianying.api.ApiServer;
import com.example.doneweidudianying.app.App;
import com.example.doneweidudianying.url.BaseUrl;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetUtlis {

    private final ApiServer apiServer;

    public NetUtlis() {
        //日志拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //设置拦截器的请求体
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //OKHTTP
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                //添加拦截器
                .addInterceptor(interceptor)
                //添加自定义拦截器
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder = request.newBuilder();
                        //添加请求头
                        SharedPreferences queryuser = App.mContext.getSharedPreferences("Queryuser", Context.MODE_PRIVATE);
                        //获取请求头
                        int userId = queryuser.getInt("userId", 0);
                        String sessionId = queryuser.getString("sessionId", "");
                        Log.i("userId",userId+"");
                        Log.i("sessionId",sessionId+"");
                        //设置请求头
                        builder.addHeader("userId",userId+"");
                        builder.addHeader("sessionId",sessionId);
                        Request build = builder.build();
                        return chain.proceed(build);
                    }
                }).build();
        //Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                //网址前半
                .baseUrl(BaseUrl.Base)
                //关联客户端OKHTTP
                .client(okHttpClient)
                //添加RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //添加Gson解析功能
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiServer = retrofit.create(ApiServer.class);
    }
    //懒汉式
    private static class NetCall{
        private static NetUtlis netUtlis = new NetUtlis();
    }

    public static NetUtlis getInstance() {
        return NetCall.netUtlis;
    }
    //接口回调
    public interface NetCallBack<T>{
        void onSuccess(T t);
        void onError(String error);
    }
    //请求方式
    //邮箱请求
    public void PostEmailInfo(String url, String email, final Class cls, final NetCallBack callBack){
        apiServer.PostEmailInfo(url,email).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            callBack.onSuccess(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //注册请求
    public void PostRegisterInfo(String url, Map<String,Object> map, final Class cls, final NetCallBack callBack){
        apiServer.PostRegisterInfo(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            callBack.onSuccess(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //登录请求
    public void PostLoginInfo(String url, Map<String,Object> map, final Class cls, final NetCallBack callBack){
        apiServer.PostRegisterInfo(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            callBack.onSuccess(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //根据用户ID查询用户信息请求
    public void GetQueryuserInfo(String url, final Class cls, final NetCallBack callBack){
       apiServer.GetQueryuserInfo(url).subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<ResponseBody>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                       try {
                           Object o = gson.fromJson(responseBody.string(), cls);
                           callBack.onSuccess(o);
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }

                   @Override
                   public void onError(Throwable e) {

                   }

                   @Override
                   public void onComplete() {

                   }
               });
    }
    //查询banner
    public void GetXBannerInfo(String url, final Class cls, final NetCallBack callBack){
        apiServer.GetQueryuserInfo(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            callBack.onSuccess(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
