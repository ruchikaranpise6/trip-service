package com.girly.schtick.springsecuritydemo.controller;

import com.girly.schtick.springsecuritydemo.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public String getAccessToken(@RequestParam String userName, @RequestParam String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userName);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @GetMapping("/validateToken")
    public boolean validateToken(@RequestParam String token){
        return jwtService.validateToken(token);
    }
}
