package com.example.dwu.a20180927;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dwu.management.R;

/**
 * @author leoshin
 * Created by leoshin on 15. 6. 23..
 */
public class KakaoToast {

    public static Toast makeToast(Context context, String body, int duration){
        LayoutInflater inflater;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.hr_view_toast, null);
        TextView text = (TextView) v.findViewById(R.id.message);
        text.setText(body);

        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(v);
        toast.setDuration(duration);
        return toast;
    }
}
