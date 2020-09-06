package com.dgut.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dgut.domin.Admin;
import com.dgut.domin.Check;
import com.dgut.mapper.AdminMapper;
import com.dgut.service.AdminService;
import com.dgut.util.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;
    private JsonHelper jsonHelper;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper, JsonHelper jsonHelper){
        this.adminMapper = adminMapper;
        this.jsonHelper = jsonHelper;
    }

    @Override
    public JSONObject login(JSONObject data, HttpSession session) {
        String adminName = data.getString("userName");
        String adminPassword = data.getString("passWord");
        String id = adminMapper.getIDByName(adminName);
        if (id == null || id.equals("")) return jsonHelper.login(2);
        else {
            id = null;
            id = adminMapper.getIDByInfo(adminName, adminPassword);
            if (id == null || id.equals("")) return jsonHelper.login(3);
            else {
                session.setAttribute("UID", id);
                return jsonHelper.login(1);
            }
        }
    }

    @Override
    public JSONObject register(JSONObject data, HttpSession session) {
        String username = data.getString("registerUserName");
        String password = data.getString("registerPassWord");
        String check = data.getString("check");
        String checkID = adminMapper.isCheckUsed(check);
        if (checkID != null){
            String isUsernameUsed = adminMapper.getIDByName(username);
            if (isUsernameUsed == null){
                Admin admin = new Admin(username, password);
                int result = adminMapper.insertAdminInfo(admin);
                if (result > 0) {
                    session.setAttribute("UID", admin.getAdminID());
                    adminMapper.setCheckInvalid(checkID);
                    Check newCheck = new Check();
                    adminMapper.insertCheck(newCheck);
                    return jsonHelper.register(1);
                }
                else return jsonHelper.register(4);
            }
            else return jsonHelper.register(2);
        }
        else return jsonHelper.register(3);
    }

    @Override
    public JSONObject isLogin(HttpSession session) {
        return null;
    }

    @Override
    public JSONObject logout(HttpSession session) {
        return null;
    }

    @Override
    public JSONObject getUserInfo(HttpSession session) {
        return null;
    }
}
