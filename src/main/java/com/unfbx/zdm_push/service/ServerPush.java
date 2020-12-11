package com.unfbx.zdm_push.service;

import com.unfbx.zdm_push.api.ServerPushApi;
import com.unfbx.zdm_push.constant.ServerPushResponse;
import com.unfbx.zdm_push.constant.ServerResponse;
import com.unfbx.zdm_push.pojo.ZdmInfo;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Grt
 * @Date 2020-12-11
 */
@Service
@Log
public class ServerPush {


    @Autowired
    private ServerPushApi serverPushApi;
    /**
     * 私人密钥
     */
    @Value("${key}")
    private String key;

    public ServerResponse pushMsgToWechat(ZdmInfo zdmInfo){

        ServerPushResponse serverPushResponse = serverPushApi.sendToServerJiang(key,zdmInfo.getName(), zdmInfo.getUrl());
        if (serverPushResponse == null){
            log.info("推送失败："+serverPushResponse.getErrmsg());
            return ServerResponse.createByError("推送失败");
        }
        if(serverPushResponse.isSuccess(serverPushResponse.getErrmsg())){
            return ServerResponse.createBySuccess("推送成功");
        }
        log.info("推送失败："+serverPushResponse.getErrmsg());
        return ServerResponse.createByError("推送失败");
    }
}
