package com.dgut.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dgut.domin.AppointLog;
import com.dgut.domin.TempAppoint;
import com.dgut.mapper.AppointMapper;
import com.dgut.mapper.UserMapper;
import com.dgut.service.AppointService;
import com.dgut.util.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointServiceImpl implements AppointService {

    private AppointMapper appointMapper;
    private UserMapper userMapper;
    private JsonHelper jsonHelper;

    @Autowired
    public AppointServiceImpl(AppointMapper appointMapper, JsonHelper jsonHelper, UserMapper userMapper){
        this.appointMapper = appointMapper;
        this.jsonHelper = jsonHelper;
        this.userMapper = userMapper;
    }

    @Override
    public JSONObject getAllAppoint() {
        appointMapper.updateAppointStatus();
        List<AppointLog> list = appointMapper.getAppointList();
        List<TempAppoint> list1 = new ArrayList<>();
        for (AppointLog log:list){
            String time = log.getAppointTime();
            String username = userMapper.getUsernameByUID(log.getUserID());
            String speed;
            if (log.getIsComplete() == 0) speed = "预约完成，等待送达！";
            else speed = "成功送达，预约成功！";
            TempAppoint appoint = new TempAppoint(log.getLogID(), username, time, speed);
            list1.add(appoint);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appointments", list1);
        return jsonObject;
    }

    @Override
    public JSONObject deleteAppoint(JSONObject data) {
        String logID = data.getString("appointmentId");
        int result = appointMapper.deleteAppoint(logID);
        if (result > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }
}
