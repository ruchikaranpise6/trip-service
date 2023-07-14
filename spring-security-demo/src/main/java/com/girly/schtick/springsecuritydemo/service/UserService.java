package com.girly.schtick.springsecuritydemo.service;

import com.girly.schtick.springsecuritydemo.bean.UserBean;

public interface UserService {

    void addUser(UserBean user);
    UserBean getUserById(Integer id);
}
