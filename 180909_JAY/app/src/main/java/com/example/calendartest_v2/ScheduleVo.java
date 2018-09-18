package com.example.calendartest_v2;

import java.io.Serializable;
import java.util.Date;

public class ScheduleVo implements Serializable{

    private String type; // 라벨 색
    private String name; // 요금종류
    private String date; // 날짜
    private String tax; // 요금
    private String memo; // 메모



    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {        return date;    }
    public void setDate(String date) {        this.date = date;    }

    public String getTax() {        return tax;    }
    public void setTax(String tax) {        this.tax = tax;    }

    public String getMemo() {        return memo;    }
    public void setMemo(String memo) {        this.memo = memo;    }

    public ScheduleVo(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public ScheduleVo(String type, String name, String date, String tax, String memo) {
        this.type = type;
        this.name = name;
        this.date = date;
        this.tax = tax;
        this.memo = memo;
    }
}
