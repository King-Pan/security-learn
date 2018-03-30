package club.javalearn.security.config;

import club.javalearn.security.service.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()).passwordEncoder(new MyPasswordEncoder());
    }

    /**
     *  定义哪些URL需要被保护
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //defaultSuccessUrl  登录成功默认跳转页
        //loginPage("/login") 指定登录界面是/login
        //.permitAll();登录用户都可以访问
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/login?error").permitAll().and()
                .logout().permitAll();
    }




//    /**
//     *
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //将单个用户设置在内存中
////        super.configure(auth);//根据默认实现获取一个AuthenticationManager---》调用WebSecurityConfigurerAdapter的authenticationManager()方法
//        // 这里加入内存有哪些用户，页面登录就可以输入哪些用户登录
//       // auth.inMemoryAuthentication().withUser("admin").password("password").roles("USER");
//        auth.jdbcAuthentication().passwordEncoder(new MyPasswordEncoder());
//
//    }

}
