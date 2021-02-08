package com.unfbx.zdm_push.api;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.unfbx.zdm_push.constant.ServerSre24PushResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @Description
 * @Date 2021-02-08
 */
@RetrofitClient(baseUrl = "https://sre24.com/")
public interface ServerSre24PushApi {
    @GET("api/v1/push")
    ServerSre24PushResponse notifyUser(@Query("token")String token, @Query("msg")String msg);
}
