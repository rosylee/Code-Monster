package com.example.dwu.a20180927;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AppDBHelper extends SQLiteOpenHelper {
    final static String TAG = "AppDBHelper";

    final static String DB_NAME = "app.db";
    public final static String TABLE_NAME = "app_table";

    public final static String COL_ID = "_id";
    public final static String COL_BANK = "bank";
    public final static String COL_TITLE = "title";
    public final static String COL_INFO = "info";
    public final static String COL_TYPE = "type";
    public final static String COL_USER = "user";
    public final static String COL_AMOUNT = "amount";
    public final static String COL_RATE = "rate";
    public final static String COL_TERM = "term";

    public AppDBHelper(Context context) {
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
        db.execSQL("insert into " + TABLE_NAME + " values (null, '신한','신한 알파 레이디 적금','여성 고객을 타켓으로 차별화된 컨셉의 우대 이자율 적용하는 상품','적립식 / 자유적립식','개인','1천원~50만원',2.0,'6~36개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '신한','신한 두배드림 적금','1/3/5백만원 만들기 도전! 이자두배','적립식 / 자유적립식','개인','4만1천원~20만4천원',2.6,'24개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '신한','신한 위드펫 적금','갑작스런 PET 의료비 지출시 특별 중도해지 제공','적립식 / 자유적립식','개인','1천원~30만원',2.0,'12개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '국민','KB 국민 행복적금','주택구입, 입원 등의 사유 발생시 특별중도해지 서비스를 제공하고 만기해지시우대금리를 제공하는 적립식 상품으로 기초생활수급자(소년소녀가장 포함), 북한이탈주민, 결혼이민여성, 근로장려금수급자, 한부모가족지원 보호대상자, 만65세 이상 차상위계층','자유적립식 / 정액적립식','결혼이주여성','',4.5,'12개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '국민','직장인 우대적금','직장인의 재테크 스타일을 반영한 적립식 예금','정기적금','개인','1만원~3백만원',2.6,'12/24/36개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '국민','KB 주니어 라이프 적금','자녀를 위한 장기 목돈마련저축으로 유소년 전용 적금','정기적금','만 18세미만 개인','10만원~500만원',2.5,'12개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '국민','KB 국민 첫재테크 적금','20~30대 직장 초년생들의 첫 목돈마련을 지원하는 월복리 정금','자유적립식','만 18세~만38세 이하 개인','',2.7,'36개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '우리','위비 짠테크 적금','짠돌이 재테커들에게 딱 맞는 위비뱅크전용 적금상품','정기적금','개인','월 최대 50만원',2.75,'12/24/36개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '우리','우리 아이 행복 적금','우리 아이에게 첫통장을 만들어주는 어린이 적금','적립식','개인','월 최대 100만원',1.8,'12/24/36/48/60개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '우리','위비 프렌즈 정기 적금','청소년의 학자금 및 목돈마련을 위한 상품','정기적금','만 18세이하의 개인','월 최대 30만원',2.5,'12/24/36개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '하나','꿈 하나 적금','보물단지 우리아이를 위한 적금','적립식 / 자유적립식','만 18세이하의 개인','1천원~150만원',2.3,'12개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '하나','오늘은 얼마니?적금','매일매일 저축하는 일일 재테크 적금','정기적금','개인','5만원~20만원',2.4,'12/24개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '하나','하나머니 세상 적금','예금이자의 세금만큼 하나머니로 돌려주는 적립식 상품','적립식 / 자유적립식','만 14세이상의 개인 / 개인사업자','1만원~20만원',3.5,'6~12개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '농협','NH20해봄 적금','고객이 직접 상품명을 만드는 적립식 상품','적립식 / 자유적립식','만 19세~만40세 개인','1천원~50만원',2.5,'12~36개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '농협','NH직장인 월복리 적금','직장인 재테크 월복리 적금상품','적립식 / 자유적립식','만 18세이상 개인','1만원~1백만원',2.67,'12~36개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '농협','NH더좋은 맘 적금','임신, 출산, 다자녀 대상으로 우대금리를 제공하는 임산부/예비 임산부를 위한 적금','적립식 / 자유적립식','개인','1천원~3백만원',2.4,'12/24/36/48/60개월');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
