package com.example.demo.service.impl;

import com.example.demo.bean.UserBean;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public void createUser(UserBean request) {
        if (null != request) {
            //UserEntity user = new UserEntity(request.getId(), request.getName());
            UserEntity user =
                    UserEntity.builder().name(request.getName()).build();
            repository.save(user);
        }
    }

    @Override
    public UserBean getUser(int id) {
        Optional<UserEntity> user = repository.findById(id);
        user.orElseThrow(() -> new RuntimeException("User Not Found"));
        UserBean response = new UserBean(user.get().getName(), user.get().getId());
        return response;
    }
}
