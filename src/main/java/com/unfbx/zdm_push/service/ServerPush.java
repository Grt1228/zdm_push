package com.unfbx.zdm_push.service;

import com.unfbx.zdm_push.api.ServerJPushApi;
import com.unfbx.zdm_push.api.ServerPushPlusApi;
import com.unfbx.zdm_push.constant.ServerJPushResponse;
import com.unfbx.zdm_push.constant.ServerPushPlusResponse;
import com.unfbx.zdm_push.constant.ServerResponse;
import com.unfbx.zdm_push.pojo.ZdmInfo;
import lombok.extern.java.Log;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Grt
 * @Date 2020-12-11
 */
@Service
@Log
public class ServerPush {


    @Autowired
    private ServerJPushApi serverJPushApi;
    @Autowired
    private ServerPushPlusApi serverPushPlusApi;
    /**
     * 私人密钥
     */
    @Value("${key.value}")
    private String keyValue;


    public ServerResponse pushJMsgToWechat(ZdmInfo zdmInfo){
        if(StringUtils.isBlank(keyValue)){
            return ServerResponse.createByError("为配置微信推送密钥，到application.yml配置");
        }
        ServerJPushResponse serverPushResponse = serverJPushApi.sendToServerJiang(keyValue,zdmInfo.getName(), zdmInfo.getUrl());

        if (serverPushResponse == null){
            log.info("推送失败：系统异常");
            return ServerResponse.createByError("推送失败");
        }
        if(serverPushResponse.isSuccess(serverPushResponse.getErrmsg())){
            return ServerResponse.createBySuccess("推送成功");
        }
        log.info("推送失败："+serverPushResponse.getErrmsg());
        return ServerResponse.createByError("推送失败");
    }

    public ServerResponse pushPushMsgToWechat(ZdmInfo zdmInfo){
        if(StringUtils.isBlank(keyValue)){
            return ServerResponse.createByError("为配置微信推送密钥，到application.yml配置");
        }
        Map<String,String> param = new HashMap<>();
        param.put("token",keyValue);
        param.put("title",zdmInfo.getName());
        param.put("content",zdmInfo.getUrl());
        param.put("template","html");
        ServerPushPlusResponse serverPushResponse = serverPushPlusApi.sendToServerPushPlus(param);

        if (serverPushResponse == null){
            log.info("推送失败：系统异常");
            return ServerResponse.createByError("推送失败");
        }
        if(serverPushResponse.isSuccess(serverPushResponse.getCode())){
            return ServerResponse.createBySuccess("推送成功");
        }
        log.info("推送失败："+serverPushResponse.getMsg());
        return ServerResponse.createByError("推送失败");
    }
}
