package cn.hdlmx.devops.pojo;

import io.fabric8.kubernetes.api.model.apps.Deployment;

import java.util.List;

/**
 * 应用程序在kubernetes中Deploy
 *
 * @author 韩东
 * @version 1.0
 * @date 2019/11/6 15:03
 */
public class AppDeployment extends Deployment {

    private Project project;
    private List<Container> containerList;

}
