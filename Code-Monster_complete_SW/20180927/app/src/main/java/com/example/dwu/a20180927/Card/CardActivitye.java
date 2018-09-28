package com.example.dwu.a20180927.Card;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.dwu.management.R;

import java.util.ArrayList;


public class CardActivitye extends AppCompatActivity {
    ArrayList<String> cardList;
    ArrayAdapter<String> adapter;    // ListView 에 연결할 기본 Adapter
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carde);
        cardList = new ArrayList<String>();
        cardList.add("카드 신청");
        cardList.add("카드 조회");
        cardList.add("카드 사용등록");
        cardList.add("카드 분실신고");
        cardList.add("카드 재발급");
        cardList.add("카드 정지");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cardList);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemClickListener);
    }
    AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
                    int pposition = position+1;
                    Intent intent = new Intent(CardActivitye.this, CardEnglish.class);
                    intent.putExtra(CardEnglish.ACCOUNT_SOUND_NUMBER, pposition);
                    CardActivitye.this.startActivity(intent);
                }
            };
}
