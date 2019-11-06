package cn.hdlmx.devops.service.impl;

import cn.hdlmx.devops.dao.UserDao;
import cn.hdlmx.devops.pojo.User;
import cn.hdlmx.devops.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserId(String userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    @Transactional
    public int save(User user) {
        return userDao.save(user);
    }
}
