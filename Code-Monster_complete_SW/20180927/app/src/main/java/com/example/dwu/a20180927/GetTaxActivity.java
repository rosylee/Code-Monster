package com.example.dwu.a20180927;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dwu.management.R;

import java.util.ArrayList;

/**
 * Created by testa on 2018-09-24.
 */

public class GetTaxActivity extends AppCompatActivity implements View.OnClickListener{

    final static String TAG = "GetTaxActivity";


    private LinearLayout mListLinear = null;
    private LinearLayout mNotLinear = null;
    private LinearLayout mInsertLinear = null;
    private ImageView mInsertBtn = null;
    private Button mPoliyBtn = null;
    private EditText mNameEdit = null;
    private DatePicker mBirthEdit = null;
    private EditText mPhoneEdit = null;
    private EditText mTaxEdit = null;
    private EditText mHomeEdit = null;
    private TextView mNotText = null;
    private ListView mListView = null;
    private ListAdapter mAdapter 		= null;

    private MyTaxHelper mMyTaxHelper  = null;
    private ArrayList<um_TaxVo> mArrayList = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.um_activity_all_tax);

        mMyTaxHelper = new MyTaxHelper(this);
        mInsertLinear = (LinearLayout) findViewById(R.id.insert_linear);
        mListLinear = (LinearLayout) findViewById(R.id.list_linear);
        mNotLinear = (LinearLayout) findViewById(R.id.not_linear);
        mInsertBtn = (ImageView) findViewById(R.id.insert_btn);
        mPoliyBtn = (Button) findViewById(R.id.poliy_btn);
        mNameEdit = (EditText) findViewById(R.id.name_edit);
        mBirthEdit = (DatePicker) findViewById(R.id.birth_edit);
        mPhoneEdit = (EditText) findViewById(R.id.phone_edit);
        mTaxEdit = (EditText) findViewById(R.id.tax_edit);
        mHomeEdit = (EditText) findViewById(R.id.home_edit);
        mListView = (ListView) findViewById(R.id.list_view);
        mNotText = (TextView) findViewById(R.id.not_text);


        SharedPreferences mPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String name = mPref.getString("NAME", "");
        int id = mPref.getInt("ID", 0);

        if(name != null && !name.equals("")) {
            mNotLinear.setVisibility(View.GONE);
            mListLinear.setVisibility(View.VISIBLE);

            if(mArrayList == null)
                mArrayList = new ArrayList<um_TaxVo>();

            mArrayList.addAll(mMyTaxHelper.getAllConfigurations(id));
            mArrayList.addAll(mMyTaxHelper.getAllConfigurations(6));

            if (mAdapter == null)
                mAdapter = new ListAdapter(this, R.layout.um_item_tax, mArrayList);

            mListView.setAdapter(mAdapter);

            if(mArrayList.size() > 0) {
                mListView.setVisibility(View.VISIBLE);
                mNotText.setVisibility(View.GONE);
            } else {
                mListView.setVisibility(View.GONE);
                mNotText.setVisibility(View.VISIBLE);
            }

        } else {
            mNotLinear.setVisibility(View.VISIBLE);
            mListLinear.setVisibility(View.GONE);
        }
        mPoliyBtn.setOnClickListener(this);
        mInsertBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert_btn:
                if(mNameEdit.getText().toString().length() <=0) {
                    Toast.makeText(this , "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(mPhoneEdit.getText().toString().length() <=0) {
                    Toast.makeText(this , "휴대폰번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(mTaxEdit.getText().toString().length() <=0) {
                    Toast.makeText(this , "납입자번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mHomeEdit.getText().toString().length() <=0) {
                    Toast.makeText(this , "홈페이지가입번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                um_MemberVo umMemberVo = new um_MemberVo();
                umMemberVo.setP_name(mNameEdit.getText().toString());

                String birth = String.valueOf(mBirthEdit.getYear())+"-";

                int b_mon = mBirthEdit.getMonth()+1;
                int b_day = mBirthEdit.getDayOfMonth();

                if( b_mon < 10){
                    birth += "0" + String.valueOf(b_mon) + "-";
                }else{
                    birth += String.valueOf(b_mon) + "-";
                }

                if( b_day < 10){
                    birth += "0" + String.valueOf(b_day);
                }else {
                    birth += String.valueOf(b_day);
                }

                Log.d(TAG, birth);

                umMemberVo.setBirthday(birth);
                umMemberVo.setPhone(mPhoneEdit.getText().toString());
                umMemberVo.setCustomer_num(mTaxEdit.getText().toString());
                umMemberVo.setHomepage_num(mHomeEdit.getText().toString());

                ArrayList<um_MemberVo> member = mMyTaxHelper.getMemberConfigurations();

                boolean result = false;
                int getNum = 0;
                for(int i=0; i<member.size(); i++) {
                    if(member.get(i).getP_name().equals(umMemberVo.getP_name()) &&
                            member.get(i).getBirthday().equals(umMemberVo.getBirthday())&&
                            member.get(i).getPhone().equals(umMemberVo.getPhone()) &&
                            member.get(i).getCustomer_num().equals(umMemberVo.getCustomer_num()) &&
                            member.get(i).getHomepage_num().equals(umMemberVo.getHomepage_num())) {

                        result = true;
                        getNum = member.get(i).getP_id();
                        break;
                    }else {
                        result = false;
                    }

                }

                if(result) {
                    Toast.makeText(this , "인증이 완료되었습니다." , Toast.LENGTH_SHORT).show();

                    SharedPreferences mPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor1 = mPref.edit();
                    editor1.putString("NAME", mNameEdit.getText().toString());
                    editor1.putInt("ID", getNum);
                    editor1.commit();

                    finish();
                }else {
                    Toast.makeText(this , "인증이 실패되었습니다." , Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.poliy_btn:
                mInsertLinear.setVisibility(View.VISIBLE);
                mPoliyBtn.setVisibility(View.GONE);
                break;
        }
    }

    public class ListAdapter extends BaseAdapter {

        private LayoutInflater mInflater = null;
        private ArrayList<um_TaxVo> mArrayList;
        private int mItemListDb = 0;
        private Context mContext = null;

        public ListAdapter(Context context, int layout, ArrayList<um_TaxVo> arrayList) {
            super();

            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mArrayList = arrayList;
            mItemListDb = layout;
            mContext = context;
        }

        @Override
        public int getCount() {
            return mArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return mArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(mItemListDb, null);

                ListAdapter.ViewHolder holder = new ListAdapter.ViewHolder();

                if (convertView != null) {
                    holder.num_text = (ImageView) convertView.findViewById(R.id.num_text);
                    holder.comment_text = (TextView) convertView.findViewById(R.id.comment_text);
                    holder.tax_text = (TextView) convertView.findViewById(R.id.tax_text);
                    holder.date_text = (TextView) convertView.findViewById(R.id.date_text);
                    holder.list_item = (LinearLayout) convertView.findViewById(R.id.list_item);
                }

                if (convertView != null)
                    convertView.setTag(holder);

            }

            ListAdapter.ViewHolder holder = null;

            if (convertView != null)
                holder = (ListAdapter.ViewHolder) convertView.getTag();

            final um_TaxVo taxvo = mArrayList.get(position);

            if (taxvo != null) {

                String name = taxvo.getCOL_NAME();

                if(name.equals("foreign")){
                    holder.num_text.setImageResource(R.drawable.foreign);
                    holder.comment_text.setText("외국인 소득세");

                }else if(name.equals("water")){
                    holder.num_text.setImageResource(R.drawable.water);
                    holder.comment_text.setText("수도 요금");
                }else if(name.equals("gas")){
                    holder.num_text.setImageResource(R.drawable.gas);
                    holder.comment_text.setText("도시가스");
                }else if(name.equals("electric")){
                    holder.num_text.setImageResource(R.drawable.ele);
                    holder.comment_text.setText("전기요금");
                }


                holder.tax_text.setText(taxvo.getCOL_TAX()+ " 원");
                holder.date_text.setText(taxvo.getCOL_YEAR() + "-"+taxvo.getCOL_MONTH() + "-"+ taxvo.getCOL_DAY());

            }
            //여기서 클릭이벤트
            holder.list_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String msg = String.valueOf(taxvo.getCOL_NAME());

                    AlertDialog.Builder builder = new AlertDialog.Builder(GetTaxActivity.this);
                    builder.setTitle("고지서 삭제")
                            .setMessage(msg + " 항목을 삭제하시겠습니까?");
                    builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SQLiteDatabase db_d = mMyTaxHelper.getWritableDatabase();
                            String whereClause = MyTaxHelper.COL_ID + "=?";
                            String[] whereArgs = new String[]{ String.valueOf(taxvo.getCOL_ID()) };
                            db_d.delete(MyTaxHelper.TABLE_NAME, whereClause, whereArgs);
                            mMyTaxHelper.close();

                            mAdapter.notifyDataSetChanged();

                        }
                    });
                    builder.setNegativeButton("아니오", null);
                    builder.show();


                }
            });

            return convertView;
        }

        class ViewHolder {
            LinearLayout list_item = null;
            ImageView num_text 		= null;
            TextView comment_text 	= null;
            TextView tax_text 		= null;
            TextView date_text 	= null;
        }
    }

}
