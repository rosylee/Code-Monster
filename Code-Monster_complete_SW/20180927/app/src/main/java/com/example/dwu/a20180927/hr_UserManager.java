package com.example.dwu.a20180927;

import android.content.Context;

public class hr_UserManager {
    private static hr_UserManager instance;
    private String snsType = "";

    public static hr_UserManager getInstance() {
        if(instance == null) {
            instance = new hr_UserManager();
        }

        return instance;
    }

    public void setType(String type) {
        snsType = type;
    }

    public String getType() {
        return snsType;
    }

    public String getNick(Context c) {
        String nick = "";


        return "";
    }
}
