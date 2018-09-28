package com.example.dwu.a20180927;
//중국어 모드임!

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dwu.management.R;

public class LanguageSelectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectlanguage);

        ImageButton china = (ImageButton)findViewById(R.id.china);
        ImageButton english = (ImageButton) findViewById(R.id.english);
        ImageButton vietnam = (ImageButton) findViewById(R.id.vietnam);
        ImageButton france = (ImageButton)findViewById(R.id.france);
        ImageButton japan = (ImageButton)findViewById(R.id.japan);
        china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(LanguageSelectActivity.this, selectfield.class);
                LanguageSelectActivity.this.startActivity(mainIntent);
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent2 = new Intent(LanguageSelectActivity.this, selectfield2.class);
                LanguageSelectActivity.this.startActivity(mainIntent2);
            }
        });
        vietnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent3 = new Intent(LanguageSelectActivity.this, selectfield3.class);
                LanguageSelectActivity.this.startActivity(mainIntent3);
            }
        });
        france.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(LanguageSelectActivity.this, "추후 업데이트 예정입니다.",Toast.LENGTH_SHORT).show();
            }
        });
        japan.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(LanguageSelectActivity.this, "추후 업데이트 예정입니다.",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
