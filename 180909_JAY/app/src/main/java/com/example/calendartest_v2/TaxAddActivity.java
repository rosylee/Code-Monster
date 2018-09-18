package com.example.calendartest_v2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TaxAddActivity extends AppCompatActivity {

    final static String TAG = "TaxAddActivity";
    final String BLANK = "";

    private Intent intent;
    private TextView tvName;
    private DatePicker dpDate;
    private EditText etTex;
    private EditText etMemo;
    private RadioGroup ColorType;


    private MyTaxHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_add);

        intent = getIntent();
        helper = new MyTaxHelper(this);
        String data = intent.getStringExtra("name");

        tvName = (TextView) findViewById(R.id.tvName);
        dpDate = (DatePicker) findViewById(R.id.dpDate);
        etTex = (EditText) findViewById(R.id.etTax);
        etMemo = (EditText) findViewById(R.id.etMemo);
        ColorType = (RadioGroup) findViewById(R.id.ColorType);

        Log.d(TAG, "A");


        tvName.setText(data);
    }

//    TextView.OnClickListener mItemClickListener =
//            new TextView.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    switch (v.getId()){
//                        case R.id.tvAlram:
//                            Toast.makeText(TaxAddActivity.this, "알람", Toast.LENGTH_SHORT).show();
//
//                            break;
//                        case R.id.tvColor:
//                            Toast.makeText(TaxAddActivity.this, "color", Toast.LENGTH_SHORT).show();
//
//                            break;
//                    }
//                }
//            };

    public void mClick(View v){
        switch (v.getId()) {
            case R.id.btn_tax_add:

                String name = tvName.getText().toString();
                String year = String.valueOf(dpDate.getYear());
                String month = String.valueOf(dpDate.getMonth()+1);
                String day = String.valueOf(dpDate.getDayOfMonth());
                String tax = etTex.getText().toString();
                String memo = etMemo.getText().toString();
                String type = "";

                int checkedRB = ColorType.getCheckedRadioButtonId();

                switch(checkedRB){
                    case R.id.Rbtn_RED:
                        type = "RED";
                        break;

                    case R.id.Rbtn_ORA:
                        type = "ORA";
                        break;
                    case R.id.Rbtn_YEL:
                        type = "YEL";
                        break;
                    case R.id.Rbtn_GRN:
                        type = "GRN";
                        break;
                }

                if (name.equals(BLANK) || year.equals(BLANK) || month.equals(BLANK) || day.equals(BLANK) || tax.equals(BLANK) || memo.equals(BLANK) || type.equals(BLANK)){
                    Toast.makeText(this, "항목을 전부 입력하세요!", Toast.LENGTH_SHORT).show();
                }else {

                    SQLiteDatabase db_add = helper.getWritableDatabase();
                    ContentValues row = new ContentValues();
                    row.put(MyTaxHelper.COL_NAME, name);
                    row.put(MyTaxHelper.COL_YEAR, year);
                    row.put(MyTaxHelper.COL_MONTH, month);
                    row.put(MyTaxHelper.COL_DAY, day);
                    row.put(MyTaxHelper.COL_TAX, tax);
                    row.put(MyTaxHelper.COL_MEMO, memo);
                    row.put(MyTaxHelper.COL_TYPE, type);

                    Log.d(TAG, row.toString());

                    long count = db_add.insert(MyTaxHelper.TABLE_NAME, null, row);

                    if (count > 0) {
                        setResult(RESULT_OK, null);
                        helper.close();
                        finish();

                    } else {
                        Toast.makeText(this, "데이터 추가 실패!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        helper.close();
                    }
                }
                break;

            case R.id.btn_tax_can:
                setResult(RESULT_CANCELED);
                finish();

                break;
        }
    }
}
