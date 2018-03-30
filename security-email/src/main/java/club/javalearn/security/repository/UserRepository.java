package club.javalearn.security.repository;

import club.javalearn.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);

    User findByUsername(String username);
}
