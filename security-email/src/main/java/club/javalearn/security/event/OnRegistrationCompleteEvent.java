package club.javalearn.security.event;

import club.javalearn.security.domain.User;
import org.springframework.context.ApplicationEvent;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private final String appUrl;
    private final User user;

    public OnRegistrationCompleteEvent(final User user, final String appUrl) {
        super(user);
        this.user = user;
        this.appUrl = appUrl;
    }

    //

    public String getAppUrl() {
        return appUrl;
    }


    public User getUser() {
        return user;
    }

}
