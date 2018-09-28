package com.example.dwu.a20180927.Certification;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.dwu.management.R;

import java.util.ArrayList;


public class CertificationActivitye extends AppCompatActivity {
    ArrayList<String> cerList;
    ArrayAdapter<String> adapter;    // ListView 에 연결할 기본 Adapter
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificatione);
        cerList = new ArrayList<String>();
        cerList.add("OTP");
        cerList.add("공인인증");
        cerList.add("바이오인증");
        cerList.add("인증서");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cerList);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemClickListener);
    }
    AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
                    int pposition = position+1;
                    Intent intent = new Intent(CertificationActivitye.this, CertificationEnglish.class);
                    intent.putExtra(CertificationEnglish.ACCOUNT_SOUND_NUMBER, pposition);
                    CertificationActivitye.this.startActivity(intent);
                }
            };
}
