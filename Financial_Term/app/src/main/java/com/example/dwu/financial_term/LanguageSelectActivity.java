package com.example.dwu.financial_term;
//중국어 모드임!

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LanguageSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectlanguage);

        ImageButton china = (ImageButton)findViewById(R.id.china);
      /*  ImageButton philippines = (ImageButton) findViewById(R.id.philippines);
        ImageButton english = (ImageButton) findViewById(R.id.english);
        ImageButton vietnam = (ImageButton) findViewById(R.id.vietnam);
        ImageButton japan = (ImageButton) findViewById(R.id.japan);*/



        china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(LanguageSelectActivity.this, MainActivity.class);
                LanguageSelectActivity.this.startActivity(mainIntent);
            }
        });
        //밑에 필리핀, 영어 등등등 클릭 코드 넣기 activity_main2 만들어서 영어랑 연동, 3는 필리핀어, 등등~~~

    }
}