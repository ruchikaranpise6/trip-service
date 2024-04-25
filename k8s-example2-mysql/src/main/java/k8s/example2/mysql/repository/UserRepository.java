package k8s.example2.mysql.repository;

import java.util.Optional;
import k8s.example2.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

  Optional<UserEntity> findByName(String name);
}
