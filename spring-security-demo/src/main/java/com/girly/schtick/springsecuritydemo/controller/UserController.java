package com.girly.schtick.springsecuritydemo.controller;

import com.girly.schtick.springsecuritydemo.bean.UserBean;
import com.girly.schtick.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void addUser(@RequestBody UserBean request) {
        userService.addUser(request);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public UserBean getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
}
