package cn.hdlmx.devops.service.impl;

import cn.hdlmx.devops.dao.ProjectDao;
import cn.hdlmx.devops.pojo.Project;
import cn.hdlmx.devops.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/12 12:08
 */
@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Transactional
    public int save(Project project) {
        Date date = new Date();
        project.setCreateTime(date);
        project.setOwnId("1001");
        return projectDao.save(project);
    }

    @Override
    public List<Project> list(String projectName) {
        return projectDao.list(projectName);
    }

    @Override
    public int existNewNamespace(String namespace) {
        return 0;
    }
}
