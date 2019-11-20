package cn.hdlmx.devops.dao;

import cn.hdlmx.devops.pojo.Application;

import java.util.List;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/15 16:41
 */
public interface ApplicationDao {
    int save(Application app);
    List<Application> list(String projectNamespace);
}
