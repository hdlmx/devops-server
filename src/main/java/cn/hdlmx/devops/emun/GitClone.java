package cn.hdlmx.devops.emun;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/12/12 13:35
 */
public enum GitClone {
    /**
     * 克隆成功
     */
    SUCCESS,
    /**
     * repository url存在问题，repository找不到
     */
    REPOSITORYNOTFOUND,
    /**
     * 用户名密码不正确
     */
    CREDENTIALFAILED,

    /**
     *其他类型的失败
     */
    FAILED
}
