package cn.hdlmx.devops.service.impl;

import cn.hdlmx.devops.dao.ImageRepositoryDao;
import cn.hdlmx.devops.service.ImageRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/17 10:45
 */
@Service
public class ImageRepositoryServiceImpl implements ImageRepositoryService {
    @Autowired
    private ImageRepositoryDao imageRepositoryDao;
}
