package cn.hdlmx.devops.bean;

import cn.hdlmx.devops.emun.RetCode;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/13 16:13
 */
public class RetResult<T> {
    private int code;
    private String msg;
    private T data;


    public int getCode() {
        return code;
    }

    public RetResult<T> setCode(RetCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
