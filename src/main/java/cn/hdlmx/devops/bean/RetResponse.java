package cn.hdlmx.devops.bean;

import cn.hdlmx.devops.emun.RetCode;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/14 9:43
 */
public class RetResponse {
    private final static String SUCCESS = "success";

    /**
     * 能够成功返回请求，携带数据
     */
    public static <T> RetResult<T> makeOKResponse() {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS);
    }

    /**
     * 能够成功返回请求，携带数据
     */
    public static <T> RetResult<T> makeOKResponse(T data) {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    /**
     *处理请求发生错误
     */
    public static <T> RetResult<T> makeErrResponse(String message) {
        return new RetResult<T>().setCode(RetCode.FAIL).setMsg(SUCCESS);
    }

    public static <T> RetResult<T> makeResponse(int code, String msg) {
        return new RetResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> RetResult<T> makeResponse(int code, String msg, T data) {
        return new RetResult<T>().setCode(code).setMsg(msg).setData(data);
    }
}
