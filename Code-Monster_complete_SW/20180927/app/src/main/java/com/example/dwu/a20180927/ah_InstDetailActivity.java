package com.example.dwu.a20180927;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dwu.management.R;

public class ah_InstDetailActivity extends AppCompatActivity {

//    TextView tvBank; //은행명
    ImageView ivImage;//은행로고
    TextView tvTitle; //상품명
    TextView tvInfo; //상품소개
    TextView tvType; //상품유형
    TextView tvUser; //대상
    TextView tvAmount; //가입금액
    TextView tvRate; //금리
    TextView tvTerm; //기간

    private InstDBHelper dbHelper;
    SQLiteDatabase db;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ah_activity_detail);

        dbHelper = new InstDBHelper(this);
        db = dbHelper.getWritableDatabase();

        Intent intent = getIntent();
        id = intent.getLongExtra("id", -1);


        if(id == -1)
            finish();

//        tvBank = (TextView) findViewById(R.id.tvBank);
        ivImage = (ImageView)findViewById(R.id.ivImage);
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

            switch (bank){
                case "신한":
                    ivImage.setImageResource(R.drawable.shinha_logo);
                    break;

                case "국민":
                    ivImage.setImageResource(R.drawable.kb_logo);
                    break;

                case "우리":
                    ivImage.setImageResource(R.drawable.woori_logo);
                    break;

                case "하나":
                    ivImage.setImageResource(R.drawable.hana_logo);
                    break;

                case "농협":
                    ivImage.setImageResource(R.drawable.nh_logo);
                    break;
            }

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
