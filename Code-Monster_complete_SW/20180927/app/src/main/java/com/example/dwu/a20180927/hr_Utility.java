package com.example.dwu.a20180927;

import android.content.Context;
import android.content.SharedPreferences;

public class hr_Utility {
    public static void set(Context c, String key, Object value) {
        SharedPreferences s = c.getSharedPreferences(c.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = s.edit();

        if(value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        editor.apply();
    }

    public static String get(Context c, String key) {
        SharedPreferences s = c.getSharedPreferences(c.getPackageName(), Context.MODE_PRIVATE);
        return s.getString(key, "");
    }
}
