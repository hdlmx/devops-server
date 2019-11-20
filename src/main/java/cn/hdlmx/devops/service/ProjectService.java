package cn.hdlmx.devops.service;

import cn.hdlmx.devops.pojo.Project;

import java.util.List;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/12 12:07
 */
public interface ProjectService {
    int save(Project project);

    int existNewNamespace(String namespace);

    List<Project> list(String projectName);
}
