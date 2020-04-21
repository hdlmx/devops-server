package cn.hdlmx.devops.pojo;

import cn.hdlmx.devops.emun.RoleEnum;

/**
 * @author 韩东
 * @version 1.0
 * @date 2020/4/14 10:59
 */
public class Operator extends User {
    public Operator(String userName, String trueName, String password) {
        super(userName, trueName, password);
        Role role = new Role(RoleEnum.operator);
    }
}
