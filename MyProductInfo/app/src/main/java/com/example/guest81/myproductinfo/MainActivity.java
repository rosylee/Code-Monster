package com.example.guest81.myproductinfo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    LayoutInflater inflater;
    RelativeLayout relative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //액티비티로 넘어가는 버튼 부분
    public void onClick(View v){
        inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        switch(v.getId()){
            case R.id.btn_depo:
                relative = (RelativeLayout)inflater.inflate(R.layout.activity_depo, null);
                setContentView(relative);
                break;

//            case R.id.btn_app:
//                linear = (LinearLayout)inflater.inflate(R.layout.activity_app_list, null);
//                setContentView(linear);
//                break;
//
//            case R.id.btn_inst:
//                linear = (LinearLayout)inflater.inflate(R.layout.activity_inst_list, null);
//                setContentView(linear);
//                break;
        }
    }

}
