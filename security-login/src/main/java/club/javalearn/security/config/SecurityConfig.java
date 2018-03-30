package club.javalearn.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserService userService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //内置在内存中的用户/密码、角色
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//        auth.inMemoryAuthentication().withUser("hr").password("hr").roles("HR");
        auth.userDetailsService(userService);
        //使用Spring Security默认的jdbc认证
        //users.ddl中有相关表的DDL语句
        /**
         * create table users(username varchar_ignorecase(50) not null primary key,password varchar_ignorecase(500) not null,enabled boolean not null);
         * create table authorities (username varchar_ignorecase(50) not null,authority varchar_ignorecase(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
         * create unique index ix_auth_username on authorities (username,authority);
         */
        auth.jdbcAuthentication().usersByUsernameQuery("").authoritiesByUsernameQuery("").passwordEncoder(new MyPasswordEncoder());

    }

    @Bean
    public PasswordEncoder myPasswordEncoder(){
        return new MyPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .antMatchers("/").permitAll()
               .anyRequest().authenticated()
               .and()
               .logout().permitAll()
               .and()
               .formLogin();
       http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**","/css/**","/images/**");
    }
}
