package com.unfbx.zdm_push.constant;

/**
 * 描述:
 * 定义公共返回的枚举值
 *
 * @author grt
 * @create 2018-02-02 22:52
 */
public enum  ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    ;

    private final int code;
    private final String desc;

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}