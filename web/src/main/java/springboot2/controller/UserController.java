package springboot2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot2.model.User;
import springboot2.model.UserDO;
import springboot2.repository.UserDao;
import springboot2.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author likun
 * @version V1.0
 * @Title: com.lk.springboot2.controller
 * @date 2018/4/19 17:13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;


    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private UserDao userDao;

    @RequestMapping("/getUser")
    public UserDO getUser() {
        Map<String,Object> reqMap = new HashMap<>();
        reqMap.put("account","1");
        reqMap.put("password","3333");
        UserDO user = userDao.getUser(reqMap);
        return user;
    }

    @RequestMapping("/save")
    public User save(String name) {
        User user = new User();
        System.out.println(1111111);
        user.setName(name);
        userRepository.save(user);
        return user;
    }
}
