package com.example.dwu.a20180927.Account;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.dwu.management.R;
public class AccountEnglish extends AppCompatActivity {

    private SoundPool soundPool;
    private int sound;
    private Intent intent;
    private int accountNumber = 0;
    private TextView titleTextView;
    private TextView descTextView;
    private TextView explainTextView;//해설

    private static final int[] soundTrakcs = new int[]{ R.raw.account01e, R.raw.account02e, R.raw.account03e,
        R.raw.account04e, R.raw.account05e, R.raw.account06e, R.raw.account07e, R.raw.account08e, R.raw.account09e, R.raw.account10e,
        R.raw.account11e};

    private static final int[] textTracks = new int[] {
            R.string.account_1, R.string.account_2, R.string.account_3, R.string.account_4,
            R.string.account_5, R.string.account_6, R.string.account_7, R.string.account_8, R.string.account_9,
            R.string.account_10, R.string.account_11, R.string.account_12
    };

    private static final int[] textChTracks = new int[] {
            R.string.account_1_e, R.string.account_2_e, R.string.account_3_e, R.string.account_4_e,
            R.string.account_5_e, R.string.account_6_e, R.string.account_7_e, R.string.account_8_e, R.string.account_9_e,
            R.string.account_10_e, R.string.account_11_e, R.string.account_12_e
    };

    private static final int[] textChTracks2 = new int[]{
            R.string.account_1_e2, R.string.account_2_e2, R.string.account_3_e2, R.string.account_4_e2,
            R.string.account_5_e2, R.string.account_6_e2, R.string.account_7_e2, R.string.account_8_e2, R.string.account_9_e2,
            R.string.account_10_e2, R.string.account_11_e2, R.string.account_12_e2
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
