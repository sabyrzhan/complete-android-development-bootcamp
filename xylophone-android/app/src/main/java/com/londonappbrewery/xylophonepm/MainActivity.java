package com.londonappbrewery.xylophonepm;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Helpful Constants
    private final int NR_OF_SIMULTANEOUS_SOUNDS = 7;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int NO_LOOP = 0;
    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    // TODO: Add member variables here
    private SoundPool soundPool;
    private int mCSoundId;
    private int mDSoundId;
    private int mESoundId;
    private int mFSoundId;
    private int mGSoundId;
    private int mASoundId;
    private int mBSoundId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Create a new SoundPool
        soundPool = new SoundPool(NR_OF_SIMULTANEOUS_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        mASoundId = soundPool.load(getApplicationContext(), R.raw.note6_a, 1);
        mBSoundId = soundPool.load(getApplicationContext(), R.raw.note7_b, 1);
        mCSoundId = soundPool.load(getApplicationContext(), R.raw.note1_c, 1);
        mDSoundId = soundPool.load(getApplicationContext(), R.raw.note2_d, 1);
        mESoundId = soundPool.load(getApplicationContext(), R.raw.note3_e, 1);
        mFSoundId = soundPool.load(getApplicationContext(), R.raw.note4_f, 1);
        mGSoundId = soundPool.load(getApplicationContext(), R.raw.note5_g, 1);

        // TODO: Load and get the IDs to identify the sounds
    }

    // TODO: Add the play methods triggered by the buttons
    public void playSound(View view) {
        switch (view.getId()) {
            case R.id.a_key:
                soundPool.play(mASoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                Log.i("Xylophone", "A button pressed");
                break;
            case R.id.b_key:
                soundPool.play(mBSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                Log.i("Xylophone", "B button pressed");
                break;
            case R.id.c_key:
                soundPool.play(mCSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                Log.i("Xylophone", "C button pressed");
                break;
            case R.id.d_key:
                soundPool.play(mDSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                Log.i("Xylophone", "D button pressed");
                break;
            case R.id.e_key:
                soundPool.play(mESoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                Log.i("Xylophone", "E button pressed");
                break;
            case R.id.f_key:
                soundPool.play(mFSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                Log.i("Xylophone", "F button pressed");
                break;
            case R.id.g_key:
                soundPool.play(mGSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                Log.i("Xylophone", "G button pressed");
                break;
        }
    }
}
