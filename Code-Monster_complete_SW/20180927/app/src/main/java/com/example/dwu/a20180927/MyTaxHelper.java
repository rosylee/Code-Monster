package com.example.dwu.a20180927;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyTaxHelper extends SQLiteOpenHelper {

    // Database Version
    //DB초기화시 이부분을 1,2,3 올려주시면되요
    private static final int DATABASE_VERSION = 1;

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
    public final static String COL_PO_ID = "p_id";

    //member

    public final static String TABLE_MEMBER_NAME = "tax_member";
    public final static String COL_P_ID = "p_id";
    public final static String COL_MEBER_NAME = "p_name";
    public final static String COL_BIRHDAY = "birthday";
    public final static String COL_PHONE = "phone";
    public final static String COL_CUSTOMER_NUM = "customer_num";
    public final static String COL_HOMEPAGE_NUM = "homepage_num";

    // ==================================================================
//    public final static String TABLE_NAME2 = "persol_table";
//    public final static String COL_ID2 = "_id";
//    public final static String COL_test1 = "name";
    //===================================================================

    public MyTaxHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " Integer primary key autoincrement, "
                + COL_NAME + " TEXT, " + COL_YEAR + " TEXT, " + COL_MONTH + " TEXT, " + COL_DAY + " TEXT, "
                + COL_TAX + " TEXT, " + COL_MEMO + " TEXT, " +COL_TYPE + " TEXT, " + COL_PO_ID + " TEXT)";

        String sql_MEMBER = "CREATE TABLE " + TABLE_MEMBER_NAME + "(" + COL_P_ID + " INTEGER PRIMARY KEY," + COL_MEBER_NAME + " VARCHAR, " + COL_BIRHDAY + " VARCHAR, " + COL_PHONE + " VARCHAR, " + COL_CUSTOMER_NUM + " VARCHAR, " + COL_HOMEPAGE_NUM + " VARCHAR)";

        db.execSQL(sql);
        db.execSQL(sql_MEMBER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER_NAME);
        onCreate(db);
    }

    // 모든 Contact 정보 가져오기
    public ArrayList<um_TaxVo> getAllConfigurations() {
        ArrayList<um_TaxVo> contactList = new ArrayList<um_TaxVo>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                um_TaxVo contact = new um_TaxVo();
                contact.setCOL_ID(Integer.parseInt(cursor.getString(0)));
                contact.setCOL_NAME(cursor.getString(1));
                contact.setCOL_YEAR(cursor.getString(2));
                contact.setCOL_MONTH(cursor.getString(3));
                contact.setCOL_DAY(cursor.getString(4));
                contact.setCOL_TAX(cursor.getString(5));
                contact.setCOL_MEMO(cursor.getString(6));
                contact.setCOL_TYPE(cursor.getString(7));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        if (db != null) {
            db.close();
        }
        // return contact list
        return contactList;
    }

    // 모든 Contact 정보 가져오기
    public ArrayList<um_TaxVo> getAllConfigurations(int id) {
        ArrayList<um_TaxVo> contactList = new ArrayList<um_TaxVo>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME +" WHERE " + COL_PO_ID + "="+id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                um_TaxVo contact = new um_TaxVo();
                contact.setCOL_ID(Integer.parseInt(cursor.getString(0)));
                contact.setCOL_NAME(cursor.getString(1));
                contact.setCOL_YEAR(cursor.getString(2));
                contact.setCOL_MONTH(cursor.getString(3));
                contact.setCOL_DAY(cursor.getString(4));
                contact.setCOL_TAX(cursor.getString(5));
                contact.setCOL_MEMO(cursor.getString(6));
                contact.setCOL_TYPE(cursor.getString(7));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        if (db != null) {
            db.close();
        }
        // return contact list
        return contactList;
    }

    // 모든 Contact 정보 가져오기
    public ArrayList<um_MemberVo> getMemberConfigurations() {
        ArrayList<um_MemberVo> contactList = new ArrayList<um_MemberVo>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_MEMBER_NAME ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                um_MemberVo contact = new um_MemberVo();

                contact.setP_id(Integer.parseInt(cursor.getString(0)));
                contact.setP_name(cursor.getString(1));
                contact.setBirthday(cursor.getString(2));
                contact.setPhone(cursor.getString(3));
                contact.setCustomer_num(cursor.getString(4));
                contact.setHomepage_num(cursor.getString(5));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        if (db != null) {
            db.close();
        }
        // return contact list
        return contactList;
    }

    // 모든 Contact 정보 가져오기
    public ArrayList<um_TaxVo> getAllConfigurations(String year , String month , int id) {
        ArrayList<um_TaxVo> contactList = new ArrayList<um_TaxVo>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME +" WHERE " + COL_YEAR+"="+year +" and " + COL_MONTH + "="+month + " and " + COL_PO_ID + "="+id ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                um_TaxVo contact = new um_TaxVo();
                contact.setCOL_ID(Integer.parseInt(cursor.getString(0)));
                contact.setCOL_NAME(cursor.getString(1));
                contact.setCOL_YEAR(cursor.getString(2));
                contact.setCOL_MONTH(cursor.getString(3));
                contact.setCOL_DAY(cursor.getString(4));
                contact.setCOL_TAX(cursor.getString(5));
                contact.setCOL_MEMO(cursor.getString(6));
                contact.setCOL_TYPE(cursor.getString(7));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        if (db != null) {
            db.close();
        }
        // return contact list
        return contactList;
    }

    // 새로운 Contact 함수 추가
    public void
    addMemberConfiguration(um_MemberVo umMemberVo) {
        SQLiteDatabase db = this.getReadableDatabase();
        addMemberConfiguration(db, umMemberVo);
        db.close(); // Closing database connection
    }

    // 새로운 Contact 함수 추가
    public void addMemberConfiguration(SQLiteDatabase db, um_MemberVo umMemberVo) {

        ContentValues values = new ContentValues();
        values.put(COL_MEBER_NAME, umMemberVo.getP_name());
        values.put(COL_BIRHDAY, umMemberVo.getBirthday());
        values.put(COL_PHONE, umMemberVo.getPhone());
        values.put(COL_CUSTOMER_NUM, umMemberVo.getCustomer_num());
        values.put(COL_HOMEPAGE_NUM, umMemberVo.getHomepage_num());

        db.insert(TABLE_MEMBER_NAME, null, values);
    }

    // 새로운 Contact 함수 추가
    public void addTexConfiguration(um_TaxVo umTaxVo) {
        SQLiteDatabase db = this.getReadableDatabase();
        addTexConfiguration(db, umTaxVo);
        db.close(); // Closing database connection
    }

    // 새로운 Contact 함수 추가
    public void addTexConfiguration(SQLiteDatabase db, um_TaxVo umTaxVo) {


        ContentValues values = new ContentValues();
        values.put(COL_NAME, umTaxVo.getCOL_NAME());
        values.put(COL_YEAR, umTaxVo.getCOL_YEAR());
        values.put(COL_MONTH, umTaxVo.getCOL_MONTH());
        values.put(COL_DAY, umTaxVo.getCOL_DAY());
        values.put(COL_TAX, umTaxVo.getCOL_TAX());
        values.put(COL_MEMO, umTaxVo.getCOL_MEMO());
        values.put(COL_TYPE, umTaxVo.getCOL_TYPE());
        values.put(COL_PO_ID, umTaxVo.getCOL_PO_ID());

        db.insert(TABLE_NAME, null, values);
    }
}
