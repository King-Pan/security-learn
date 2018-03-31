package club.javalearn.security.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Welcome to Home page";
    }

    //https://www.cnblogs.com/softidea/p/7068149.html

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Security";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')") //方法调用前检查
    //@PostAuthorize("hasRole('')")          //方法调用后检查
    //@PreFilter("")                       //对返回值进行过滤,或者集合类型的参数过滤
    //@PostFilter("")
    @RequestMapping("/roleAuth")
    public String role(){
        return "Role auth";
    }

    @PreAuthorize("#id<10 or principal.username.equals(#username) and #user.username.equals('abc')") //方法调用前检查
    @PostAuthorize("returnObject%2==0")
    @RequestMapping("/roleAuth2")
    public Integer role2(Integer id, String username, User user){
        // ...
        return id;
    }

    @PreFilter("filterObject%2==0")  //对集合类型的参数过滤
    @PostFilter("filterObject%4==0") //对集合类型的返回值过滤
    @RequestMapping("/roleAuth3")
    public List<Integer> role3(List<Integer> idList){
        // ...
        return idList;
    }
}
