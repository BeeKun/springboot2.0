package springboot2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot2.listener.UserEvent;
import springboot2.model.User;
import springboot2.model.UserDO;
import springboot2.repository.UserDao;
import springboot2.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务控制层
 * @author likun
 * @version V1.0
 * @Title: com.lk.springboot2.controller
 * @date 2018/4/19 17:13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ApplicationEventPublisher publisher;

    private final UserRepository userRepository;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private UserDao userDao;

    @RequestMapping("/getUser")
    public UserDO getUser() {
        logger.info("===============进入方法=======================");
        Map<String,Object> reqMap = new HashMap<>();
        reqMap.put("account","2");
        reqMap.put("password","3333");
        UserDO user = userDao.getUser(reqMap);
        publisher.publishEvent(new UserEvent(user));
        return user;
    }

    @RequestMapping("/save")
    public User save(String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return user;
    }
}
