package com.dgut.mapper;
import com.dgut.domin.User;
import org.springframework.stereotype.Repository;

import java.util.List;

//不加这个注解@Autowired会有红色下划线，但能正常运行
//如果在xml文件中没有配置扫描这个包，那么就需要@Mapper，它相当于@Repository+@MapperScan
@Repository
public interface UserMapper {
    /*select*/

    //根据id获取用户名
    String getUsernameByUID(String UID);

    List<User> getAllUser();

    int updateAllInfo(User user);

    int addUser(User user);

    int delUser(String userID);
}
