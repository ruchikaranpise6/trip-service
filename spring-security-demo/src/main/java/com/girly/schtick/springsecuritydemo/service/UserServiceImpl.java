package com.girly.schtick.springsecuritydemo.service;

import com.girly.schtick.springsecuritydemo.bean.UserBean;
import com.girly.schtick.springsecuritydemo.entity.UserEntity;
import com.girly.schtick.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void addUser(UserBean request) {

        if (Objects.nonNull(request)) {
            UserEntity user = UserEntity.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .roles(request.getRoles()).build();

            userRepository.save(user);
        }

    }

    @Override
    public UserBean getUserById(Integer id) {
        Optional<UserEntity> user = userRepository.findById(id);
        user.orElseThrow(() -> new UsernameNotFoundException("User by Id not found."));
        UserBean response = new UserBean();
        BeanUtils.copyProperties(user.get(), response);
        return response;
    }
}
