package com.dataset.util;

/**
 * 这个类定义了返回的json格式，即json含有哪些字段
 */
public class BaseResponse<T> {

    private Integer code;
    private String msg;
    private T list;

    public BaseResponse(StatusCode statusCode) {
        this.code=statusCode.getCode();
        this.msg=statusCode.getMsg();
    }

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(T list, StatusCode statusCode) {
        this.list = list;
        this.code=statusCode.getCode();
        this.msg=statusCode.getMsg();
    }

    public BaseResponse(Integer code, String msg, T list) {
        this.code = code;
        this.msg = msg;
        this.list = list;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }
}