package cn.hdlmx.devops.pojo;

import java.util.Date;

/**
 * 应用程序
 *
 * @author 韩东
 * @version 1.0
 * @date 2019/11/6 15:03
 */
public class Application {
    /**
     * 应用程序iId
     */
    private String appId;
    /**
     * 应用程序名称
     */
    private String name;
    /**
     * 应用程序标识
     */
    private String mark;
    /**
     * 应用程序语言
     */
    private Language language;
    /**
     * 代码仓库url
     */
    private GitRepository gitRepository;
    /**
     * 用于存储镜像的仓库
     */
    private ImageRepository imageRepository;
    /**
     * 对应的项目id
     */
    private String projectNamespace;
    /**
     * 创建时间
     */
    private Date createTime;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public GitRepository getGitRepository() {
        return gitRepository;
    }

    public void setGitRepository(GitRepository gitRepository) {
        this.gitRepository = gitRepository;
    }

    public ImageRepository getImageRepository() {
        return imageRepository;
    }

    public void setImageRepository(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String getProjectNamespace() {
        return projectNamespace;
    }

    public void setProjectNamespace(String projectNamespace) {
        this.projectNamespace = projectNamespace;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
