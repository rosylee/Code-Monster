package com.example.dwu.a20180927;

import java.util.ArrayList;

public class
DayVo {
    private String day;
    private ArrayList<ScheduleVo> scheduleList;


    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }

    public ArrayList<ScheduleVo> getScheduleList() {
        return scheduleList;
    }
    public void setScheduleList(ArrayList<ScheduleVo> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
