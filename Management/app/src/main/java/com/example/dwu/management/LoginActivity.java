package com.example.dwu.management;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


            TextView registerButton = (TextView)findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                    //로그인 액티비티에서 레지스터 액티비티로 넘어갈 수 있도록 인텐트 해줌.
                    LoginActivity.this.startActivity(registerIntent);// 레지스터인텐트를 통해 버튼을 클릭했을 때 레지스터인텐트를 통해 레지스터액티비티 실행 가능.
                }
            });
            final EditText idText = (EditText)findViewById(R.id.idText);
            final EditText passwordText = (EditText)findViewById(R.id.passwordText);
            final Button loginButton = (Button)findViewById(R.id.loginButton);


        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final String userID = idText.getText().toString();
                final String userPassword = passwordText.getText().toString();

                //4. 콜백 처리부분(volley 사용을 위한 ResponseListener 구현 부분)
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                               /* AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                 builder.setMessage("로그인에 성공했습니다.")
                                         .setPositiveButton("확인",null)
                                         .create()
                                         .show();*/
                               //로그인 성공시 토스트
                                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                                String userID = jsonResponse.getString("userID");
                                String userPassword = jsonResponse.getString("userPassword");
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("userID", userID);
                                intent.putExtra("userPassword", userPassword);
                                LoginActivity.this.startActivity(intent);
                                finish();
                            }
                            else{//로그인 실패시
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("계정을 다시 확인하세요.")
                                        .setNegativeButton("다시 시도",null)
                                        .create()
                                        .show();
                            }
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPassword,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        if(dialog !=null){
         dialog.dismiss();
         dialog = null;
        }

    }
}
