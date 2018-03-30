package club.javalearn.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence arg0) {
        return arg0.toString();
    }

    @Override
    public boolean matches(CharSequence arg0, String arg1) {
        return arg1.equals(arg0.toString());
    }

}
