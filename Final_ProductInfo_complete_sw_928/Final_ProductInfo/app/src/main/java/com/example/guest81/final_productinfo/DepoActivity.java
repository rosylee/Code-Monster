package com.example.guest81.final_productinfo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//implements RadioGroup.OnCheckedChangeListener
public class DepoActivity extends AppCompatActivity {

    private DepoDBHelper dbHelper;
    private ArrayList<Product> ProductList;
    private Adapter myAdapter;
    private ListView listView;

//    RadioGroup group;
    Comparator<Product> asc;
    Comparator<Product> dsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

//        group = (RadioGroup)findViewById(R.id.rGroup);
//        group.setOnCheckedChangeListener(this);
        dbHelper = new DepoDBHelper(this);
        Log.d("test", "depo");

        listView = (ListView) findViewById(R.id.dpListView);

        ProductList = new ArrayList<Product>();
        myAdapter = new Adapter(this, R.layout.list_layout,ProductList);

        listView.setAdapter(myAdapter);

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DepoActivity.this, DepoDetailActivity.class);
                intent.putExtra("id", id);
                DepoActivity.this.startActivity(intent);
            }
        });

        asc = new Comparator<Product>() {
            @Override public int compare(Product p1, Product p2) { return p2.getRate().compareTo(p1.getRate()); }
        };

        dsc = new Comparator<Product>() {
            @Override public int compare(Product p1, Product p2) { return p1.getRate().compareTo(p2.getRate()); }
        };
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

    public void onPopupButtonClick(View button){
        PopupMenu popup = new PopupMenu(this,button);

        popup.getMenuInflater().inflate(R.menu.menu,popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.itemRate:
                        Collections.sort(ProductList,asc);
                        myAdapter.notifyDataSetChanged();
                        break;
                    case R.id.itemBank:
                        break;
                }
                return true;
            }
        });

        popup.show();
    }
}