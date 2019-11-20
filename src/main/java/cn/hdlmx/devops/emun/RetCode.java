package cn.hdlmx.devops.emun;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/13 16:07
 */
public enum RetCode {
    SUCCESS(200),

    FAIL(400),

    UNAUTHORIZED(401),

    NOT_FOUND(404),

    INTERNAL_SERVER_ERROR(500);

    public int code;

    RetCode(int code) {
        this.code = code;
    }


}
