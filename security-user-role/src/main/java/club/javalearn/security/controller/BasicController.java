package club.javalearn.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/
@Controller
public class BasicController {

    @RequestMapping(value = {"/","/home"})
    public String home(){
        return "home";
    }

    @RequestMapping(value = {"/admin"})
    public String admin(){
        return "admin";
    }

    @RequestMapping(value = {"/user"})
    public String user(){
        return "user";
    }

    @RequestMapping(value = {"/vip"})
    public String vip(){
        return "vip";
    }
    @RequestMapping(value = {"/login"})
    public String login(){
        return "login";
    }

    @RequestMapping(value = {"/super"})
    public String superm(){
        return "super";
    }
    @RequestMapping(value = {"/deny"})
    public String deny(){
        return "deny";
    }
}
