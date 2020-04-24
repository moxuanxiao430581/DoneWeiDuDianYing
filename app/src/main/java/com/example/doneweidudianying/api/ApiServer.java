package com.example.doneweidudianying.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
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


}
