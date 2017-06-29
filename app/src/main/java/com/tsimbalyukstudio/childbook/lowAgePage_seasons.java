package com.tsimbalyukstudio.childbook;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class lowAgePage_seasons extends AppCompatActivity {

    VoiseSound vs = new VoiseSound();
    int seasonsAr[] = {R.raw.spring, R.raw.summer, R.raw.outumn, R.raw.winter};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_age_page_seasons);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ADDS add = new ADDS(this);
        add.addBottomBanner(this);

        Button btn1  = (Button) findViewById(R.id.spring);
        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Toast.makeText(lowAgePage_seasons.this, "btn1", Toast.LENGTH_SHORT).show();
                    BackgroundSoundService.player.setVolume(0,0);
                    vs.changeTrack(lowAgePage_seasons.this, seasonsAr[0]);
                }
                return false;
            }
        });
        Button btn2  = (Button) findViewById(R.id.summer);
        btn2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                   //Toast.makeText(lowAgePage_seasons.this, "btn2", Toast.LENGTH_SHORT).show();
                    BackgroundSoundService.player.setVolume(0,0);
                    vs.changeTrack(lowAgePage_seasons.this, seasonsAr[1]);
                }
                return false;
            }
        });

        Button btn3  = (Button) findViewById(R.id.autumn);
        btn3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Toast.makeText(lowAgePage_seasons.this, "btn3", Toast.LENGTH_SHORT).show();
                    BackgroundSoundService.player.setVolume(0,0);
                    vs.changeTrack(lowAgePage_seasons.this, seasonsAr[2]);
                }
                return false;
            }
        });

        Button btn4  = (Button) findViewById(R.id.winter);
        btn4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Toast.makeText(lowAgePage_seasons.this, "btn4", Toast.LENGTH_SHORT).show();
                    BackgroundSoundService.player.setVolume(0,0);
                    vs.changeTrack(lowAgePage_seasons.this, seasonsAr[3]);
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        BackgroundSoundService.player.setVolume(0.1f, 0.1f);
        Intent intent = new Intent(this, lowAgePage_menu.class);
        startActivity(intent);
        finish();
    }

    public void back(View view){
        onBackPressed();
    }

    @Override
    protected void onPause() {
        BackgroundSoundService.player.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Intent svc = new Intent(this, BackgroundSoundService.class);
        startService(svc);
        super.onResume();
    }
}
