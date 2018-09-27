package com.example.guest81.final_productinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relative;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView btn1 = (ImageView) findViewById(R.id.imDepo);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, DepoActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        ImageView btn2 = (ImageView) findViewById(R.id.imApp);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, AppActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        ImageView btn3 = (ImageView) findViewById(R.id.imInst);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, InstActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        ImageView btn4 = (ImageView) findViewById(R.id.imReco);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "준비중 입니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
