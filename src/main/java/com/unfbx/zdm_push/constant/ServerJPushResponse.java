package com.unfbx.zdm_push.constant;

import lombok.Data;

/**
 * @Description Server酱调用返回值
 * @Author Grt
 * @Date 2020-12-11
 */
@Data
public class ServerJPushResponse {

    //{"errno":0,"errmsg":"success","dataset":"done"}

    private int errno;
    private String errmsg;
    private String dataset;

    public boolean isSuccess(String errmsg){
        if(errmsg.equals("success")){
            return true;
        }
        return false;
    }
}
