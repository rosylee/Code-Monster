package com.example.dwu.a20180927;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dwu.management.R;
import com.example.dwu.a20180927.MenuActivity;


public class MenuActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView calender = (TextView)findViewById(R.id.calender);
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MenuActivity.this,um_MainActivity.class);
                MenuActivity.this.startActivity(i1);
                /*Toast.makeText(MenuActivity.this, "캘린더로 이동 나중에 합치기",Toast.LENGTH_SHORT).show();*/
            }
        });
        TextView dictionary = (TextView)findViewById(R.id.dictionary);
        dictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MenuActivity.this,LanguageSelectActivity.class);
                MenuActivity.this.startActivity(i1);

            }
        });
        TextView findbank = ( TextView)findViewById(R.id.findbank);
        findbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MenuActivity.this,hr_MainActivity.class);
                MenuActivity.this.startActivity(i1);
//                Toast.makeText(MenuActivity.this, "해외지점찾기로 이동 나중에 합치기",Toast.LENGTH_SHORT).show();
            }
        });
        TextView bankproduct = (TextView )findViewById(R.id.bankproduct);
        bankproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MenuActivity.this,ah_MainActivity.class);
                MenuActivity.this.startActivity(i1);
//                Toast.makeText(MenuActivity.this, "은행상품으로 이동 나중에 합치기",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
