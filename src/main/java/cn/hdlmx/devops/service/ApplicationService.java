package cn.hdlmx.devops.service;

import cn.hdlmx.devops.pojo.Application;

import java.util.List;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/15 16:38
 */
public interface ApplicationService {
    int save(Application application);

    List<Application> list(String projectName);
}
