package com.example.dwu.a20180927.Account;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.dwu.management.R;
import java.util.ArrayList;

public class AccountActivityv extends AppCompatActivity {

    ArrayList<String> accountList;
    ArrayAdapter<String> adapter;    // ListView 에 연결할 기본 Adapter
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountv);

        accountList= new ArrayList<String>();
        accountList.add("조회");
        accountList.add("인출");
        accountList.add("입금");
        accountList.add("출금");
        accountList.add("이체/송금");
        accountList.add("인터넷뱅킹");
        accountList.add("자동이체");
        accountList.add("해외송금");
        accountList.add("캐시백");
        accountList.add("한도");
        accountList.add("만기");
        accountList.add("투자");

        adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, accountList);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemClickListener);
    }
    AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
                    int pposition = position+1;
                    Intent intent = new Intent(AccountActivityv.this, AccountVietnamese.class);
                    intent.putExtra(AccountVietnamese.ACCOUNT_SOUND_NUMBER, pposition);
                    AccountActivityv.this.startActivity(intent);
                }
            };
}

