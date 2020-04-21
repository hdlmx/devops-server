package cn.hdlmx.devops.pojo;

import java.util.Date;

/**
 * 编译与构建
 *
 * @author 韩东
 * @version 1.0
 * @date 2020/4/17 22:14
 */
public class Build {
    private Application application;
    /**
     *Dockerfile脚本
     */
    private String Dockerfile;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 完成时间
     */
    private Date completeTime;
    /**
     * 当前编译状态
     */
    private int Status;
}
