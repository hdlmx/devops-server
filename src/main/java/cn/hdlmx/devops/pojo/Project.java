package cn.hdlmx.devops.pojo;

import java.util.Date;
import java.util.List;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/12 12:05
 */
public class Project {
    /**
     * 唯一ID
     */
    private String id;
    /**
     * 命名空间
     * 唯一
     */
    private String namespace;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 创建实践
     */
    private Date createTime;
    /**
     * 开发者
     */
    private List<Developer> developers;
    /**
     * 项目经理
     */
    private ProgramManager programManager;
    /**
     * 运维经理
     */
    private OperatorManager operatorManager;
    /**
     * 运维人员
     */
    private Operator operator;
    private String ownId;

    public Project() {
    }

    public Project(String id, String namespace, String name, Date createTime, List<Developer> developers, ProgramManager programManager, OperatorManager operatorManager, Operator operator) {
        this.id = id;
        this.namespace = namespace;
        this.name = name;
        this.createTime = createTime;
        this.developers = developers;
        this.programManager = programManager;
        this.operatorManager = operatorManager;
        this.operator = operator;
    }

    public Project(String namespace, String name, Date createTime) {
        this.namespace = namespace;
        this.name = name;
        this.createTime = createTime;
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

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public ProgramManager getProgramManager() {
        return programManager;
    }

    public void setProgramManager(ProgramManager programManager) {
        this.programManager = programManager;
    }

    public OperatorManager getOperatorManager() {
        return operatorManager;
    }

    public void setOperatorManager(OperatorManager operatorManager) {
        this.operatorManager = operatorManager;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getOwnId() {
        return ownId;
    }

    public void setOwnId(String ownId) {
        this.ownId = ownId;
    }
}
