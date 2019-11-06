package cn.hdlmx.devops.pojo;

public class User {
    private String userId;
    private String userName;
    private String trueName;
    private String password;
    private Role role;

    public User() {
    }

    public User(String userId, String userName, String trueName, String password, Role role) {
        this.userId = userId;
        this.userName = userName;
        this.trueName = trueName;
        this.password = password;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
