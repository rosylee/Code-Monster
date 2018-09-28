package com.example.dwu.a20180927;

/**
 * Created by testa on 2018-09-25.
 */

public class um_MemberVo {
    private int p_id;
    private String p_name;
    private String birthday;
    private String phone;
    private String customer_num;
    private String homepage_num;

    public um_MemberVo() {

    }

    public um_MemberVo(int p_id, String p_name, String birthday, String phone, String customer_num, String homepage_num) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.birthday = birthday;
        this.phone = phone;
        this.customer_num = customer_num;
        this.homepage_num = homepage_num;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomer_num() {
        return customer_num;
    }

    public void setCustomer_num(String customer_num) {
        this.customer_num = customer_num;
    }

    public String getHomepage_num() {
        return homepage_num;
    }

    public void setHomepage_num(String homepage_num) {
        this.homepage_num = homepage_num;
    }
}
