package club.javalearn.security.service;

import club.javalearn.security.domain.User;
import club.javalearn.security.domain.VerificationToken;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/
public interface IUserService extends UserDetailsService {

    User findByEmail(String email);

    void createVerificationTokenForUser(User user,String token);

    VerificationToken getVerificationToken(String VerificationToken);

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    User registerNewUserAccount(User user) throws Exception;
}