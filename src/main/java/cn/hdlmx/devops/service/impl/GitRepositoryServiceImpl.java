package cn.hdlmx.devops.service.impl;

import cn.hdlmx.devops.dao.GitRepositoryDao;
import cn.hdlmx.devops.pojo.GitRepository;
import cn.hdlmx.devops.service.GitRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/17 11:04
 */
@Service
public class GitRepositoryServiceImpl implements GitRepositoryService {
    @Autowired
    private GitRepositoryDao gitRepositoryDao;

    @Override
    public int save(GitRepository gitRepository) {
        return gitRepositoryDao.save(gitRepository);
    }
}
