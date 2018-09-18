package com.example.dwu.financial_term;
/*중국어 모드임!
MyAdapter, MyData 만들어 놓기
*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MyData> myDataList;
    private MyAdapter myAdapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDataList = new ArrayList<MyData>();

        myDataList.add(new MyData("계좌","123"));
        myDataList.add(new MyData("인출","456"));
        myDataList.add(new MyData("입금","789"));
        myDataList.add(new MyData("출금","1011"));


        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button5= (Button)findViewById(R.id.button5);
        Button button6= (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accountIntent = new Intent(MainActivity.this,AccountActivity.class);
                //로그인 액티비티에서 레지스터 액티비티로 넘어갈 수 있도록 인텐트 해줌.
                MainActivity.this.startActivity(accountIntent);

                /*MainActivity.this.startActivity(accountIntent);*/// 레지스터인텐트를 통해 버튼을 클릭했을 때 레지스터인텐트를 통해 레지스터액티비티 실행 가능.
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent card= new Intent(MainActivity.this,CardActivity.class);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent certification = new Intent(MainActivity.this, CertificationActivity.class);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent investment = new Intent(MainActivity.this, InvestmentActivity.class);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loans = new Intent(MainActivity.this, LoansActivity.class);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tax = new Intent(MainActivity.this, TaxActivity.class);
            }
        });

    }
}
