package com.girly.schtick.springsecuritydemo.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBean {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String roles;
}
