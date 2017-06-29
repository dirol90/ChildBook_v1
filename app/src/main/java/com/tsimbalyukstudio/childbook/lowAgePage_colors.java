package com.tsimbalyukstudio.childbook;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

public class lowAgePage_colors extends AppCompatActivity {

    VoiseSound vs = new VoiseSound();
    int colorsAr[] = {R.raw.violet, R.raw.green, R.raw.blue, R.raw.biryuz, R.raw.yellow, R.raw.orange, R.raw.pink,R.raw.white, R.raw.black};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_age_page_colors);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ADDS add = new ADDS(this);
        add.addBottomBanner(this);

        new Thread(new Runnable() {
            @Override
            public void run() {

                Button btn1  = (Button) findViewById(R.id.fiolet);
                btn1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            //Toast.makeText(lowAgePage_colors.this, "btn1", Toast.LENGTH_SHORT).show();

                            BackgroundSoundService.player.setVolume(0,0);
                            vs.changeTrack(lowAgePage_colors.this, colorsAr[0]);
                        }
                        return false;
                    }
                });
                Button btn2  = (Button) findViewById(R.id.green);
                btn2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            //Toast.makeText(lowAgePage_colors.this, "btn2", Toast.LENGTH_SHORT).show();

                            BackgroundSoundService.player.setVolume(0,0);
                            vs.changeTrack(lowAgePage_colors.this, colorsAr[1]);
                        }
                        return false;
                    }
                });

                Button btn3  = (Button) findViewById(R.id.goluboj);
                btn3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            //Toast.makeText(lowAgePage_colors.this, "btn3", Toast.LENGTH_SHORT).show();

                            BackgroundSoundService.player.setVolume(0,0);
                            vs.changeTrack(lowAgePage_colors.this, colorsAr[2]);
                        }
                        return false;
                    }
                });

                Button btn4  = (Button) findViewById(R.id.biryuzovyj);
                btn4.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            //Toast.makeText(lowAgePage_colors.this, "btn4", Toast.LENGTH_SHORT).show();

                            BackgroundSoundService.player.setVolume(0,0);
                            vs.changeTrack(lowAgePage_colors.this, colorsAr[3]);
                        }
                        return false;
                    }
                });

                Button btn5  = (Button) findViewById(R.id.zheltyj);
                btn5.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            //Toast.makeText(lowAgePage_colors.this, "btn5", Toast.LENGTH_SHORT).show();

                            BackgroundSoundService.player.setVolume(0,0);
                            vs.changeTrack(lowAgePage_colors.this, colorsAr[4]);
                        }
                        return false;
                    }
                });

                Button btn6  = (Button) findViewById(R.id.orange);
                btn6.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            //Toast.makeText(lowAgePage_colors.this, "btn6", Toast.LENGTH_SHORT).show();

                            BackgroundSoundService.player.setVolume(0,0);
                            vs.changeTrack(lowAgePage_colors.this, colorsAr[5]);
                        }
                        return false;
                    }
                });

                Button btn7  = (Button) findViewById(R.id.red);
                btn7.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            //Toast.makeText(lowAgePage_colors.this, "btn7", Toast.LENGTH_SHORT).show();

                            BackgroundSoundService.player.setVolume(0,0);
                            vs.changeTrack(lowAgePage_colors.this, colorsAr[6]);
                        }
                        return false;
                    }
                });

                Button btn8  = (Button) findViewById(R.id.white);
                btn8.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            //Toast.makeText(lowAgePage_colors.this, "btn8", Toast.LENGTH_SHORT).show();

                            BackgroundSoundService.player.setVolume(0,0);
                            vs.changeTrack(lowAgePage_colors.this, colorsAr[7]);
                        }
                        return false;
                    }
                });

                Button btn9  = (Button) findViewById(R.id.black);
                btn9.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            //Toast.makeText(lowAgePage_colors.this, "btn9", Toast.LENGTH_SHORT).show();

                            BackgroundSoundService.player.setVolume(0,0);
                            vs.changeTrack(lowAgePage_colors.this, colorsAr[8]);
                        }
                        return false;
                    }
                });
            }
        }).start();
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
