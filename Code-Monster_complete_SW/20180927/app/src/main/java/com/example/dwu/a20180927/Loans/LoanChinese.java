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
public class LoanChinese extends AppCompatActivity {

    private SoundPool soundPool;
    private int sound;
    private Intent intent;
    private int accountNumber = 0;
    private TextView titleTextView;//제목
    private TextView descTextView;//해석
    private TextView explainTextView;//해설

    private static final int[] soundTrakcs = new int[]{ R.raw.loan01, R.raw.loan02, R.raw.loan03, R.raw.loan04,
            R.raw.loan05, R.raw.loan06, R.raw.loan07,R.raw.loan08, R.raw.loan09, R.raw.loan10, R.raw.loan11, R.raw.loan12, R.raw.loan13
    };

    private static final int[] textTracks = new int[] {
            R.string.loan_1, R.string.loan_2, R.string.loan_3, R.string.loan_4,R.string.loan_5,R.string.loan_6,
            R.string.loan_7, R.string.loan_8, R.string.loan_9, R.string.loan_10,R.string.loan_11,R.string.loan_12,R.string.loan_13
    };


    private static final int[] textChTracks = new int[] {
            R.string.loan_1_ch, R.string.loan_2_ch, R.string.loan_3_ch, R.string.loan_4_ch,R.string.loan_5_ch,R.string.loan_6_ch,
            R.string.loan_7_ch, R.string.loan_8_ch, R.string.loan_9_ch, R.string.loan_10_ch,R.string.loan_11_ch,R.string.loan_12_ch,
            R.string.loan_13_ch

    };//해석

    private static final int[] textChTracks2 = new int[]{
            R.string.loan_1_ch2, R.string.loan_2_ch2, R.string.loan_3_ch2, R.string.loan_4_ch2,R.string.loan_5_ch2,R.string.loan_6_ch2,
            R.string.loan_7_ch2, R.string.loan_8_ch2, R.string.loan_9_ch2, R.string.loan_10_ch2,R.string.loan_11_ch2,R.string.loan_12_ch2,
            R.string.loan_13_ch2
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
            descTextView.setText(textChTracks[accountNumber-1]);
            explainTextView.setText(textChTracks2[accountNumber-1]);
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
