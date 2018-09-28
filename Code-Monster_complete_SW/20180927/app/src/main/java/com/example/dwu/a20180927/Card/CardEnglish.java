package com.example.dwu.a20180927.Card;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;import com.example.dwu.management.R;
public class CardEnglish extends AppCompatActivity {
    private SoundPool soundPool;
    private int sound;
    private Intent intent;
    private int accountNumber = 0;
    private TextView titleTextView;//제목
    private TextView descTextView;//해석
    private TextView explainTextView;//해설
    private static final int[] soundTrakcs = new int[]{ R.raw.card01e, R.raw.card02e, R.raw.card03e,
        R.raw.card04e, R.raw.card05e, R.raw.card06e
    };
    private static final int[] textTracks = new int[] {
            R.string.card_1, R.string.card_2, R.string.card_3, R.string.card_4,
            R.string.card_5, R.string.card_6
    };
    private static final int[] textChTracks = new int[] {
            R.string.card_1_e, R.string.card_2_e, R.string.card_3_e, R.string.card_4_e,
            R.string.card_5_e, R.string.card_6_e
    };//해석
    private static final int[] textChTracks2 = new int[]{
            R.string.card_1_e2,R.string.card_2_e2,R.string.card_3_e2,R.string.card_4_e2,R.string.card_5_e2,R.string.card_6_e2

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
