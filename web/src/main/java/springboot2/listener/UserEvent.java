package springboot2.listener;

import com.google.common.base.Preconditions;
import org.springframework.context.ApplicationEvent;
import springboot2.model.User;
import springboot2.model.UserDO;

/**
 * @package springboot2.listener
 * @Author: likun
 * @Date: 2018/10/23
 */
public class UserEvent extends ApplicationEvent {

    public UserEvent(Object source) {
        super(source);
    }

    public UserDO getUser() {
        Preconditions.checkState(source != null);
        return (UserDO) this.source;
    }
}
