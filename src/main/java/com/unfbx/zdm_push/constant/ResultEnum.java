package com.unfbx.zdm_push.constant;

import lombok.Getter;

/**
 * 描述:
 * 返回结果状态
 *
 */
@Getter
public enum  ResultEnum {
    PARAM_ERROR(1,"参数不正确"),
    INSERT_ERROR(10,"新增失败"),
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

}