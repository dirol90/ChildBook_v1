package com.tsimbalyukstudio.childbook;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

public class Ballon_Page extends AppCompatActivity implements View.OnClickListener {

    int[] ballons_image_ar = { R.drawable.ballon_two, R.drawable.ballon_three,  R.drawable.ballon_five, R.drawable.ballon_six, R.drawable.ballon_eight, R.drawable.ballon_seven,  R.drawable.h_ballon_roket, R.drawable.h_ballon_three, R.drawable.h_ballon_two};
    //int[] confetti_ar = {R.drawable.confetti_two, R.drawable.confetti_one, R.drawable.confetti_three};
    ArrayList<Baloon> balloms_al = new ArrayList();
    int ballonCounter;
    int speedBoost = 1;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        public void run() {
            Baloon b = new Baloon();
            balloms_al.add(b);
            if (speedBoost < 1000) {
                speedBoost *= 1.5;
            }
            handler.postDelayed(runnable, (int) (Math.random() * 2250) - speedBoost);
        }
    };

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //BackgroundSoundService.player.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ballon__page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ADDS add = new ADDS(this);
        add.addBottomBanner(this);

        tv = (TextView) findViewById(R.id.ballons_counter_text);
        tv.setText("Ты поймал 0 шаров");

        new Thread(new Runnable() {
            @Override
            public void run() {
                player();
            }
        }).start();

        runnable.run();
    }

    int id;

    class Baloon {
        ConstraintLayout buttonContainer;
        Button button;
        int speed;


        Handler handlerMove = new Handler();
        Runnable runnableMove = new Runnable() {
            public void run() {
                if (button.getY() < -300) {
                    buttonContainer.removeView(button);
                    for (int x = 0; x < balloms_al.size(); x++) {
                        if (button.getId() == balloms_al.get(x).button.getId()) {
                            balloms_al.remove(x);
                        }
                    }

                } else {
                    button.setY(button.getY() - speed);
                }
                handlerMove.postDelayed(runnableMove, (int) (Math.random() * 20));
            }
        };

        Baloon() {
            buttonContainer = (ConstraintLayout) findViewById(R.id.balloon_background);
            button = new Button(Ballon_Page.this);
            button.setId(id++);
            int temp = (int) (Math.random() * 9);
            button.setBackgroundResource(ballons_image_ar[temp]);
            button.setOnClickListener(Ballon_Page.this);
            int x = (int) (Math.random() * 800) + 100;
            button.setX(x);
            button.setY(1920);
            speed = 30;

            buttonContainer.addView(button);
            runnableMove.run();
        }

        public void remove() {
            runnableDown.run();
        }


        Handler handlerDown = new Handler();
        public Runnable runnableDown = new Runnable() {
            public void run() {
                //int temp = (int) (Math.random() * 3);
                button.setBackgroundResource(R.drawable.confetti_two);
                button.setOnClickListener(null);
                if (button.getY() > 1920) {
                    buttonContainer.destroyDrawingCache();
                    buttonContainer.removeView(button);
                } else {
                    button.setY(button.getY() + 50);
                }
                handlerDown.postDelayed(runnableDown, 2);
            }
        };

    }


    MediaPlayer mp;

    public void player() {
        mp = new MediaPlayer();
        try {
            mp = MediaPlayer.create(this, R.raw.bloom);
        } catch (Exception e) {
        }
    }


    @Override
    public void onClick(View v) {
        mp.start();
        for (int x = 0; x < balloms_al.size(); x++) {
            if (v.getId() == balloms_al.get(x).button.getId()) {
                Baloon b = balloms_al.get(x);
                balloms_al.remove(x);
                b.remove();
            }
        }
        ballonCounter++;
        tv.setText("Ты поймал " + ballonCounter + " шаров");
    }

    @Override
    public void onBackPressed() {
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
