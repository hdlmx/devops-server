package cn.hdlmx.devops.pojo;

/**
 * 角色
 *
 * @author 韩东
 * @version 1.0
 * @date 2019/11/6 15:04
 */
public class Role {
    private String roleId;
    private String roleName;

    public Role() {
    }

    public Role(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
