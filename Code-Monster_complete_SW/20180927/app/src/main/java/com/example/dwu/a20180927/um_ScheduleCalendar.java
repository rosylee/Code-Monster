package com.example.dwu.a20180927;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dwu.management.R;
import com.ssomai.android.scalablelayout.ScalableLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class um_ScheduleCalendar extends LinearLayout implements View.OnClickListener{


    private enum DayOfTheWeek {
        SUN, MON, TUE, WED, THU, FRI, SAT
    }
    private final String RED_COLOR = "#F42702";
    private final String ORA_COLOR = "#F67822";
    private final String YEL_COLOR = "#FDD34C";
    private final String GRN_COLOR = "#A8C42C";


    Calendar thisD = Calendar.getInstance();
    private final int thisYear = thisD.get(Calendar.YEAR);
    private final int thisMonth = thisD.get(Calendar.MONTH);



    private final int ORA_RGB = Color.rgb(244, 39, 2);
    private final int BLK_RGB = Color.rgb(111, 111, 111);
    private final int WHT_RGB = Color.rgb(255, 255, 255);


    final int REQ_CODE = 100;

    private Context context;
    private TextView currentDate;
    private GridView gridView;

    private ArrayList<DayVo> dayList;
    private Calendar calendar;
    private ScheduleCalendarAdapter adapter;
    private String today;
    private ArrayList<um_TaxVo> mArrayList  = null;

    MyTaxHelper helper;
    private MyTaxHelper mMyTaxHelper =null;
    private SharedPreferences mPref;



    ArrayList<ScheduleVo> myScheduleList = new ArrayList<ScheduleVo>();

    public um_ScheduleCalendar(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.um_activity_schedule_calendar, this, true);

        this.context = context;


        currentDate = (TextView) findViewById(R.id.sCal_dateTextView);
        calendar = Calendar.getInstance();
        gridView = (GridView) findViewById(R.id.sCal_calGrid);
        ImageView prevButton = (ImageView) findViewById(R.id.sCal_prevButton);
        ImageView nextButton = (ImageView) findViewById(R.id.sCal_nextButton);
        ImageView goToday = (ImageView) findViewById(R.id.btn_tday);
        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        goToday.setOnClickListener(this);

        mArrayList = new ArrayList<um_TaxVo>();

        mMyTaxHelper = new MyTaxHelper(context);
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH)+1;

        mPref = PreferenceManager.getDefaultSharedPreferences(context);
        String name = mPref.getString("NAME", "");
        int id = mPref.getInt("ID", 0);

        if(id == 0) {
            mArrayList.addAll(mMyTaxHelper.getAllConfigurations(String.valueOf(currentYear) , String.valueOf(currentMonth) , 6));
        }else {
            mArrayList.addAll(mMyTaxHelper.getAllConfigurations(String.valueOf(currentYear) , String.valueOf(currentMonth) , id));
            mArrayList.addAll(mMyTaxHelper.getAllConfigurations(String.valueOf(currentYear) , String.valueOf(currentMonth) , 6));
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append(currentYear);
        buffer.append(currentMonth);
        buffer.append(calendar.get(Calendar.DATE));
        today = buffer.toString();

        /* gridview 상단에 요일 표시 */
        ScalableLayout scalableLayout = new ScalableLayout(context, 70, 7);

        TextView sunTv = createGridViewTop(DayOfTheWeek.SUN.name());
        sunTv.setBackgroundColor(ORA_RGB);
        sunTv.setTextColor(Color.WHITE);
        scalableLayout.addView(sunTv, 0, 0, 10, 7);
        scalableLayout.setScale_TextSize(sunTv, 2);

        TextView monTv = createGridViewTop(DayOfTheWeek.MON.name());
        monTv.setBackgroundColor(ORA_RGB);
        monTv.setTextColor(Color.WHITE);
        scalableLayout.addView(monTv, 10, 0, 10, 7);
        scalableLayout.setScale_TextSize(monTv, 2);

        TextView tueTv = createGridViewTop(DayOfTheWeek.TUE.name());
        tueTv.setBackgroundColor(ORA_RGB);
        tueTv.setTextColor(Color.WHITE);
        scalableLayout.addView(tueTv, 20, 0, 10, 7);
        scalableLayout.setScale_TextSize(tueTv, 2);

        TextView webTv = createGridViewTop(DayOfTheWeek.WED.name());
        webTv.setBackgroundColor(ORA_RGB);
        webTv.setTextColor(Color.WHITE);
        scalableLayout.addView(webTv, 30, 0, 10, 7);
        scalableLayout.setScale_TextSize(webTv, 2);

        TextView thuTv = createGridViewTop(DayOfTheWeek.THU.name());
        thuTv.setBackgroundColor(ORA_RGB);
        thuTv.setTextColor(Color.WHITE);
        scalableLayout.addView(thuTv, 40, 0, 10, 7);
        scalableLayout.setScale_TextSize(thuTv, 2);

        TextView friTv = createGridViewTop(DayOfTheWeek.FRI.name());
        friTv.setBackgroundColor(ORA_RGB);
        friTv.setTextColor(Color.WHITE);
        scalableLayout.addView(friTv, 50, 0, 10, 7);
        scalableLayout.setScale_TextSize(friTv, 2);

        TextView satTv = createGridViewTop(DayOfTheWeek.SAT.name());
        satTv.setBackgroundColor(ORA_RGB);
        satTv.setTextColor(Color.WHITE);
        scalableLayout.addView(satTv, 60, 0, 10, 7);
        scalableLayout.setScale_TextSize(satTv, 2);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.gridViewContainer);
        linearLayout.addView(scalableLayout, 0);
    }

    private TextView createGridViewTop(String dayOfTheWeek) {
        TextView tv = new TextView(context);
        tv.setText(dayOfTheWeek);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setGravity(Gravity.CENTER);
        return tv;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sCal_prevButton :
                refreshAdapter(-1);
                break;
            case R.id.sCal_nextButton :
                refreshAdapter(1);
                break;
            case R.id.btn_tday:
                refreshAdapter(0);
                break;
        }
    }

    /**
     * setting adapter
     *
     * */
    public void refreshAdapter(int value) {
        mArrayList.clear();
        dayList = new ArrayList<DayVo>();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        calendar.add(Calendar.MONTH, value);

        if(value == 0){
            calendar.set(thisYear, thisMonth, 1);
        }
        /* 선택된 년월 첫주의 요일을 구한다. */
        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);

        /* 시작일 전은 공백으로 처리 */
        for (int i=1; i<dayNum; i++) {
            DayVo vo = new DayVo();
            vo.setDay("");
            dayList.add(vo);
        }

        for (int i = 0; i<calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            DayVo vo = new DayVo();
            vo.setDay(String.valueOf(i + 1));
            dayList.add(vo);
        }

        ArrayList<DayVo> scheduleList = getSchedule();

        for(DayVo schedule : scheduleList) {
            int sDay = Integer.parseInt(schedule.getDay());
            for(DayVo vo : dayList) {
                int day;
                try {
                    day = Integer.parseInt(vo.getDay());
                } catch (NumberFormatException e) {
                    continue;
                }
                if (sDay == day) {
                    vo.setScheduleList(new ArrayList<ScheduleVo>());
                    for(int i=0; i<schedule.getScheduleList().size(); i++) {
                        ScheduleVo sv = schedule.getScheduleList().get(i);
                        vo.getScheduleList().add(sv);
                    }
                }
            }
        }
        mPref = PreferenceManager.getDefaultSharedPreferences(context);
        int id = mPref.getInt("ID", 0);

        currentDate.setText(calendar.get(Calendar.YEAR) + "년 " + (calendar.get(Calendar.MONTH) + 1) + "월");
        if(id == 0) {
            mArrayList.addAll(mMyTaxHelper.getAllConfigurations(String.valueOf(calendar.get(Calendar.YEAR)) , String.valueOf(calendar.get(Calendar.MONTH) + 1) , 6));
        }else {
            mArrayList.addAll(mMyTaxHelper.getAllConfigurations(String.valueOf(calendar.get(Calendar.YEAR)) , String.valueOf(calendar.get(Calendar.MONTH) + 1) , id));
            mArrayList.addAll(mMyTaxHelper.getAllConfigurations(String.valueOf(calendar.get(Calendar.YEAR)) , String.valueOf(calendar.get(Calendar.MONTH) + 1) , 6));
        }
        adapter = new ScheduleCalendarAdapter();
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * get Schedule form server
     *
     * */
    private ArrayList<DayVo> getSchedule() {
        ArrayList<DayVo> list = new ArrayList<>();
        /* 이 부분에서 스케줄을 읽어 옵니다. */

//        ArrayList<ScheduleVo> scheduleList = new ArrayList<ScheduleVo>();
//        ScheduleVo scheduleVo;
//        String tDay ="0";
//        DayVo dayVo = new DayVo();

        helper = new MyTaxHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        String tYear = Integer.toString(calendar.get(Calendar.YEAR));
        String tMonth = Integer.toString(calendar.get(Calendar.MONTH) + 1);
        String where = "month='"+tMonth+"' and year='"+tYear+"';";


        Cursor cursor = db.rawQuery("SELECT * FROM " + MyTaxHelper.TABLE_NAME + " WHERE "+where, null);


        while(cursor.moveToNext()){
            long id = cursor.getInt(cursor.getColumnIndex(MyTaxHelper.COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(MyTaxHelper.COL_NAME));
            String day = cursor.getString(cursor.getColumnIndex(MyTaxHelper.COL_DAY));
            String tax = cursor.getString(cursor.getColumnIndex(MyTaxHelper.COL_TAX));
            String memo = cursor.getString(cursor.getColumnIndex(MyTaxHelper.COL_MEMO));
            String type = cursor.getString(cursor.getColumnIndex(MyTaxHelper.COL_TYPE));

            myScheduleList.add(new ScheduleVo(id, name, day, tax, memo, type));

//            scheduleVo = new ScheduleVo(id, name, date, tax, memo, type);
//            scheduleList.add(scheduleVo);
//
//            String isDay = scheduleVo.getDate().split("-")[2];
//
//            if(tDay.equals(isDay)){
//                scheduleList.add(scheduleVo);
//            }else{
//                tDay = isDay;
//                scheduleList.clear();
//                scheduleList.add(scheduleVo);
//            }
//
//
//            dayVo.setDay(isDay);
//            dayVo.setScheduleList(scheduleList);
//            list.add(dayVo);
//

        }

        String putDay="";
        for(ScheduleVo schedule : myScheduleList){
            putDay = schedule.getDate();
            ArrayList<ScheduleVo> putScheculeList = new ArrayList<ScheduleVo>();
            putScheculeList.add(schedule);

            DayVo inputDay = new DayVo();
            inputDay.setDay(putDay);
            inputDay.setScheduleList(putScheculeList);

            list.add(inputDay);
        }

        return list;
    }

    public class ScheduleCalendarAdapter extends BaseAdapter implements OnClickListener {

        private LayoutInflater inflater;
        private class ViewHolder {
            public TextView day;
            public LinearLayout color_linear;
            public TextView name_text;
            public TextView tax_text;
            public TextView total_text;
            public LinearLayout empty_layout;

        }

        public ScheduleCalendarAdapter() {
            inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return dayList.size();
        }

        @Override
        public Object getItem(int i) {
            return dayList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            final ViewHolder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.um_empty_layout, viewGroup, false);

                holder = new ViewHolder();
                holder.day = (TextView) convertView.findViewById(R.id.day);
                holder.color_linear = (LinearLayout) convertView.findViewById(R.id.color_linear);
                holder.name_text = (TextView) convertView.findViewById(R.id.name_text);
                holder.tax_text = (TextView) convertView.findViewById(R.id.tax_text);
                holder.total_text = (TextView) convertView.findViewById(R.id.total_text);
                holder.empty_layout = (LinearLayout) convertView.findViewById(R.id.empty_layout);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder)convertView.getTag();
            }

            DayVo vo = dayList.get(position);

            holder.day.setText(vo.getDay());
            if(vo.getDay().equals("")) {
                convertView.setClickable(false);
            }
            /* setting text color of weekend */
            if (position % 7 == DayOfTheWeek.SAT.ordinal()) {
                holder.day.setTextColor(Color.parseColor("#2E64FE"));
            } else if (position % 7 == DayOfTheWeek.SUN.ordinal()) {
                holder.day.setTextColor(Color.RED);
            }


            /* setting schedule list of day */
