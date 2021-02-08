package com.unfbx.zdm_push.constant;

/**
 * @Description
 * @Author Grt
 * @Date 2020-12-25
 */
public enum KeyType {

    SERVER_J(0,"serverJ"),
    PUSH_PLUS(1,"pushPlus"),
    SRE24PUSH(2,"sre24push"),
    ;

    private int code;
    private String value;

    KeyType(int code,String value){
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
