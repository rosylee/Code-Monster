package com.example.calendartest_v2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyTaxHelper extends SQLiteOpenHelper {

    final static String TAG = "MyTaxHelper";
    final static String DB_NAME = "tax.db";

    public final static String TABLE_NAME = "tax_table";
    public final static String COL_ID = "_id";
    public final static String COL_NAME = "name";
    public final static String COL_YEAR = "year";
    public final static String COL_MONTH = "month";
    public final static String COL_DAY = "day";
    public final static String COL_TAX = "tax";
    public final static String COL_MEMO = "memo";
    public final static String COL_TYPE = "type";

    public MyTaxHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " Integer primary key autoincrement, "
                + COL_NAME + " TEXT, " + COL_YEAR + " TEXT, " + COL_MONTH + " TEXT, " + COL_DAY + " TEXT, "
                + COL_TAX + " TEXT, " + COL_MEMO + " TEXT, " + COL_TYPE + " TEXT)";
        Log.d(TAG, sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
