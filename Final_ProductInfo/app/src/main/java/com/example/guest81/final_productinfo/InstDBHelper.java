package com.example.guest81.final_productinfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class InstDBHelper extends SQLiteOpenHelper {
    final static  String TAG = "InstDBHelper";

    final static String DB_NAME = "inst.db";
    public final static String TABLE_NAME = "inst_table";

    public final static String COL_ID = "_id";
    public final static String COL_BANK = "bank";
    public final static String COL_TITLE = "title";
    public final static String COL_INFO = "info";
    public final static String COL_TYPE = "type";
    public final static String COL_USER = "user";
    public final static String COL_AMOUNT = "amount";
    public final static String COL_RATE = "rate";
    public final static String COL_TERM = "term";

    public InstDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_BANK + " TEXT, " + COL_TITLE + " TEXT, " + COL_INFO + " TEXT, " + COL_TYPE + " TEXT, " +
                COL_USER + " TEXT, " + COL_AMOUNT + " TEXT, " + COL_RATE + " REAL, " + COL_TERM + " TEXT)";
        Log.d(TAG, sql);
        db.execSQL(sql);

        //샘플 데이터
        db.execSQL("insert into " + TABLE_NAME + " values (null, '신한','마이홈플랜 주택청약 종합저축','청약저축의 성격을 기본으로한 만능 청약통장','주택청약저축','개인','2만원~1,500만원',1.8,'840개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '국민','주택청약 종합저축','국민 주택 및 민영주택에 모두 청약 할 수 있는 입주자 저축','주택청약저축','개인','2만원~1,500만원',1.8,'');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '우리','위비 주택청약 종합저축','주택마련의 시작! 주택청약 종합상품','주택청약저축','개인','2만원~50만원',1.8,'~입주자로 선정 시');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '우리','우리아이행복 주택청약 종합저축','우리아이 주택청약 통장','주택청약저축','개인','2만원~50만원',1.8,'~입주자로 선정 시');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '우리','주택청약 종합저축','주택마련의 시작! 주택청약 종합상품','주택청약저축','개인','2만원~50만원',1.8,'~입주자로 선정 시');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '하나','주택청약 종합저축','내집 마련의 꿈을 KEB하나은행이 더블 금리로 응원합니다.','주택청약저축','개인','2만원~20만원',1.8,'12/24개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '농협','주택청약 종합저축','내집마련의 필수! 종합통장 성격의 입주자 저축','주택청약저축','개인','2만원~50만원',1.8,'~입주자로 선정 시');");
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}