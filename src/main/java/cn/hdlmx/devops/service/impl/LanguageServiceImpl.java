package cn.hdlmx.devops.service.impl;

import cn.hdlmx.devops.dao.LanguageDao;
import cn.hdlmx.devops.pojo.Language;
import cn.hdlmx.devops.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/16 20:37
 */
@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    private LanguageDao languageDao;

    @Override
    public List<Language> list() {
        return languageDao.list();
    }
}
