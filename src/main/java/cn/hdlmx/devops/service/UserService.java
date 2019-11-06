package cn.hdlmx.devops.service;

import cn.hdlmx.devops.pojo.User;

import java.util.List;

public interface UserService {
    User findByUserId(String userId);

    List<User> findAll();

    int save(User user);
}
