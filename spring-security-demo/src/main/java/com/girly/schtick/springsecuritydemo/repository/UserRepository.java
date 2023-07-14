package com.girly.schtick.springsecuritydemo.repository;

import com.girly.schtick.springsecuritydemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByName(String username);
}
