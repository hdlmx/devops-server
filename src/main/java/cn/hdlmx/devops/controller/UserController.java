package cn.hdlmx.devops.controller;

import cn.hdlmx.devops.pojo.Role;
import cn.hdlmx.devops.pojo.User;
import cn.hdlmx.devops.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/{userId}")
    public User get(@PathVariable("userId") String userId) {
        User user = userService.findByUserId(userId);
        return user;
    }

    @RequestMapping("save")
    public String save() {
        Role role = new Role("1", "管理员");
        User user = new User("1002", "muxin", "穆昕", "love68946hd", role);
        int result = userService.save(user);
        return result + "";
    }
}
