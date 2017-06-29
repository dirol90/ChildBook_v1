package com.tsimbalyukstudio.childbook;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;


public class BackgroundSoundService extends Service {

    static MediaPlayer player;
    static boolean musicFlag = true; // if service started - true
    static int musicPosition;
    private int [] musicPool = {R.raw.main_music, R.raw.main_music_two, R.raw.main_music_three};
    private int musicPoolCounter;
    //static Intent svc;

    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, musicPool[musicPoolCounter]);
        musicPoolCounter++;
        player.setVolume(0.1f,0.1f);
        player.start();
        if (musicPoolCounter == musicPool.length) {musicPoolCounter = 0;}
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playNextSong();
            }
        });
    }

    public void playNextSong() {
        onDestroy();
        onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if(musicPosition != 0){player.seekTo(musicPosition);}
        player.start();
        return Service.START_NOT_STICKY;
    }

    public static void onStart() {
        player.seekTo(musicPosition);
        musicFlag = true;
        player.start();
    }

    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public void onStop() {
        musicFlag = false;
        player.stop();
    }

    public static void onPause() {
        musicPosition = player.getCurrentPosition();
        musicFlag = false;
        player.stop();
    }


    @Override
    public void onDestroy() {
        player.stop();
        if (player != null) player.release();
    }

    @Override
    public void onLowMemory() {

    }
}