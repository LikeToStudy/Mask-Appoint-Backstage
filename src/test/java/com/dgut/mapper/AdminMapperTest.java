package com.dgut.mapper;

import com.dgut.domin.Admin;
import com.dgut.domin.Check;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
//读取配置文件，使@Autowired生效
@ContextConfiguration(locations = "classpath:application-context.xml")
public class AdminMapperTest {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void TestGetIDByName(){
        String name = adminMapper.getIDByName("赖志安");
        System.out.println(name);
    }

    @Test
    public void TestGetIDByInfo(){
        String id = adminMapper.getIDByInfo("赖志安", "123123");
        System.out.println(id);
    }

    @Test
    public void TestGetNameByID(){
        String name = adminMapper.getNameByID("bbbbbbbbbbbbbbbbbbb");
        System.out.println(name);
    }

    @Test
    public void TestGetAdmin(){
        Admin admin = adminMapper.getAdmin("bbbbbbbbbbbbbbbbbbb");
        System.out.println(admin);
    }

    @Test
    public void TestInsertAdminInfo(){
        Admin admin = new Admin("test-admin"+ UUID.randomUUID().toString(), "123123");
        Assert.assertSame("Test: TestAdminMapper:TestInsertAdminInfo Failed!",
                1, adminMapper.insertAdminInfo(admin));
    }

    @Test
    public void TestInsertCheck(){
        Check check = new Check();
        Assert.assertSame("Test: TestAdminMapper:TestInsertCheck Failed!",
                1, adminMapper.insertCheck(check));
    }

    @Test
    public void TestIsCheckUsed(){
        String check = "309128";
        String checkID = adminMapper.isCheckUsed(check);
        System.out.println(checkID);
    }

    @Test
    public void TestSetCheckInvalid(){
        String checkID = "dd340d52-d7f9-4fa8-baee-6f37d5c0093e";
        Assert.assertSame("Test: TestAdminMapper:TestSetCheckInvalid Failed!",
                1, adminMapper.setCheckInvalid(checkID));
    }
}
