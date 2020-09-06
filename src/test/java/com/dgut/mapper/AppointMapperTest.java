package com.dgut.mapper;

import com.dgut.domin.AppointLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//读取配置文件，使@Autowired生效
@ContextConfiguration(locations = "classpath:application-context.xml")
public class AppointMapperTest {
    @Autowired
    private AppointMapper appointMapper;

    @Test
    public void TestGetAppointList(){
        List<AppointLog> logs = appointMapper.getAppointList();
        for (AppointLog a: logs) System.out.println(a);
    }

    @Test
    public void TestUpdateAppointStatus(){
        appointMapper.updateAppointStatus();
    }

    @Test
    public void TestDeleteAppoint(){
        appointMapper.deleteAppoint("fffffffffffff");
    }
}
