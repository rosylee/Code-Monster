package com.example.guest81.final_productinfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DepoDBHelper extends SQLiteOpenHelper {
    final static  String TAG = "DepoDBHelper";

    final static String DB_NAME = "depo.db";
    public final static String TABLE_NAME = "depo_table";

    public final static String COL_ID = "_id";
    public final static String COL_BANK = "bank";
    public final static String COL_TITLE = "title";
    public final static String COL_INFO = "info";
    public final static String COL_TYPE = "type";
    public final static String COL_USER = "user";
    public final static String COL_AMOUNT = "amount";
    public final static String COL_RATE = "rate";
    public final static String COL_TERM = "term";

    public DepoDBHelper(Context context) {
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
        db.execSQL("insert into " + TABLE_NAME + " values (null, '신한','신한 플러스 월복리 정기예금','세제지원 상품과 연계된 실적으로 우대 이자율을 지급하는 거치식 상품','정기예금','개인','3백만원~3천만원',2.1,'12/24/36개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '신한','쏠편한 정기예금','자금관리가 여유로운 맞춤상품','정기예금','개인 / 단체','1만원~',2.05,'12/24/36개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '신한','미래설계 크레바스 연금예금','5년 이내의 단기연금예금으로 고정금리 적용에 따라 수령금액을 예상할 수 있어 보다 쉽게 은퇴 설계가능한 상품','정기예금','개인 / 단체','3백만원~',1.70,'12/24/36/48/60개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '국민','국민수퍼정기예금','목돈을 일정기간동안 예치하여 안정적인 수익을 목적으로 하는 다기능 맞춤식 정기예금','정기예금','개인','1백만원~',1.6,'12~36개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '국민','KB주니어 라이프 증여예금','손,자녀에게 증여 needs가 있는 고객을 위한 정기예금','정기예금','개인','3백만원~',1.6,'12/24/36/48/60/72/84/96/108/120개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '국민','e-파워 정기예금','온라인 전용 대표 정기예금','정기예금','개인','1백만원~',1.5,'1~12개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '우리','위비 꿀마켓 예금','위비톡, 위비멤버스 회원이라면 누구나 금리혜택을 받는 정기예금','정기예금','개인','1백만원~5천만원',2.1,'12개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '우리','iTouch 우리예금','가입금액 관계 없이 공동구매로 고금리 혜택을 Touch!','정기예금','개인','',2.2,'3/6/12개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '우리','위비 Super 주거래 예금2','주거래고객이면 우대금리Go~ 高금리!','정기예금','개인 / 사업자','1백만원~',2.1,'6~12개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '하나','리틀빅 정기예금','오늘도 열심히 살아가는 이 시대의 작은 영웅 당신을 응원합니다! 작은 금액도 소중하게 정성껏 키워 드립니다.','정기예금','개인 /  사업자','1백만원~5백만원',2.3,'12개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '하나','e-플러스 정기예금','적은 금액이라도 높은금리 혜택을 마음껏 누리세요','정기예금','개인','',2.0,'1~36개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '하나','하나머니세상 정기예금','하나멤버스 회원에게 예금이자의 세금만큼 하나머니로 돌려드리는 정기예금 상품입니다.','정기예금','개인 / 사업자','1백만원~1천만원',2.6,'6/12개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '농협','e금리우대 예금','영업점 창구에서 가입 시 보다 높은 금리가 제공되는 인터넷 및 스마트 뱅킹 전용 예금 상품','정기예금','개인','3백만원~3억원',2.1,'12개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '농협','NH 왈츠 회전예금II','실세금리를 적용하는 개인전용 회전예금으로, 월단위로 회전주기를 선택할 수 있는 예금상품','정기예금','개인','3백만원~',2.04,'12/24/36개월');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '농협','NH All100 플랜 연금예금','은퇴자금 운영을 위한 연금예금 상품','정기예금','개인','',1.95,'5년~10년');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

