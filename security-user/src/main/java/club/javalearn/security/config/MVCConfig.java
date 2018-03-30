package club.javalearn.security.config;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *  MVC配置类
 *  这个可以直接进行跳转，不需要经过Controller
 */
@Configuration
public class MVCConfig  extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}
