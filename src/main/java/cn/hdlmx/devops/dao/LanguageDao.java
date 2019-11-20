package cn.hdlmx.devops.dao;

import cn.hdlmx.devops.pojo.Language;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/16 20:38
 */
public interface LanguageDao {
    List<Language> list();
}
