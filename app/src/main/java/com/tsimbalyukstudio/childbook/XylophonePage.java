package com.tsimbalyukstudio.childbook;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

public class XylophonePage extends AppCompatActivity {

    private int[] musicPool = {R.raw.xyl_1, R.raw.xyl_2, R.raw.xyl_3, R.raw.xyl_4, R.raw.xyl_5, R.raw.xyl_6, R.raw.xyl_7, R.raw.xyl_8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xylophone_page);
        setRequestedOrientation(SCREEN_ORIENTATION_LANDSCAPE);
        ADDS add = new ADDS(this);
        add.addBottomBanner(this);

            BackgroundSoundService.player.setVolume(0, 0);

        Button btn1  = (Button) findViewById(R.id.xyl_1);
        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    final MediaPlayer player = MediaPlayer.create(XylophonePage.this, musicPool[0]);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            player.release();
                        }
                    });
                    player.start();
                }
                return false;
            }
        });
        Button btn2  = (Button) findViewById(R.id.xyl_2);
        btn2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    final MediaPlayer player = MediaPlayer.create(XylophonePage.this, musicPool[1]);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            player.release();
                        }
                    });
                    player.start();
                }
                return false;
            }
        });

        Button btn3  = (Button) findViewById(R.id.xyl_3);
        btn3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    final MediaPlayer player = MediaPlayer.create(XylophonePage.this, musicPool[2]);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            player.release();
                        }
                    });
                    player.start();
                }
                return false;
            }
        });

        Button btn4  = (Button) findViewById(R.id.xyl_4);
        btn4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    final MediaPlayer player = MediaPlayer.create(XylophonePage.this, musicPool[3]);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            player.release();
                        }
                    });
                    player.start();
                }
                return false;
            }
        });

        Button btn5  = (Button) findViewById(R.id.xyl_5);
        btn5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    final MediaPlayer player = MediaPlayer.create(XylophonePage.this, musicPool[4]);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            player.release();
                        }
                    });
                    player.start();
                }
                return false;
            }
        });

        Button btn6  = (Button) findViewById(R.id.xyl_6);
        btn6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    final MediaPlayer player = MediaPlayer.create(XylophonePage.this, musicPool[5]);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            player.release();
                        }
                    });
                    player.start();
                }
                return false;
            }
        });

        Button btn7  = (Button) findViewById(R.id.xyl_7);
        btn7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    final MediaPlayer player = MediaPlayer.create(XylophonePage.this, musicPool[6]);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            player.release();
                        }
                    });
                    player.start();
                }
                return false;
            }
        });

        Button btn8  = (Button) findViewById(R.id.xyl_8);
        btn8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    final MediaPlayer player = MediaPlayer.create(XylophonePage.this, musicPool[7]);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            player.release();
                        }
                    });
                    player.start();
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

    public void back(View view) {
        onBackPressed();
    }

    @Override
    protected void onResume() {
        Intent svc = new Intent(this, BackgroundSoundService.class);
        startService(svc);
        super.onResume();
    }

}
