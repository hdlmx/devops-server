package cn.hdlmx.devops.pojo;

import cn.hdlmx.devops.emun.RoleEnum;

/**
 * 项目经理
 *
 * @author 韩东
 * @version 1.0
 * @date 2020/4/14 10:11
 */
public class ProgramManager extends User {
    public ProgramManager(String userName, String trueName, String password) {
        super(userName, trueName, password);
        Role role = new Role(RoleEnum.programManager);
        this.setRole(role);
    }

}
