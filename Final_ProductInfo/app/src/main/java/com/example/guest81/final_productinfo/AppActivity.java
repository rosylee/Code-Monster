package com.example.guest81.final_productinfo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AppActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private AppDBHelper dbHelper;
    private ArrayList<Product> ProductList;
    private Adapter myAdapter;
    private ListView listView;

    RadioGroup group;
    Comparator<Product> asc;
    Comparator<Product> dsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        EditText etSearch = (EditText)findViewById(R.id.etSearch);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable e) {
                String search = e.toString();
                myAdapter.getFilter().filter(search);
            }
        });


        //라디오 버튼 말고 메뉴버튼으로 수정
        group = (RadioGroup)findViewById(R.id.rGroup);
        group.setOnCheckedChangeListener(this);

        dbHelper = new AppDBHelper(this);
        Log.d("test", "app");

        listView = (ListView) findViewById(R.id.dpListView);

        ProductList = new ArrayList<Product>();
        myAdapter = new Adapter(this, R.layout.list_layout,ProductList);

        listView.setAdapter(myAdapter);

        //금리비교

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AppActivity.this, AppDetailActivity.class);
                intent.putExtra("id", id);
                AppActivity.this.startActivity(intent);
            }
        });

//        asc = new Comparator<Product>() {
//            @Override public int compare(Product p1, Product p2) { return p2.getBank().compareTo(p1.getBank()); }
//        };
//
//        dsc = new Comparator<Product>() {
//            @Override public int compare(Product p1, Product p2) { return p1.getBank().compareTo(p2.getBank()); }
//        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTable();
    }

    private void setTable() {
        ProductList.clear();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] cols = null;
        String whereClause = null;
        String[] whereArgs = null;

        Cursor cursor = db.query(dbHelper.TABLE_NAME, cols, whereClause, whereArgs, null, null, null, null);

        while (cursor.moveToNext()) {
            long _id = cursor.getInt(0);
            String bank = cursor.getString(1);
            String title = cursor.getString(2);
            String info = cursor.getString(3);
            String type = cursor.getString(4);
            String user = cursor.getString(5);
            String amount = cursor.getString(6);
            Double rate = cursor.getDouble(7);
            String term = cursor.getString(8);

            Product list = new Product(_id, bank, title, info, type, user, amount, rate, term);

            ProductList.add(list);
        }

        cursor.close();
        dbHelper.close();

        myAdapter.notifyDataSetChanged();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.my_menu, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId())
//        {
//            case R.id.AddItem:
//                startActivity(new Intent(MainActivity.this, SubActivity2.class));
//                break;
//
//            case R.id.Introduce:
//                startActivity(new Intent(MainActivity.this, SubActivity1.class));
//                break;
//
//            case R.id.Exit:
//                finish();
//                break;
//        }
//        return true;
//    }
//
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId){
        switch (checkedId){
            case R.id.btnRate1:
                Collections.sort(ProductList,asc);
                myAdapter.notifyDataSetChanged();
                break;

            case R.id.btnRate2 :
                Collections.sort(ProductList,dsc);
                myAdapter.notifyDataSetChanged();
                break;

        }
    }
}
