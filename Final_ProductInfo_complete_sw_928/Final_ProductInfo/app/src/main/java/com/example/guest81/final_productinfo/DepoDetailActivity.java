package com.example.guest81.final_productinfo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DepoDetailActivity extends AppCompatActivity {

//    TextView tvBank; //은행명
    TextView tvTitle; //상품명
    TextView tvInfo; //상품소개
    TextView tvType; //상품유형
    TextView tvUser; //대상
    TextView tvAmount; //가입금액
    TextView tvRate; //금리
    TextView tvTerm; //기간

    private DepoDBHelper dbHelper;
    SQLiteDatabase db;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dbHelper = new DepoDBHelper(this);
        db = dbHelper.getWritableDatabase();

        Intent intent = getIntent();
        id = intent.getLongExtra("id", -1);


        if(id == -1)
            finish();

//        tvBank = (TextView) findViewById(R.id.tvBank);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvInfo = (TextView)findViewById(R.id.tvInfo);
        tvType = (TextView)findViewById(R.id.tvType);
        tvUser = (TextView)findViewById(R.id.tvUser);
        tvAmount = (TextView)findViewById(R.id.tvAmount);
        tvRate = (TextView)findViewById(R.id.tvRate);
        tvTerm = (TextView)findViewById(R.id.tvTerm);


        String[] cols = null;
        String whereClause = dbHelper.COL_ID + "=?";
        String[] whereArgs = {String.valueOf(id)};

        Cursor cursor = db.query(dbHelper.TABLE_NAME, cols, whereClause, whereArgs, null, null, null, null);

        while (cursor.moveToNext()) {
            String bank = cursor.getString(1);
            String title = cursor.getString(2);
            String info = cursor.getString(3);
            String type = cursor.getString(4);
            String user = cursor.getString(5);
            String amount = cursor.getString(6);
            Double rate = cursor.getDouble(7);
            String term = cursor.getString(8);

//            tvBank.setText(bank);
            tvTitle.setText(title);
            tvInfo.setText(info);
            tvType.setText(type);
            tvUser.setText(user);
            tvAmount.setText(amount);
            tvRate.setText(Double.valueOf(rate).toString());
            tvTerm.setText(term);
        }

        cursor.close();
    }
}
