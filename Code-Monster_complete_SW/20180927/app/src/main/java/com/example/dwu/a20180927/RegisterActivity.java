package com.example.dwu.a20180927;
//회원이 회원가입 하지 않았을 때 새롭게 등록할 수 있는 화면.
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.dwu.management.R;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private ArrayAdapter adapter;
    private Spinner spinner;
    private String userGender;
    private AlertDialog dialog;
    private boolean validate = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //회원등록과 관련한 화면 처리 액티비티
        spinner = (Spinner)findViewById(R.id.age);
        adapter = ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        final EditText idText = (EditText)findViewById(R.id.idText);
        final EditText passwordText = (EditText)findViewById(R.id.passwordText);
        final EditText nameText = (EditText)findViewById(R.id.nameText);
        final RadioGroup genderGroup = (RadioGroup)findViewById(R.id.genderGroup);
        int genderGroupID = genderGroup.getCheckedRadioButtonId();
        userGender = ((RadioButton)findViewById(genderGroupID)).getText().toString();
        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton genderButton = (RadioButton)findViewById(i);
                userGender = genderButton.getText().toString();
            }
        });



        ImageView registerButton = (ImageView)findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String userID = idText.getText().toString();
                String userPassword = passwordText.getText().toString();
                String userName = nameText.getText().toString();
                String userAge = spinner.getSelectedItem().toString();
                if(userID.getBytes().length <=0){
                    Toast.makeText(RegisterActivity.this, "id를 입력해주세요." ,Toast.LENGTH_SHORT).show();
                    return;
                }else if(userPassword.getBytes().length <=0){
                    Toast.makeText(RegisterActivity.this, "password를 입력해주세요." ,Toast.LENGTH_SHORT).show();
                    return;
                }else if(userName.getBytes().length<=0){
                    Toast.makeText(RegisterActivity.this,"name을 입력해주세요.",Toast.LENGTH_SHORT).show();
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("회원 등록에 성공했습니다.")
                                        .setPositiveButton("확인",null)
                                        .create()
                                        .show();
                                finish();

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("회원 등록에 실패했습니다.")
                                        .setNegativeButton("확인",null)
                                        .create()
                                        .show();
                                /*Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);*/
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(userID,userPassword,userName,userGender,userAge,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
    @Override
    protected void onStop(){
        super.onStop();
        if(dialog !=null){
            dialog.dismiss();
            dialog=null;
        }
    }

}

