package cn.hdlmx.devops.dao;

import cn.hdlmx.devops.pojo.Project;

import java.util.List;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/12 12:08
 */
public interface ProjectDao {
    int save(Project project);

    int existNewNamespace(String namespace);

    List<Project> list(String projectName);
}
