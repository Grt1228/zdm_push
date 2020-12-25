package com.unfbx.zdm_push.api;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.unfbx.zdm_push.constant.ServerPushPlusResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * @Description
 * @Author Grt
 * @Date 2020-12-11
 */
@RetrofitClient(baseUrl = "http://pushplus.hxtrip.com/")
public interface ServerPushPlusApi {
    @GET("send")
    ServerPushPlusResponse sendToServerPushPlus(@QueryMap Map<String,String> param);
}
