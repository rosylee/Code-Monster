package com.example.dwu.a20180927.Loans;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.dwu.management.R;

public class LoanVietnamese extends AppCompatActivity {

    private SoundPool soundPool;
    private int sound;
    private Intent intent;
    private int accountNumber = 0;
    private TextView titleTextView;//제목
    private TextView descTextView;//해석
    private TextView explainTextView;//해설

    private static final int[] soundTrakcs = new int[]{ R.raw.loan01v, R.raw.loan02v, R.raw.loan03v,
        R.raw.loan04v, R.raw.loan05v, R.raw.loan06v, R.raw.loan07v, R.raw.loan08v, R.raw.loan09v, R.raw.loan10v,
        R.raw.loan11v, R.raw.loan12v,R.raw.loan13v};

    private static final int[] textTracks = new int[] {
            R.string.loan_1, R.string.loan_2, R.string.loan_3, R.string.loan_4,
            R.string.loan_5, R.string.loan_6, R.string.loan_7, R.string.loan_8,
            R.string.loan_9, R.string.loan_10, R.string.loan_11, R.string.loan_12,
            R.string.loan_13
    };


    private static final int[] textVTracks = new int[] {
            R.string.account_1_v, R.string.account_2_v, R.string.account_3_v, R.string.account_4_v,
            R.string.account_5_ch, R.string.account_6_ch, R.string.account_7_ch, R.string.account_8_ch, R.string.account_9_ch,
            R.string.account_10_ch, R.string.account_11_ch, R.string.account_12_ch,R.string.account_1_v
    };//해석

    private static final int[] textVTracks2 = new int[]{
            R.string.account_1_v2,R.string.account_2_v2,R.string.account_3_v2,R.string.account_4_v2,
            R.string.account_1_v2,R.string.account_2_v2,R.string.account_3_v2,R.string.account_4_v2,
            R.string.account_1_v2

    };//해설

    public static final String ACCOUNT_SOUND_NUMBER = "account_sound_number";
    private static final String TAG = "AccountSound";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_chinese);

        intent = getIntent();
        accountNumber = intent.getIntExtra(ACCOUNT_SOUND_NUMBER, -1);

        titleTextView = findViewById(R.id.textView);
        descTextView = findViewById(R.id.textView2);
        explainTextView = findViewById(R.id.textView3);

        if (accountNumber >= 0) {
            Log.d(TAG, "Number : " + accountNumber);

            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
            sound = soundPool.load(this, soundTrakcs[accountNumber-1],1);

            titleTextView.setText(textTracks[accountNumber-1]);
            descTextView.setText(textVTracks[accountNumber-1]);
            explainTextView.setText(textVTracks2[accountNumber-1]);
        }

    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.imageButton:
                soundPool.play(sound, 1, 1, 0, 0, 1);
                break;
        }
    }
}
