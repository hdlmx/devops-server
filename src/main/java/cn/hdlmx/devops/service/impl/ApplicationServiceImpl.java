package cn.hdlmx.devops.service.impl;

import cn.hdlmx.devops.dao.ApplicationDao;
import cn.hdlmx.devops.dao.GitRepositoryDao;
import cn.hdlmx.devops.pojo.Application;
import cn.hdlmx.devops.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/15 16:39
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationDao applicationDao;
    @Autowired
    private GitRepositoryDao gitRepositoryDao;

    @Override
    @Transactional
    public int save(Application application) {
        /*创建*/
        gitRepositoryDao.save(application.getGitRepository());
        Date date = new Date();
        application.setCreateTime(date);
        return applicationDao.save(application);
    }

    @Override
    public List<Application> list(String projectName) {
        return applicationDao.list(projectName);
    }
}
