package com.example.dwu.a20180927;
//로그인 성공했을 때 나오는 화면
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dwu.management.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView idText = (TextView)findViewById(R.id.idText);
        TextView passwordText = (TextView)findViewById(R.id.passwordText);
        TextView welcomeMessage = (TextView)findViewById(R.id.welcomeMessage);
        Intent aa = getIntent();
        String userID = aa.getStringExtra("userID");
        String userPassword = aa.getStringExtra("userPassword");
        String message = "환영합니다, "+ userID + "님!";

        idText.setText(userID);
        passwordText.setText(userPassword);
        welcomeMessage.setText(message);

    }
}

