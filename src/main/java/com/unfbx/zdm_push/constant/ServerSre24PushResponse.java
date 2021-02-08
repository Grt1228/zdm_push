package com.unfbx.zdm_push.constant;

import lombok.Data;

/**
 * @Description sre24push 调用返回值
 * @Date 2021-02-08
 */
@Data
public class ServerSre24PushResponse {

    //{"code":201,"errmsg":""}

    private int code;
    private String errmsg;

    public boolean isSuccess(){
	    return (code/100 == 2);
    }
}
