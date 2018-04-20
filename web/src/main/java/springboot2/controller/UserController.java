package springboot2.controller;

import springboot2.model.User;
import springboot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author likun
 * @version V1.0
 * @Title: com.lk.springboot2.controller
 * @date 2018/4/19 17:13
 */
@RestController
public class UserController {

    private final UserRepository userRepository;


    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return user;
    }
}
