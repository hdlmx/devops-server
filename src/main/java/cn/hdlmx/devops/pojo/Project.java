package cn.hdlmx.devops.pojo;

import java.util.Date;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/12 12:05
 */
public class Project {
    private String id;
    private String namespace;
    private String name;
    private Date createTime;
    private String ownId;

    public Project() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOwnId() {
        return ownId;
    }

    public void setOwnId(String ownId) {
        this.ownId = ownId;
    }
}
