package springboot2.repository;

import org.springframework.stereotype.Repository;
import springboot2.model.UserDO;

import java.util.Map;

/**
 * 用户Dao层
 * @author likun
 */
@Repository
public interface UserDao {

     /**
      * 获取当前登录的用户
      * @param map
      * @return
      */
     UserDO getUser(Map<String, Object> map);

     /**
      * 插入方法
      * @param record
      * @return
      */
     int insert(UserDO record);

     /**
      * 更新用户信息
      * @param userDO
      * @return
      */
     int updateByPrimaryKeySelective(UserDO userDO);

}
