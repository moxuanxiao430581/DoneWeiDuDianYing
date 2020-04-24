package com.example.doneweidudianying.url;

public interface BaseUrl {
    String Base="http://mobile.bwstudent.com/";
    //注册接口
    String ResignUrl="movieApi/user/v2/register";
    //邮箱接口
    String CodeUrl="movieApi/user/v2/sendOutEmailCode";
    //登录
    String LoginUrl="movieApi/user/v2/login";
    //根据用户ID查询用户信息
    String QueryuserUrl="movieApi/user/v1/verify/getUserInfoByUserId";
    //查询banner
    String XBannerUrl="movieApi/tool/v2/banner";


}
