package com.example.demo.service;

import com.example.demo.bean.UserBean;

public interface UserService {
    void createUser(UserBean request);

    UserBean getUser(int id);
}
