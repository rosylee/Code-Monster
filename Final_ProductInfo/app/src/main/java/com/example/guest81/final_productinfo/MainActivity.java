package com.example.guest81.final_productinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relative;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //액티비티로 넘어가는 버튼 부분
    public void onClick(View v){

        switch(v.getId()){
            case R.id.btn_depo:
                intent = new Intent(MainActivity.this, DepoActivity.class);
                MainActivity.this.startActivity(intent);
                break;

            case R.id.btn_app:
                intent = new Intent(MainActivity.this, AppActivity.class);
                MainActivity.this.startActivity(intent);
                break;

            case R.id.btn_inst:
                intent = new Intent(MainActivity.this, InstActivity.class);
                MainActivity.this.startActivity(intent);
                break;
        }
    }
}
