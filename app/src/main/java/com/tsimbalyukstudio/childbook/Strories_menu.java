package com.tsimbalyukstudio.childbook;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Strories_menu extends AppCompatActivity {

    Map<Integer, Integer> hashMap = new HashMap<>();
    Map<Integer, Integer> hashMapString = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strories_menu);


        ADDS add = new ADDS(this);
        add.addNonSkipVideo(this);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        new Thread(new Runnable() {
            @Override
            public void run() {
                hashMap.put(R.id.imageView1,1);
                hashMapString.put(1, R.id.textView1);
                hashMap.put(R.id.imageView2,2);
                hashMapString.put(2, R.id.textView2);
                hashMap.put(R.id.imageView3,3);
                hashMapString.put(3, R.id.textView3);
                hashMap.put(R.id.imageView4,4);
                hashMapString.put(4, R.id.textView4);
                hashMap.put(R.id.imageView5,5);
                hashMapString.put(5, R.id.textView5);
                hashMap.put(R.id.imageView6,6);
                hashMapString.put(6, R.id.textView6);
                hashMap.put(R.id.imageView7,7);
                hashMapString.put(7, R.id.textView7);
                hashMap.put(R.id.imageView8,8);
                hashMapString.put(8, R.id.textView8);
                hashMap.put(R.id.imageView9,9);
                hashMapString.put(9, R.id.textView9);
                hashMap.put(R.id.imageView10,10);
                hashMapString.put(10, R.id.textView10);
                hashMap.put(R.id.imageView11,11);
                hashMapString.put(11, R.id.textView11);
                hashMap.put(R.id.imageView12,12);
                hashMapString.put(12, R.id.textView12);
                hashMap.put(R.id.imageView13,13);
                hashMapString.put(13, R.id.textView13);
                hashMap.put(R.id.imageView14,14);
                hashMapString.put(14, R.id.textView14);
                hashMap.put(R.id.imageView15,15);
                hashMapString.put(15, R.id.textView15);
                hashMap.put(R.id.imageView16,16);
                hashMapString.put(16, R.id.textView16);
                hashMap.put(R.id.imageView17,17);
                hashMapString.put(17,R.id.textView17);
                hashMap.put(R.id.imageView18,18);
                hashMapString.put(18, R.id.textView18);
                hashMap.put(R.id.imageView19,19);
                hashMapString.put(19, R.id.textView19);
                hashMap.put(R.id.imageView20,20);
                hashMapString.put(20, R.id.textView20);
                hashMap.put(R.id.imageView21,21);
                hashMapString.put(21, R.id.textView21);
                hashMap.put(R.id.imageView22,22);
                hashMapString.put(22, R.id.textView22);
                hashMap.put(R.id.imageView23,23);
                hashMapString.put(23, R.id.textView23);
                hashMap.put(R.id.imageView24,24);
                hashMapString.put(24, R.id.textView24);
                hashMap.put(R.id.imageView25,25);
                hashMapString.put(25, R.id.textView25);
                hashMap.put(R.id.imageView26,26);
                hashMapString.put(26, R.id.textView26);
                hashMap.put(R.id.imageView27,27);
                hashMapString.put(27, R.id.textView27);
                hashMap.put(R.id.imageView28,28);
                hashMapString.put(28, R.id.textView28);
            }
        }).start();
    }

    public void onClick(View v){
        Intent intent = new Intent(this, Stories_Player.class);
        intent.putExtra("trackID", hashMap.get(v.getId()));
        int x = hashMap.get(v.getId());
        TextView tv = (TextView) findViewById(hashMapString.get(x));
        intent.putExtra("textR",tv.getText());
        if(isOnline()){
        startActivity(intent);
        finish();}
        else {
            Toast.makeText(this, "Нет подключения к интернет!", Toast.LENGTH_SHORT).show();
        }
    }

    protected  boolean isOnline(){
        String cs = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(cs);
        if(cm.getActiveNetworkInfo() == null){
            return false;
        } else {return true;}
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Main_Page.class);
        startActivity(intent);
        finish();
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

    public void back(View view) {
        onBackPressed();
    }
}


