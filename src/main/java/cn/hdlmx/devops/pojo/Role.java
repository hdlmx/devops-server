package cn.hdlmx.devops.pojo;

import cn.hdlmx.devops.emun.RoleEnum;

/**
 * 角色
 *
 * @author 韩东
 * @version 1.0
 * @date 2019/11/6 15:04
 */
public class Role {
    private String roleId;
    private RoleEnum roleType;

    public Role() {
    }

    public Role(String roleId, RoleEnum roleType) {
        this.roleId = roleId;
        this.roleType = roleType;
    }

    public Role(RoleEnum roleType) {
        this.roleType = roleType;
    }
}
