package com.dgut.mapper;

import com.dgut.domin.Admin;
import com.dgut.domin.Check;
import org.springframework.stereotype.Repository;

//不加这个注解@Autowired会有红色下划线，但能正常运行
//如果在xml文件中没有配置扫描这个包，那么就需要@Mapper，它相当于@Repository+@MapperScan
@Repository
public interface AdminMapper {
    /*select*/

    //获取管理员ID
    String getIDByName(String adminName);

    //根据用户名和密码获取ID
    String getIDByInfo(String adminName, String adminPassword);

    //根据id获取用户名
    String getNameByID(String adminID);

    //获取管理员信息
    Admin getAdmin(String adminID);

    //查看验证码是否被使用
    String isCheckUsed(String check);
    /*insert*/

    //新增管理员

    int insertAdminInfo(Admin admin);

    int insertCheck(Check check);
    /*update*/

    int setCheckInvalid(String checkID);
}
