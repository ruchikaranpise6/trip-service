package k8s.example2.mysql.service;

import k8s.example2.mysql.dto.User;
import k8s.example2.mysql.entity.UserEntity;
import k8s.example2.mysql.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public User addUser(User request) {
    UserEntity entity = UserEntity.builder().name(request.getName()).lastName(
        request.getLastName()).build();
    entity = userRepository.save(entity);

    BeanUtils.copyProperties(entity, request);
    return request;
  }

  public User findByUserName(String name) {
    UserEntity entity = userRepository.findByName(name)
        .orElseThrow(() -> new RuntimeException("User not found"));
    User user = new User();
    BeanUtils.copyProperties(entity, user);
    return user;
  }
}
