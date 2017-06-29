package com.tsimbalyukstudio.childbook;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import java.lang.*;
import java.util.UUID;


public class Main_Page extends AppCompatActivity {

    TextView tv;
    Activity a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new SplashActivity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        a = this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Character.readFile(a);
                }
                catch(Exception e){

                }
            }
        }).start();
        ADDS add = new ADDS(this);
        add.addBottomBanner(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        tv = (TextView) findViewById(R.id.name);
        fab.setImageResource(Character.imageAr[Character.characterImageId]);
        tv.setText(Character.characterName);
    }

    public void lawAgePage(View view) {
        Intent intent = new Intent(this, lowAgePage_menu.class);
        startActivity(intent);
        finish();
    }

    public void lowAgePage_drawing(View view) {
        Intent intent = new Intent(this, lowAgePage_drawing.class);
        startActivity(intent);
        finish();
    }

    public void stories(View view) {
        Intent intent = new Intent(this, Strories_menu.class);
        startActivity(intent);
        finish();
    }

    // fine exit to main_background
    public void exit(View view) {
        AlertDialog.Builder alerBuilder = new AlertDialog.Builder(this);
        alerBuilder.setTitle("Выйти?");
        alerBuilder.setMessage("Вы уверены, что хотите выйти?");
        alerBuilder.setPositiveButton("Да", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                BackgroundSoundService.player.pause();
                Intent i = new Intent();
                i.setAction(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                Main_Page.this.startActivity(i);
            }
        });
        alerBuilder.setNegativeButton("Нет", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                dialog.cancel();
            }
        });
        alerBuilder.show();
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onPause() {
        BackgroundSoundService.player.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Character.readFile(a);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        tv = (TextView) findViewById(R.id.name);
        fab.setImageResource(Character.imageAr[Character.characterImageId]);
        tv.setText(Character.characterName);
            Intent svc = new Intent(this, BackgroundSoundService.class);
            startService(svc);
            super.onResume();
    }

    public void music(View view) {
        if (BackgroundSoundService.musicFlag) {
            BackgroundSoundService.player.setVolume(0, 0);
            BackgroundSoundService.musicFlag = false;
        } else {
            BackgroundSoundService.player.setVolume(0.1f, 0.1f);
            BackgroundSoundService.musicFlag = true;
        }
    }
}
