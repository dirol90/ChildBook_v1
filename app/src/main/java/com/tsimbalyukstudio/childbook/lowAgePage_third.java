package com.tsimbalyukstudio.childbook;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class lowAgePage_third extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_age_page_third);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ADDS add = new ADDS(this);
        add.addBottomBanner(this);
    }
    int partsArNames[] = {R.raw.glaza, R.raw.tulovishe,
            R.raw.uho, R.raw.rot,
            R.raw.ruka, R.raw.noga,
            R.raw.nos, R.raw.lob,
            R.raw.volosy};

    int parts[] = {R.id.eay,R.id.tulovishe,R.id.year,R.id.rot,R.id.ruki,R.id.nogi,R.id.nos,R.id.lob, R.id.volosy};

    VoiseSound vs = new VoiseSound();
    public void parts(View view){
        for (int x = 0; x < parts.length; x++){
            if (view.getId()==parts[x]){
                BackgroundSoundService.player.setVolume(0,0);
                vs.changeTrack(this, partsArNames[x]);
                }
        }
    }

    int now = 0;
    public void prev(View view){
        ImageView iv = (ImageView) findViewById(R.id.person);
        now++;
        if (now%2 == 0){iv.setBackgroundResource(R.drawable.lap_third_boy);}
        else {iv.setBackgroundResource(R.drawable.lap_third_girl);}
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


