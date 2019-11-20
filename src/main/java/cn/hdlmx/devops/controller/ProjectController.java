package cn.hdlmx.devops.controller;

import cn.hdlmx.devops.bean.RetResponse;
import cn.hdlmx.devops.bean.RetResult;
import cn.hdlmx.devops.pojo.Project;
import cn.hdlmx.devops.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/12 12:07
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public RetResult save(@RequestBody Project project) {
        int result = projectService.save(project);
        if (result == 1) {
            return RetResponse.makeOKResponse();
        } else {
            return RetResponse.makeErrResponse("创建失败");
        }
    }

    /**
     * 查询指定名称的项目
     *
     * @param projectName 项目名称
     * @return List<Project>
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RetResult<List<Project>> projectList(@RequestParam(value = "projectName", required = false) String projectName) {
        return RetResponse.makeOKResponse(projectService.list(projectName));
    }

    @RequestMapping(value = "/newNameSpace/{namespace}", method = RequestMethod.GET)
    public RetResult newNamespace(@PathVariable("namespace") String namespace) {
        int result = projectService.existNewNamespace(namespace);
        return RetResponse.makeOKResponse(result);
    }
}
