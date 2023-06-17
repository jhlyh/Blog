package com.blog.service.impl;

import com.blog.dao.UserRespository;
import com.blog.service.UserService;
import com.blog.entity.User;
import com.blog.util.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceimpl implements UserService {

    @Resource
    UserRespository userRespository;

    //登录
    @Override
    public User checkUser(String username, String password) {
        User user = userRespository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

    //注册
    @Override
    public User RegisterUser(String username, String password) {
        return null;
    }
}
