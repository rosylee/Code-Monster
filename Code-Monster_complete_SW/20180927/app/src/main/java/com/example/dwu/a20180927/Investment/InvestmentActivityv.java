package com.example.dwu.a20180927.Investment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.dwu.management.R;

import java.util.ArrayList;


public class InvestmentActivityv extends AppCompatActivity {
    ArrayList<String> investmentList;
    ArrayAdapter<String> adapter;    // ListView 에 연결할 기본 Adapter
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investmentv);
        investmentList = new ArrayList<String>();
        investmentList.add("예금");
        investmentList.add("적금");
        investmentList.add("청약");
        investmentList.add("경매");
        investmentList.add("매물");
        investmentList.add("부동산");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, investmentList);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemClickListener);
    }
    AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
                    int pposition = position+1;
                    Intent intent = new Intent(InvestmentActivityv.this, InvestmentVietnamese.class);
                    intent.putExtra(InvestmentVietnamese.ACCOUNT_SOUND_NUMBER, pposition);
                    InvestmentActivityv.this.startActivity(intent);
                }
            };
}
