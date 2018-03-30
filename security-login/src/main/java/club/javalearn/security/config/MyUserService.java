package club.javalearn.security.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //123456
        //$2a$04$f.Km1FsmIEHJ6ikyLogeJ.nJ47RhrBEKTgTTLF.VjYzDHhbDh6Ah2
        return null;
    }
}
