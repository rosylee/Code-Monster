package com.example.dwu.a20180927;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.dwu.management.R;

import java.util.ArrayList;

public class um_MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity_log";
    final int REQ_CODE = 100;

    public MyTaxHelper taxHelper;
    private ArrayList<ScheduleVo> myDataList;

    private um_ScheduleCalendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        taxHelper = new MyTaxHelper(this);


        SharedPreferences mPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        boolean result = mPref.getBoolean("DATA", false);

        if (!result) {
            taxHelper.addMemberConfiguration(new um_MemberVo(1, "정재현", "1997-02-14", "010-1234-5678", "A123456789", "123456789a"));
            taxHelper.addMemberConfiguration(new um_MemberVo(2, "홍길동", "1995-03-15", "010-2345-6789", "B123456789", "123456789b"));
            taxHelper.addMemberConfiguration(new um_MemberVo(3, "차은우", "1996-09-05", "010-3456-7891", "C123456789", "123456789c"));
            taxHelper.addMemberConfiguration(new um_MemberVo(4, "김동덕", "1980-01-01", "010-4567-8912", "D123456789", "123456789d"));
            taxHelper.addMemberConfiguration(new um_MemberVo(5, "김나나", "1990-05-07", "010-5678-9123", "E123456789", "123456789e"));

            taxHelper.addTexConfiguration(new um_TaxVo(1, "foreign", "2018", "8", "30", "12000", "", "YEL", "1"));
            taxHelper.addTexConfiguration(new um_TaxVo(1, "water", "2018", "9", "10", "25000", "", "RED", "1"));
            taxHelper.addTexConfiguration(new um_TaxVo(2, "gas", "2018", "9", "11", "20000", "", "GRN", "1"));
            taxHelper.addTexConfiguration(new um_TaxVo(3, "foreign", "2018", "9", "30", "10000", "", "YEL", "1"));
            taxHelper.addTexConfiguration(new um_TaxVo(4, "electric", "2018", "9", "25", "23000", "", "ORA", "1"));
            taxHelper.addTexConfiguration(new um_TaxVo(5, "water", "2018", "8", "10", "31000", "", "RED", "1"));
            taxHelper.addTexConfiguration(new um_TaxVo(6, "gas", "2018", "8", "11", "28000", "", "GRN", "1"));
            taxHelper.addTexConfiguration(new um_TaxVo(7, "foreign", "2018", "8", "30", "12000", "", "YEL", "1"));
            taxHelper.addTexConfiguration(new um_TaxVo(8, "electric", "2018", "8", "25", "25000", "", "ORA", "1"));

            taxHelper.addTexConfiguration(new um_TaxVo(9, "water", "2018", "9", "10", "25000", "", "RED", "2"));
            taxHelper.addTexConfiguration(new um_TaxVo(10, "gas", "2018", "9", "11", "20000", "", "GRN", "2"));
            taxHelper.addTexConfiguration(new um_TaxVo(11, "foreign", "2018", "9", "30", "10000", "", "YEL", "2"));
            taxHelper.addTexConfiguration(new um_TaxVo(12, "electric", "2018", "9", "25", "23000", "", "ORA", "2"));
            taxHelper.addTexConfiguration(new um_TaxVo(13, "water", "2018", "8", "10", "31000", "", "RED", "2"));
            taxHelper.addTexConfiguration(new um_TaxVo(14, "gas", "2018", "8", "11", "28000", "", "GRN", "2"));
            taxHelper.addTexConfiguration(new um_TaxVo(15, "foreign", "2018", "8", "30", "12000", "", "YEL", "2"));
            taxHelper.addTexConfiguration(new um_TaxVo(16, "electric", "2018", "8", "25", "25000", "", "ORA", "2"));

            taxHelper.addTexConfiguration(new um_TaxVo(17, "water", "2018", "9", "10", "25000", "", "RED", "3"));
            taxHelper.addTexConfiguration(new um_TaxVo(18, "gas", "2018", "9", "11", "20000", "", "GRN", "3"));
            taxHelper.addTexConfiguration(new um_TaxVo(19, "foreign", "2018", "9", "15", "10000", "", "YEL", "3"));
            taxHelper.addTexConfiguration(new um_TaxVo(20, "electric", "2018", "9", "25", "23000", "", "ORA", "3"));
            taxHelper.addTexConfiguration(new um_TaxVo(21, "water", "2018", "8", "10", "31000", "", "RED", "3"));
            taxHelper.addTexConfiguration(new um_TaxVo(22, "gas", "2018", "8", "11", "28000", "", "GRN", "3"));
            taxHelper.addTexConfiguration(new um_TaxVo(23, "foreign", "2018", "8", "15", "12000", "", "YEL", "3"));
            taxHelper.addTexConfiguration(new um_TaxVo(24, "electric", "2018", "8", "25", "25000", "", "ORA", "3"));

            taxHelper.addTexConfiguration(new um_TaxVo(25, "water", "2018", "9", "10", "25000", "", "RED", "4"));
            taxHelper.addTexConfiguration(new um_TaxVo(26, "gas", "2018", "9", "11", "20000", "", "GRN", "4"));
            taxHelper.addTexConfiguration(new um_TaxVo(27, "foreign", "2018", "9", "24", "10000", "", "YEL", "4"));
            taxHelper.addTexConfiguration(new um_TaxVo(28, "electric", "2018", "9", "25", "23000", "", "ORA", "4"));
            taxHelper.addTexConfiguration(new um_TaxVo(29, "water", "2018", "8", "10", "31000", "", "RED", "4"));
            taxHelper.addTexConfiguration(new um_TaxVo(30, "gas", "2018", "8", "11", "28000", "", "GRN", "4"));
            taxHelper.addTexConfiguration(new um_TaxVo(31, "foreign", "2018", "8", "25", "12000", "", "YEL", "4"));
            taxHelper.addTexConfiguration(new um_TaxVo(32, "electric", "2018", "8", "25", "25000", "", "ORA", "4"));

            taxHelper.addTexConfiguration(new um_TaxVo(33, "water", "2018", "9", "10", "25000", "", "RED", "5"));
            taxHelper.addTexConfiguration(new um_TaxVo(34, "gas", "2018", "9", "11", "20000", "", "GRN", "5"));
            taxHelper.addTexConfiguration(new um_TaxVo(35, "foreign", "2018", "9", "30", "10000", "", "YEL", "5"));
            taxHelper.addTexConfiguration(new um_TaxVo(36, "electric", "2018", "9", "25", "23000", "", "ORA", "5"));
            taxHelper.addTexConfiguration(new um_TaxVo(37, "water", "2018", "8", "10", "31000", "", "RED", "5"));
            taxHelper.addTexConfiguration(new um_TaxVo(38, "gas", "2018", "8", "10", "28000", "", "GRN", "5"));
            taxHelper.addTexConfiguration(new um_TaxVo(39, "foreign", "2018", "8", "30", "12000", "", "YEL", "5"));
            taxHelper.addTexConfiguration(new um_TaxVo(40, "electric", "2018", "8", "25", "25000", "", "ORA", "5"));

            SharedPreferences.Editor editor1 = mPref.edit();
            editor1.putBoolean("DATA", true);
            editor1.commit();
        }


        calendar = new um_ScheduleCalendar(this);
        setContentView(calendar);
        calendar.refreshAdapter(0);
        Log.d(TAG, "db1");


        //  ******************* DB TEST ************************

        //     taxHelper = new MyTaxHelper(this);


//        SQLiteDatabase db = taxHelper.getWritableDatabase();
//        Log.d(TAG, "db2");
//
//        Cursor cursor = db.rawQuery("SELECT * FROM " + MyTaxHelper.TABLE_NAME, null);
//
//        while (cursor.moveToNext()){
//            long id = cursor.getInt(cursor.getColumnIndex(MyTaxHelper.COL_ID));
//
//            String type = cursor.getString(cursor.getColumnIndex(MyTaxHelper.COL_TYPE));
//            String name = cursor.getString(cursor.getColumnIndex(MyTaxHelper.COL_NAME));
//
//            myDataList.add(new ScheduleVo(type, name));
//        }
//        cursor.close();
        taxHelper.close();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:


                Intent intent_taxSel = new Intent(this, TaxSelectActivity.class);
                startActivityForResult(intent_taxSel, REQ_CODE);


                break;

            case R.id.btn_avg:

                Intent intent = new Intent(this, GetTaxActivity.class);
                startActivity(intent);

                break;

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    break;
                case RESULT_CANCELED:
                    break;
            }
        }
    }

    @Override
    protected void onResume() {
        calendar.refreshAdapter(0);
        super.onResume();
    }
}
