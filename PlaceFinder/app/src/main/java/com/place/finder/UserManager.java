package com.place.finder;

import android.content.Context;

public class UserManager {
    private static UserManager instance;
    private String snsType = "";

    public static UserManager getInstance() {
        if(instance == null) {
            instance = new UserManager();
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
