package com.example.dwu.financial_term;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class AccountActivity extends AppCompatActivity {
    private int a;
    ArrayList<String> accountList;
    ArrayAdapter<String> adapter;    // ListView 에 연결할 기본 Adapter
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ArrayList<String> accountList= new ArrayList<String>();
        accountList.add("조회");
        accountList.add("인출");
        accountList.add("입금");


        adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, accountList);

        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemClickListener);


    }
    AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   /* Toast.makeText(this, accountList.get(i), Toast.LENGTH_SHORT ).show();*/

                    setContentView(R.layout.word01);
                    /*accountList.get(i);*/



                    }

            };

}
