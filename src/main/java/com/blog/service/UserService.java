package com.blog.service;

import com.blog.entity.User;


public interface UserService {

    User checkUser(String username, String password);

    User RegisterUser(String username, String password);
}
