package com.example.doneweidudianying.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiServer {
    //邮箱
    @POST
    @FormUrlEncoded
    Observable<ResponseBody> PostEmailInfo(@Url String url, @Field("email") String email);
    //注册  //登录
    @POST
    @FormUrlEncoded
    Observable<ResponseBody> PostRegisterInfo(@Url String url, @FieldMap Map<String,Object> map);
    //根据用户ID查询用户信息
    @GET
    Observable<ResponseBody> GetQueryuserInfo(@Url String url);
    //查询banner
    @GET
    Observable<ResponseBody> GetXBannerInfo(@Url String url);
    //查询正在上映电影列表   即将上映   //热门电影
    @GET
    Observable<ResponseBody> GetReceivedInfo(@Url String url, @QueryMap Map<String,Object> map);

}
