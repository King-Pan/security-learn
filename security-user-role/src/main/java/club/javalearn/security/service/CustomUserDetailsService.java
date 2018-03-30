package club.javalearn.security.service;

import club.javalearn.security.domain.SysUser;
import club.javalearn.security.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserRepository userReporitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //SysUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SysUser中的name作为用户名:
        SysUser user = userReporitory.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("UserName " + username + " not found");
        }
        return  user;
    }

}
