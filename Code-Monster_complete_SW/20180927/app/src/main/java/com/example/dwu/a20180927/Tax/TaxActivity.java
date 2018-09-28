package com.example.dwu.a20180927.Tax;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dwu.management.R;
import java.util.ArrayList;


public class TaxActivity extends AppCompatActivity {
    ArrayList<String> taxList;
    ArrayAdapter<String> adapter;    // ListView 에 연결할 기본 Adapter
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);
        taxList = new ArrayList<String>();
        taxList.add("공과금");
        taxList.add("납부");
        taxList.add("지로");
        taxList.add("외국인 소득세");
        taxList.add("전기세");
        taxList.add("도시가스");
        taxList.add("상하수도요금(수도세)");
        taxList.add("소득세");
        taxList.add("재산세");
        taxList.add("주민세");
        taxList.add("통신비");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, taxList);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemClickListener);
    }
    AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
                    int pposition = position+1;
                    Intent intent = new Intent(TaxActivity.this, TaxChinese.class);
                    intent.putExtra(TaxChinese.ACCOUNT_SOUND_NUMBER, pposition);
                    TaxActivity.this.startActivity(intent);
                }
            };
}
