package cn.hdlmx.devops.pojo;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/15 15:47
 */
public class ImageRepository extends Repository {
    private int projectId;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
