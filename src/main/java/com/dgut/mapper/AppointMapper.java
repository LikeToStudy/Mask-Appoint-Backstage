package com.dgut.mapper;

import com.dgut.domin.AppointLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointMapper {
    List<AppointLog> getAppointList();

    void updateAppointStatus();

    int deleteAppoint(String logID);
}
