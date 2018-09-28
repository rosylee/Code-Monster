package com.example.dwu.a20180927;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dwu.management.R;

public class TaxAddActivity extends AppCompatActivity {

    final static String TAG = "TaxAddActivity";
    final String BLANK = "";

    private Intent intent;
    private ImageView tvName;
    private TextView tvName2;
    private DatePicker dpDate;
    private EditText etTex;
    private EditText etMemo;
    private RadioGroup ColorType;
    private String data;


    private MyTaxHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.um_activity_tax_add);

        intent = getIntent();
        helper = new MyTaxHelper(this);
        data = intent.getStringExtra("name");

        tvName = (ImageView) findViewById(R.id.tvName);
        tvName2 = (TextView) findViewById(R.id.tvName2);
        dpDate = (DatePicker) findViewById(R.id.dpDate);
        etTex = (EditText) findViewById(R.id.etTax);
        etMemo = (EditText) findViewById(R.id.etMemo);
        ColorType = (RadioGroup) findViewById(R.id.ColorType);

        Log.d(TAG, "A");


        switch (data){
            case "foreign":
                tvName.setImageResource(R.drawable.foreign);
                tvName2.setText("외국인소득세");
                break;
            case "warter":
                tvName.setImageResource(R.drawable.water);
                tvName2.setText("한국상하수도협회");

                break;

            case "gas":
                tvName.setImageResource(R.drawable.gas);
                tvName2.setText("한국가스공사");

                break;

            case "electric":
                tvName.setImageResource(R.drawable.ele);
                tvName2.setText("한국전력공사");

                break;
        }


    }

    public void mClick(View v){
        switch (v.getId()) {
            case R.id.btn_tax_add:

                String name = data;
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
                    SharedPreferences mPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    int id = mPref.getInt("ID", 0);
                    if(id ==0 ) {
                        row.put(MyTaxHelper.COL_PO_ID, 6);
                    }else {
                        row.put(MyTaxHelper.COL_PO_ID, id);
                    }

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
        }
    }
}
