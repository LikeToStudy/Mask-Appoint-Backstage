package com.dgut.mapper;
import com.dgut.domin.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
//读取配置文件，使@Autowired生效
@ContextConfiguration(locations = "classpath:application-context.xml")
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void TestGetUsernameByUID(){
        String userID = "ajsdoajaspodpojqwd";
        String name = userMapper.getUsernameByUID(userID);
        System.out.println(name);
    }

    @Test
    public void TestGetAllUser(){
        List<User> list = userMapper.getAllUser();
        for (User u:list) System.out.println(u);
    }

    @Test
    public void TestAddUser(){
        User user = new User("2222", "11111","11111", "1111","11111","11111","11111","11111","11111","11111");
        userMapper.addUser(user);
    }
}
