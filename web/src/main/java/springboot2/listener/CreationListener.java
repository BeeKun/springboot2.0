package springboot2.listener;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import springboot2.model.User;


/**
 * @package springboot2.listener
 * @Author: likun
 * @Date: 2018/10/23
 */
@Component
public class CreationListener {

    private Logger logger = LoggerFactory.getLogger(CreationListener.class);

    @EventListener
    public void userCreateEvent(UserEvent event){
        logger.info(JSON.toJSONString(event.getUser()));
    }
}
