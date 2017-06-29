package com.tsimbalyukstudio.childbook;

import android.content.Context;
import android.media.MediaPlayer;


public class VoiseSound {

    MediaPlayer mp = new MediaPlayer();

    void changeTrack(Context context, int soundId){
        if (mp.isPlaying()){

        }
        else {
            if (mp != null){
                mp.stop();
                mp.release();
            }
            mp = MediaPlayer.create(context, soundId);
            mp.setVolume(1f, 1f);
            mp.start();
        }
    }

}
