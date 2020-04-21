package cn.hdlmx.devops.pojo;

import cn.hdlmx.devops.emun.RoleEnum;

/**
 * 运维经理
 *
 * @author 韩东
 * @version 1.0
 * @date 2020/4/14 11:08
 */
public class OperatorManager extends User {
    public OperatorManager(String userName, String trueName, String password) {
        super(userName, trueName, password);
        Role role = new Role(RoleEnum.operatorManager);
        this.setRole(role);
    }
}
