package com.unfbx.zdm_push.constant;

import lombok.Data;

/**
 * @Description
 * {
 * code: 200,
 * msg: "请求成功",
 * data: "发送消息成功",
 * count: null
 * }
 * @Author Grt
 * @Date 2020-12-25
 */
@Data
public class ServerPushPlusResponse {
    private int code;
    private String msg;
    private String data;
    private Integer count = 0;

    /**
     * 是否成功
     * @param code
     * @return
     */
    public boolean isSuccess(int code){
        if(code == 200){
            return true;
        }
        return false;
    }
}
