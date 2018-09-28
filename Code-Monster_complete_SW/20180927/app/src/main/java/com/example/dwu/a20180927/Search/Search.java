package com.example.dwu.a20180927.Search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.example.dwu.management.R;

import java.util.ArrayList;


public class Search extends AppCompatActivity implements AdapterView.OnItemClickListener {
    CustomerAdapter adapter = null;
    ArrayList<Customer> customers = null;
    ListView myCustomListView;
   /* SearchView mySearchView = null;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountsearch);
        customers = new ArrayList<>();
        customers = populateCustomerData(customers);
       /* mySearchView = (SearchView) findViewById(R.id.mySearchView);*/
        myCustomListView = (ListView) findViewById(R.id.myCustomListView);
        adapter = new CustomerAdapter(this, customers);
        myCustomListView.setAdapter(adapter);
        EditText etSearch = (EditText)findViewById(R.id.etSearch);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                String search = s.toString();
                adapter.getFilter().filter(search);
            }
        });
        myCustomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                int _id = Integer.parseInt(view.getTag().toString());
                switch(_id) {
                    case 1:
                        intent = new Intent(Search.this, account1.class);
                        break;
                    case 2:
                        intent = new Intent(Search.this, account2.class);
                        break;
                    case 3:
                        intent = new Intent(Search.this, account3.class);
                        break;
                    case 4:
                        intent = new Intent(Search.this, account4.class);
                        break;
                    case 5:
                        intent = new Intent(Search.this, account5.class);
                        break;
                    case 6:
                        intent = new Intent(Search.this, account6.class);
                        break;
                    case 7:
                        intent = new Intent(Search.this, account7.class);
                        break;
                    case 8:
                        intent = new Intent(Search.this, account8.class);
                        break;
                    case 9:
                        intent = new Intent(Search.this, account9.class);
                        break;
                    case 14:
                        intent = new Intent(Search.this, account14.class);
                        break;
                    case 15:
                        intent = new Intent(Search.this, account15.class);
                        break;
                    case 16:
                        intent = new Intent(Search.this, account16.class);
                        break;
                    case 17:
                        intent = new Intent(Search.this, account17.class);
                        break;
                    case 18:
                        intent = new Intent(Search.this, account18.class);
                        break;
                    case 19:
                        intent = new Intent(Search.this, account19.class);
                        break;
                    case 20:
                        intent = new Intent(Search.this, account20.class);
                        break;
                    case 24:
                        intent = new Intent(Search.this, account24.class);
                        break;
                    case 25:
                        intent = new Intent(Search.this, account25.class);
                        break;
                    case 26:
                        intent = new Intent(Search.this, account26.class);
                        break;
                    case 27:
                        intent = new Intent(Search.this, account27.class);
                        break;
                    case 28:
                        intent = new Intent(Search.this, account28.class);
                        break;
                    case 29:
                        intent = new Intent(Search.this, account29.class);
                        break;
                    case 30:
                        intent = new Intent(Search.this, account30.class);
                        break;
                    case 31:
                        intent = new Intent(Search.this, account31.class);
                        break;
                    case 32:
                        intent = new Intent(Search.this, account32.class);
                        break;
                    case 33:
                        intent = new Intent(Search.this, account33.class);
                        break;
                }
                startActivity(intent);
            }
        });
       /* mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s)
            {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                // Here implement search logic
                adapter.getFilter().filter(s);
                adapter.notifyDataSetChanged();
                return false;
            }
        });*/
    }
         private ArrayList<Customer> populateCustomerData(ArrayList<Customer> customers) {
            customers.add(new Customer("조회", 1, R.drawable.account));
            customers.add(new Customer("인출", 2, R.drawable.account));
            customers.add(new Customer("입금", 3, R.drawable.account));
            customers.add(new Customer("출금", 4, R.drawable.account));
            customers.add(new Customer("이체", 5, R.drawable.account));
            customers.add(new Customer("송금", 6, R.drawable.account));
            customers.add(new Customer("인터넷뱅킹", 7, R.drawable.investment));
            customers.add(new Customer("자동이체", 8, R.drawable.investment));
            customers.add(new Customer("해외송금", 9, R.drawable.investment));
            customers.add(new Customer("원금", 14, R.drawable.loan));
            customers.add(new Customer("이자율", 15, R.drawable.loan));
            customers.add(new Customer("상환", 16, R.drawable.loan));
            customers.add(new Customer("납부", 17, R.drawable.loan));
            customers.add(new Customer("한도", 18, R.drawable.loan));
            customers.add(new Customer("연장", 19, R.drawable.loan));
            customers.add(new Customer("약정", 20, R.drawable.loan));
            customers.add(new Customer("카드 신청", 24, R.drawable.card));
            customers.add(new Customer("카드 조회", 25, R.drawable.card));
            customers.add(new Customer("카드 사용등록", 26, R.drawable.card));
            customers.add(new Customer("카드 분실신고", 27, R.drawable.card));
            customers.add(new Customer("카드 재발급", 28, R.drawable.card));
            customers.add(new Customer("카드 정지", 29, R.drawable.card));
            customers.add(new Customer("OTP", 30, R.drawable.certification));
            customers.add(new Customer("공인인증", 31, R.drawable.certification));
            customers.add(new Customer("바이오인증", 32, R.drawable.certification));
            customers.add(new Customer("인증서", 33, R.drawable.certification));
            return customers;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Customer c = adapter.getItem(position);
    }
}
