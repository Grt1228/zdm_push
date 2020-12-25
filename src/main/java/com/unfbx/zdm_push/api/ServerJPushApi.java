package com.unfbx.zdm_push.api;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.unfbx.zdm_push.constant.ServerJPushResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @Description
 * @Author Grt
 * @Date 2020-12-11
 */
@RetrofitClient(baseUrl = "https://sc.ftqq.com/")
public interface ServerJPushApi {
    @GET("{key}.send")
    ServerJPushResponse sendToServerJiang(@Path("key") String key, @Query("text")String text, @Query("desp")String desp);
}
