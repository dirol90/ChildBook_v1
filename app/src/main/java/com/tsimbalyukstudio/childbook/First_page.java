package com.tsimbalyukstudio.childbook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.utils.PermissionsHelper;
import com.mopub.common.util.Utils;


import java.lang.*;


public class First_page extends AppCompatActivity{

    //static
    Intent svc;
    Activity a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setImageResource(Character.imageAr[Character.characterImageId]);

        if(Character.characterIsCreated){
            Intent intent = new Intent(this, Main_Page.class);
            startActivity(intent);
            finish();
        }

        svc = new Intent(First_page.this, BackgroundSoundService.class);
            startService(svc);

    }
    public void changeActivity(View view) {
        Intent intent = new Intent(this, Main_Page.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        Character.characterName = ""+editText.getText().toString();
        Character.characterIsCreated = true;
        if(Character.characterIsCreated){
            Character.writeFile(a);}
        startActivity(intent);
        finish();
    }


    public void nextImage(View view) {
        if (Character.characterImageId == Character.imageAr.length - 1) {
            Character.characterImageId = 0;
        } else {
            Character.characterImageId++;
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setImageResource(Character.imageAr[Character.characterImageId]);
    }

    public void prevImage(View view) {
        if (Character.characterImageId == 0) {
            Character.characterImageId = Character.imageAr.length - 1;
        } else {
            Character.characterImageId--;
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setImageResource(Character.imageAr[Character.characterImageId]);
    }

    public void confident (View v){
        String url = "http://tsimbalyukstudio.esy.es/agreement.pdf";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onPause() {
        try{
        BackgroundSoundService.player.pause();}
        catch(Exception e){}
        super.onPause();
    }

    @Override
    protected void onResume() {
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
