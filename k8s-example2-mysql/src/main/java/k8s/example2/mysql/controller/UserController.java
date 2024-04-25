package k8s.example2.mysql.controller;

import k8s.example2.mysql.dto.User;
import k8s.example2.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping
  User addUser(@RequestBody User request) {
    return userService.addUser(request);
  }

  @GetMapping("/{name}")
  User getByName(@PathVariable String name) {
    return userService.findByUserName(name);
  }
}
