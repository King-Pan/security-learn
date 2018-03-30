package club.javalearn.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/
@Controller
public class IndexController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/regist")
    public String regist(){
        return "regist";
    }

}