//            if(vo.getScheduleList() != null) {
//                LinearLayout linearLayout = (LinearLayout) convertView;
//                ScalableLayout scalableLayout = (ScalableLayout) linearLayout.getChildAt(0);
//                int scheduleCnt = vo.getScheduleList().size();
//                for(int i=0; i<scheduleCnt; i++) {
//                    ScheduleVo sv = vo.getScheduleList().get(i);
//                    TextView scheduleTv = new TextView(convertView.getContext());
//                    scheduleTv.setGravity(Gravity.CENTER_VERTICAL);
//                    if(i == 2) {
//                        scalableLayout.addView(scheduleTv, 0, 70, 80, 25);
//                        scalableLayout.setScale_TextSize(scheduleTv, 15);
//                        scheduleTv.setText("TOTAL : " + String.valueOf(scheduleCnt));
//                        break;
//                    }
//                    scheduleTv.setTextColor(Color.WHITE);
//                    scheduleTv.setSingleLine();
//                    scalableLayout.addView(scheduleTv, 0, 25+(i*25), 80, 25);
//                    scalableLayout.setScale_TextSize(scheduleTv, 15);
//                    if(sv.getType().equals("RED")) {
//                        scheduleTv.setBackgroundColor(Color.parseColor(RED_COLOR));
//                    } else if(sv.getType().equals("ORE")) {
//                        scheduleTv.setBackgroundColor(Color.parseColor(ORA_COLOR));
//                    }else if (sv.getType().equals("YEL")){
//                        scheduleTv.setBackgroundColor(Color.parseColor(YEL_COLOR));
//                    }else if (sv.getType().equals("GRN")){
//                        scheduleTv.setBackgroundColor(Color.parseColor(GRN_COLOR));
//                    }
//                    scheduleTv.setText(sv.getName());
//                }
//            }
            int totalCount = 0;
            for(int i=0 ; i<mArrayList.size(); i++) {
                if(mArrayList.get(i).getCOL_DAY().equals(vo.getDay())) {
                    if(mArrayList.get(i).getCOL_TYPE().equals("RED")) {
                        holder.color_linear.setBackgroundColor(Color.parseColor(RED_COLOR));
                    } else if(mArrayList.get(i).getCOL_TYPE().equals("ORA")) {
                        holder.color_linear.setBackgroundColor(Color.parseColor(ORA_COLOR));
                    }else if (mArrayList.get(i).getCOL_TYPE().equals("YEL")){
                        holder.color_linear.setBackgroundColor(Color.parseColor(YEL_COLOR));
                    }else if (mArrayList.get(i).getCOL_TYPE().equals("GRN")){
                        holder.color_linear.setBackgroundColor(Color.parseColor(GRN_COLOR));
                    }

                    //holder.name_text.setText(mArrayList.get(i).getCOL_NAME());
                    holder.tax_text.setText(mArrayList.get(i).getCOL_TAX());
                    totalCount++;
                }
            }
            //2개 부분일때 표시
            if(totalCount > 1) {
                holder.total_text.setVisibility(VISIBLE);
                holder.total_text.setText("total:"+totalCount);
            }else {
                holder.total_text.setVisibility(GONE);
            }


            if(today.equals(calendar.get(Calendar.YEAR)+""+(calendar.get(Calendar.MONTH) + 1)+""+vo.getDay())) {
                holder.day.setText("★"+vo.getDay()+"★");
            }
            holder.empty_layout.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(holder.name_text.getText().toString().length() > 0) {

                        String message = holder.name_text.getText().toString() + ":"+ holder.tax_text.getText().toString()+ " "+holder.total_text.getText().toString();
                        Toast.makeText(getContext() , message , Toast.LENGTH_SHORT).show();


                        String str = "";

                        for(int i=0 ; i<mArrayList.size(); i++){
                            str += mArrayList.get(i).getCOL_NAME().toString() +" : "+ mArrayList.get(i).getCOL_TAX().toString()+" won \n";
                        }


                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                         builder.setTitle(holder.day.getText().toString())
                                 .setMessage(str)

                                 .setPositiveButton("닫기", null);
//                         builder.setNegativeButton("추가", new DialogInterface.OnClickListener() {
//                             @Override
//                             public void onClick(DialogInterface dialog, int which) {
//                                 Intent intent_taxSel = new Intent(context, TaxSelectActivity.class);
//                                 startActivityForResult(intent_taxSel, REQ_CODE);
//
//                             }
//                         });
                         builder.show();

                    } else {
                        Toast.makeText(getContext() , "저장된 내용이 없습니다." , Toast.LENGTH_SHORT).show();
                    }
                }
            });
            return convertView;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();
        }
    }
}

