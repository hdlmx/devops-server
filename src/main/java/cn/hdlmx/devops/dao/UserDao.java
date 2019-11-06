package cn.hdlmx.devops.dao;

import cn.hdlmx.devops.pojo.User;

import java.util.List;

public interface UserDao {
    User findByUserId(String userId);

    List<User> findAll();

    int save(User user);
}
