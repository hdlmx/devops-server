package cn.hdlmx.devops.controller;

import cn.hdlmx.devops.bean.RetResponse;
import cn.hdlmx.devops.bean.RetResult;
import cn.hdlmx.devops.pojo.Language;
import cn.hdlmx.devops.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/16 20:32
 */
@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public RetResult<List<Language>> list() {
        return RetResponse.makeOKResponse(languageService.list());
    }

}
