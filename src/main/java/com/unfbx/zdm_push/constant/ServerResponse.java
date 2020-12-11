package com.unfbx.zdm_push.constant;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * 描述:
 * 返回json对象
 * JsonSerialize 保证序列化json的时候，如果是null的对象，key也会消失
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
@Log4j2
public class ServerResponse<T> implements Serializable{

    private int status;
    private String msg;
    private T data;
    private long total;
    private boolean isFirstPage;
    private boolean isLastPage;

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(String msg) {
        this.msg = msg;
    }

    private ServerResponse(T data) {
        this.data = data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status, T data,long total) {
        this.status = status;
        this.data = data;
        this.total = total;
    }
    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public ServerResponse(int code, T data, long total,boolean isFirstPage, boolean isLastPage) {
        this.status = status;
        this.data = data;
        this.total = total;
        this.isFirstPage=isFirstPage;
        this.isLastPage = isLastPage;
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }
    public static <T> ServerResponse<T> createBySuccess(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T> ServerResponse<T> createBySuccess(T data,long total){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data,total);
    }

    public static <T> ServerResponse<T> createBySuccess(T data,long total,boolean isFirstPage,boolean isLastPage){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data,total,isFirstPage,isLastPage);
    }
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T> ServerResponse<T> createBySuccess(String msg,T data ){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }
    // 错误的返回类型

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    public static <T> ServerResponse<T> createByError(String errorMsg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMsg);
    }
    public static <T> ServerResponse<T> createByError(int errorCode,String errorMsg){
        return new ServerResponse<T>(errorCode,errorMsg);
    }
    public static <T> ServerResponse<T> createByError(String msg,T data ){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),msg,data);
    }

    /**
     * 使用response输出JSON
     * @Author Sans
     * @CreateTime 2019/9/28 11:23
     * @Param  resultMap 数据
     * @Return void
     */
    public static void responseJson(ServletResponse response, ServerResponse result){
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(result));
        } catch (Exception e) {
            log.error(">>>>>>>>>>>>>>>JSON输出异常"+e);
        }finally{
            if(out!=null){
                out.flush();
                out.close();
            }
        }
    }

    public boolean isSuccess(){
        return this.status==ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public long getTotal() {
        return total;
    }
}