package com.example.dwu.a20180927;

import java.io.Serializable;

public class ScheduleVo implements Serializable {

    private long _id;
    private String name; // 요금종류
    private String date; // 날짜
    private String tax; // 요금
    private String memo; // 메모
    private String type; // 라벨 색

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

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



    public ScheduleVo(long _id, String name, String date, String tax, String memo, String type) {
        this._id = _id;
        this.type = type;
        this.name = name;
        this.date = date;
        this.tax = tax;
        this.memo = memo;
    }

    public ScheduleVo(String name, String date, String tax, String memo, String type) {
        this.type = type;
        this.name = name;
        this.date = date;
        this.tax = tax;
        this.memo = memo;
    }
}
