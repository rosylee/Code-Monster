package com.example.dwu.a20180927.Search;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dwu.management.R;

public class account1 extends AppCompatActivity {

    SoundPool soundPool;
    int sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dic01);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sound = soundPool.load(this, R.raw.account01,1);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.imageButton:
                soundPool.play(sound, 1, 1, 0, 0, 1);
                break;
        }
    }


}
