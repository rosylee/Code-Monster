package com.example.dwu.a20180927;

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

import com.example.dwu.management.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ah_AppActivity extends AppCompatActivity {

    private AppDBHelper dbHelper;
    private ArrayList<ah_Product> ahProductList = new ArrayList<ah_Product>();
    private ah_Adapter myAhAdapter;
    private ListView listView;

    Comparator<ah_Product> asc;
    Comparator<ah_Product> dsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ah_activity_list);

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
                myAhAdapter.getFilter().filter(search);
            }
        });

        dbHelper = new AppDBHelper(this);
        Log.d("test", "app");

        listView = (ListView) findViewById(R.id.dpListView);

        myAhAdapter = new ah_Adapter(this, R.layout.ah_list_layout, ahProductList);

        listView.setAdapter(myAhAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ah_AppActivity.this, ah_AppDetailActivity.class);
                intent.putExtra("id", id);
                ah_AppActivity.this.startActivity(intent);
            }
        });

        asc = new Comparator<ah_Product>() {
            @Override
            public int compare(ah_Product p1, ah_Product p2) { return p2.getRate().compareTo(p1.getRate()); }
        };

        dsc = new Comparator<ah_Product>() {
            @Override
            public int compare(ah_Product p1, ah_Product p2) { return p1.getRate().compareTo(p2.getRate()); }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTable();
    }

    private void setTable() {
        ahProductList.clear();

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

            ah_Product list = new ah_Product(_id, bank, title, info, type, user, amount, rate, term);

            ahProductList.add(list);
        }

        cursor.close();
        dbHelper.close();

        myAhAdapter.notifyDataSetChanged();
    }

    public void onPopupButtonClick(View button){
        PopupMenu popup = new PopupMenu(this,button);

        popup.getMenuInflater().inflate(R.menu.ah_menu,popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.itemRate:
                        Collections.sort(ahProductList,asc);
                        myAhAdapter.notifyDataSetChanged();
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
