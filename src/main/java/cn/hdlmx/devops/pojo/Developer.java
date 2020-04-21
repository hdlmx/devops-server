package cn.hdlmx.devops.pojo;

import cn.hdlmx.devops.emun.RoleEnum;

/**
 * 开发者
 *
 * @author 韩东
 * @version 1.0
 * @date 2019/11/7 16:53
 */
public class Developer extends User {
    public Developer(String userId, String userName, String trueName, String password) {
        super(userId, userName, trueName, password);
        Role role = new Role(RoleEnum.developer);
        this.setRole(role);
    }
}
