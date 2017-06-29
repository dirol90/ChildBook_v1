package com.tsimbalyukstudio.childbook;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class lowAgePage_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_age_page_second);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ADDS add = new ADDS(this);
        add.addBottomBanner(this);

        for (int x = 0; x < numAr.length; x++) { // set image id arr
            numIdAr[x] = numAr[x];
        }
    }

    int numAr[] = { R.drawable.num_null, R.drawable.num_one, R.drawable.num_two, R.drawable.num_three, R.drawable.num_fore, R.drawable.num_five, R.drawable.num_six, R.drawable.num_seven, R.drawable.num_eight, R.drawable.num_nine};
    int numArNames[] = {R.raw.num_ziro, R.raw.num_one, R.raw.num_two, R.raw.num_three, R.raw.num_fore, R.raw.num_five, R.raw.num_six, R.raw.num_seven, R.raw.num_eight, R.raw.num_nine};
    int[] numIdAr = new int[numAr.length];
    int numArPos = 0;
    FloatingActionButton fab;

    public void next(View view) {
        if (fab == null) {
            fab = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        }
        if (numArPos == numIdAr.length - 1) {
            numArPos = 0;
        } else {
            numArPos++;
        }
        fab.setImageResource(numIdAr[numArPos]);
    }

    public void prev(View view) {
        if (fab == null) {
            fab = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        }
        if (numArPos == 0) {
            numArPos = numIdAr.length - 1;
        } else {
            numArPos--;
        }
        fab.setImageResource(numIdAr[numArPos]);
    }


    VoiseSound vs = new VoiseSound();
    public void onClick(View view) {
        BackgroundSoundService.player.setVolume(0,0);
        vs.changeTrack(this, numArNames[numArPos]);
    }

    @Override
    public void onBackPressed() {
        BackgroundSoundService.player.setVolume(0.1f, 0.1f);
        Intent intent = new Intent(this, lowAgePage_menu.class);
        startActivity(intent);
        finish();
    }

    public void back(View view) {
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