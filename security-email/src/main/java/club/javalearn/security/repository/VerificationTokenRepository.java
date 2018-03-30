package club.javalearn.security.repository;

import club.javalearn.security.domain.User;
import club.javalearn.security.domain.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
}
