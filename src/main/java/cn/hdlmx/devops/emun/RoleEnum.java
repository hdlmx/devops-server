package cn.hdlmx.devops.emun;

/**
 * @author 韩东
 * @version 1.0
 * @date 2020/4/14 9:34
 */
public enum RoleEnum {
    /**
     * 开发者
     */
    developer("develop", 1),
    /**
     * 项目经理
     */
    programManager("programManager", 2),
    /**
     * 运维人员
     */
    operator("operation", 3),
    /**
     * 运维经理
     */
    operatorManager("operationManager", 4);

    private String roleType;
    private int roleId;

    RoleEnum(String roleType, int roleId) {

        this.roleType = roleType;
        this.roleId = roleId;

    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
