package cn.hdlmx.devops.pojo;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/15 15:47
 */
public class ImageRepository extends Repository {
    /**
     *
     */
    private int projectId;
    private String repositoryUrl;
    private String username;
    private String password;
    private String email;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
