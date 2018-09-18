package com.example.guest81.myproductinfo;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DepoActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private DepoDBHelper dbHelper;
    private ListView listView;
    private DepoAdapter adapter;
    private ArrayList<Product> movieList;

    RadioGroup group;
    Comparator<Product> Date1;
    Comparator<Product> Date2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depo);

        group = (RadioGroup)findViewById(R.id.rGroup);
        group.setOnCheckedChangeListener(this);

        dbHelper = new DepoDBHelper(this);

        listView = (ListView) findViewById(R.id.dpListView);

        movieList = new ArrayList<Product>();
        adapter = new DepoAdapter(this, R.layout.layout_product_list, movieList);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final int pos = position;

                AlertDialog.Builder builder = new AlertDialog.Builder(DepoActivity.this);
                builder.setTitle("경고")
                        .setMessage("선택하신 " + movieList.get(pos).getTitle() + "의 리뷰를 삭제하시겠습니까?")
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SQLiteDatabase db = dbHelper.getWritableDatabase();

                                String whereClause = dbHelper.COL_ID + "=?";
                                String[] whereArgs = new String[] { String.valueOf(movieList.get(pos).get_id()) };
                                db.delete(dbHelper.TABLE_NAME, whereClause, whereArgs);

                                Toast.makeText(DepoActivity.this, movieList.get(pos).getTitle() +"의 리뷰가 삭제 되었습니다", Toast.LENGTH_SHORT).show();

                                dbHelper.close();
                                onResume();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();

                return true;
            }
        });

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

        Date1 = new Comparator<Product>() {
            @Override
            public int compare(Product m1, Product m2) { return m2.getDate().compareTo(m1.getDate()); }
        };

        Date2 = new Comparator<Product>() {
            @Override
            public int compare(Product m1, Product m2) { return m1.getDate().compareTo(m2.getDate()); }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTable();
    }

    private void setTable() {
        movieList.clear();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] cols = null;
        String whereClause = null;
        String[] whereArgs = null;

        Cursor cursor = db.query(dbHelper.TABLE_NAME, cols, whereClause, whereArgs, null, null, null, null);

        while (cursor.moveToNext()) {
            int _id = cursor.getInt(0);
            String title = cursor.getString(1);
            String director = cursor.getString(2);
            String date = cursor.getString(3);
            String mark = cursor.getString(4);
            String actor = cursor.getString(5);

            Product list = new Product(_id, title, director, date, mark, actor);

            movieList.add(list);
        }

        cursor.close();
        dbHelper.close();

        adapter.notifyDataSetChanged();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId())
//        {
//            case R.id.itemAdd:
//                startActivity(new Intent(MainActivity.this, AddActivity.class));
//                break;
//
//            case R.id.itemDeveloper:
//                startActivity(new Intent(MainActivity.this, IntroActivity.class));
//                break;
//
//            case R.id.itemFinish:
//                finish();
//                break;
//        }
//        return true;
//    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.btnRate1:
                Collections.sort(movieList, Date1);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "최근 리뷰 순서입니다", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnRate2:
                Collections.sort(movieList, Date2);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "오래된 리뷰 순서입습니다", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
