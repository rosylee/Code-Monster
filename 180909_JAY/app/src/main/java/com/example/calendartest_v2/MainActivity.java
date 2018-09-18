package com.example.calendartest_v2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity_log";
    final int REQ_CODE = 100;

    MyTaxHelper taxHelper;
    private ArrayList<ScheduleVo> myDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScheduleCalendar calendar = new ScheduleCalendar(this);
        setContentView(calendar);
        calendar.refreshAdapter(0);
        Log.d(TAG, "db1");


        //  ******************* DB TEST ************************

//        taxHelper = new MyTaxHelper(this);

//        SQLiteDatabase db = taxHelper.getReadableDatabase();
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
 //       taxHelper.close();
    }

    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.btn_add:

                Intent intent_taxSel = new Intent(this, TaxSelectActivity.class);
                startActivityForResult(intent_taxSel, REQ_CODE);


                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQ_CODE){
            switch (resultCode){
                case RESULT_OK:
                    break;
                case RESULT_CANCELED:
                    break;
            }
        }
    }


}
