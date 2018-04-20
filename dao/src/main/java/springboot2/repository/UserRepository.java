package springboot2.repository;

import springboot2.model.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author likun
 * @version V1.0
 * @Title: com.lk.springboot2.repository
 * @date 2018/4/19 16:36
 */
@Repository
public class UserRepository {

    private final ConcurrentMap<Integer,User> userConcurrentMap = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    public boolean save(User user) {
        boolean flag = false;
        int id = idGenerator.incrementAndGet();
        user.setId(id);
        User dod = userConcurrentMap.put(id,user);
        System.out.println(dod);
        if (dod == null) {
            flag = true;
        }
        return flag;
    }
}
