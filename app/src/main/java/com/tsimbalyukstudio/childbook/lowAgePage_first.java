package com.tsimbalyukstudio.childbook;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class lowAgePage_first extends AppCompatActivity implements View.OnClickListener {
    int animalsArNames[] = {R.raw.olen_ru, R.raw.svinka_ru,
            R.raw.utka_ru, R.raw.zayac_ru,
            R.raw.medved_ru, R.raw.belka_ru,
            R.raw.koala_ru, R.raw.krokodil_ru,
            R.raw.slon_ru, R.raw.ezh_ru,
            R.raw.lev_ru, R.raw.sova_ru,
            R.raw.ptica_ru, R.raw.lisa_ru,
            R.raw.kuritsa_ru, R.raw.ovca_ru,
            R.raw.enot_ru, R.raw.straus_ru,
            R.raw.begemot_ru, R.raw.bronenosets_ru,
            R.raw.cherepaha_ru, R.raw.hameleon_ru,
            R.raw.zebra_ru, R.raw.zhiraf_ru};
    int[] animalsIdAr = {R.drawable.lap_dir, R.drawable.lap2_svinya, R.drawable.lap2_utka, R.drawable.lap2_zayac, R.drawable.lap_bear, R.drawable.lap_belka, R.drawable.lap_coala, R.drawable.lap_croco, R.drawable.lap_elephant, R.drawable.lap_ezh, R.drawable.lap_lion, R.drawable.lap2_sova, R.drawable.lap2_ptichka , R.drawable.lap2_lisa, R.drawable.lap2_kurica , R.drawable.lap2_baran, R.drawable.lap2_enot, R.drawable.lap2_aist, R.drawable.lap2_begemot, R.drawable.lap2_bronenosets, R.drawable.lap2_cherepaha, R.drawable.lap2_yasheritsa, R.drawable.lap2_zerbra, R.drawable.lap2_zhiraf };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_age_page_first);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ADDS add = new ADDS(this);
        add.addBottomBanner(this);

        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton3);
        fab.setImageResource(R.drawable.lap_dir);
        fab.setOnClickListener(this);
    }


    int animalArPos = 0;
    FloatingActionButton fab;

    public void next(View view) {
        if (animalArPos == animalsIdAr.length - 1) {
            animalArPos = 0;
        } else {
            animalArPos++;
        }
        fab.setImageResource(animalsIdAr[animalArPos]);
    }

    public void prev(View view) {
        if (animalArPos == 0) {
            animalArPos = animalsIdAr.length - 1;
        } else {
            animalArPos--;
        }
        fab.setImageResource(animalsIdAr[animalArPos]);
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

    VoiseSound vs = new VoiseSound();
    @Override
    public void onClick(View view) {
        BackgroundSoundService.player.setVolume(0,0);
        vs.changeTrack(this, animalsArNames[animalArPos]);
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
