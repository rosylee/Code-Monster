package com.example.dwu.a20180927.Loans;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.dwu.management.R;

import java.util.ArrayList;


public class LoanActivitye extends AppCompatActivity {
    ArrayList<String> loanList;
    ArrayAdapter<String> adapter;    // ListView 에 연결할 기본 Adapter
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loanse);
        loanList = new ArrayList<String>();
        loanList.add("원금");
        loanList.add("이자율");
        loanList.add("상환");
        loanList.add("납부");
        loanList.add("한도");
        loanList.add("연장");
        loanList.add("약정");
        loanList.add("철회");
        loanList.add("생활비대출");
        loanList.add("주택담보");
        loanList.add("예금담보");
        loanList.add("정기예금");
        loanList.add("수수료");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, loanList);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemClickListener);
    }
    AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
                    int pposition = position+1;
                    Intent intent = new Intent(LoanActivitye.this, LoanEnglish.class);
                    intent.putExtra(LoanEnglish.ACCOUNT_SOUND_NUMBER, pposition);
                    LoanActivitye.this.startActivity(intent);
                }
            };
}
