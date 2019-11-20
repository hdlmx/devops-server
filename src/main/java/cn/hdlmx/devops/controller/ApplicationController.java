package cn.hdlmx.devops.controller;

import cn.hdlmx.devops.bean.RetResponse;
import cn.hdlmx.devops.bean.RetResult;
import cn.hdlmx.devops.pojo.Application;
import cn.hdlmx.devops.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/15 16:35
 */
@RestController
@RequestMapping("/project/app")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public RetResult save(@RequestBody Application app) {
        return RetResponse.makeOKResponse(applicationService.save(app));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public RetResult<List<Application>> list(@RequestParam String projectNamespace) {
        return RetResponse.makeOKResponse(applicationService.list(projectNamespace));
    }
}
