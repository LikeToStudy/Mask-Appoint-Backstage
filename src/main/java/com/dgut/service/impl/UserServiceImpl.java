package com.dgut.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dgut.domin.User;
import com.dgut.mapper.UserMapper;
import com.dgut.service.UserService;
import com.dgut.util.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private JsonHelper jsonHelper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, JsonHelper jsonHelper){
        this.jsonHelper = jsonHelper;
        this.userMapper = userMapper;
    }

    @Override
    public JSONObject getAllUser() {
        List<User> list = userMapper.getAllUser();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("users", list);
        return jsonObject;
    }

    public JSONObject updateUserInfo(JSONObject data) {
        String userId = data.getString("userId");
        String changeName = userMapper.getUsernameByUID(userId);
        String changeSex = data.getString("userSex");
        String changeBirth = data.getString("userBirth");
        String changePhone = data.getString("userPhone");
        String changeNation = data.getString("userNation");
        String changeAddress = data.getString("userAddress");
        String changePhoneNumber = data.getString("userPhoneNumber");
        String changeEmail = data.getString("userEmail");
        User user = new User(userId, changeName, changeSex, changeBirth, changePhone, changeNation
                , changeAddress, changePhoneNumber, changeEmail);
        int result = userMapper.updateAllInfo(user);
        if (result > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }
/*             *    userId            用户的id
             *    userName          用户的姓名
             *    userSex           用户的性别
             *    userBirth         用户的出生日期
             *    userPhone         用户的绑定手机号
             *    userNation        用户的民族
             *    userAddress       用户的收件地址
             *    userPhoneNumber   用户的收件号码
             *    userEmail         用户的邮箱*/
    @Override
    public JSONObject addUser(JSONObject data) {
        String userName = data.getString("userName");
        String userSex = data.getString("userSex");
        String userBirth = data.getString("userBirth");
        String userPhone = data.getString("userPhone");
        String userNation = data.getString("userNation");
        String userAddress = data.getString("userAddress");
        String userPhoneNumber = data.getString("userPhoneNumber");
        String userEmail = data.getString("userEmail");
        User user = new User(userName, userSex, userBirth, userPhone, userNation
        , userAddress, userPhoneNumber, userEmail);
        int result = userMapper.addUser(user);
        if (result > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }

    @Override
    public JSONObject delUser(JSONObject data) {
        String userID = data.getString("userId");
        int result = userMapper.delUser(userID);
        if (result > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }


}
