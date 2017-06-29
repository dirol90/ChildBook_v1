package com.tsimbalyukstudio.childbook;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


public class Stories_Player extends AppCompatActivity {


    Intent intent;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories__player);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        text = (TextView) findViewById(R.id.textView7);
        text.setText("ЗАГРУЗКА...");

        ADDS add = new ADDS(this);
        add.addNonSkipVideo(this);

        intent = getIntent();

        Thread thread = new Thread(null, doBackgroundThreadProcessing,
                "Background");
        thread.start();

    }

    private Runnable doBackgroundThreadProcessing = new Runnable() {
        public void run() {
            backgroundThreadProcessing();
        }
    };

    int imageAr[] = {0, R.drawable.sk_volshebnik_izumrudnogo, R.drawable.sk_volk_i_semero,
            R.drawable.sk_vasilisa_prekrasnaya, R.drawable.sk_tsarevna_lyagushka,
            R.drawable.sk_teremok, R.drawable.sk_snezhnaya_koroleva,
            R.drawable.sk_kazka_o_rybake_i_rybke, R.drawable.sk_skazka_o_care_saltane,
            R.drawable.sk_rusalochka, R.drawable.sk_rapuncel,
            R.drawable.sk_princessa_na_goroshine, R.drawable.sk_moydodyr,
            R.drawable.sk_morozko, R.drawable.sk_masha,
            R.drawable.sk_malenkij_princ, R.drawable.sk_malenkij_muk,
            R.drawable.sk_kurochka, R.drawable.sk_koshkin_dom,
            R.drawable.sk_kolobok, R.drawable.sk_kasha_iz_topora,
            R.drawable.sk_karlik_nos, R.drawable.sk_ivan_krestyanskij_syn,
            R.drawable.sk_ilya_muromets, R.drawable.sk_gorshochek_kashi,
            R.drawable.sk_gadkij_utenok,0,
            R.drawable.sk_belosnezhka_luchshie_skazki, R.drawable.sk_aibolit};

    private void backgroundThreadProcessing() {
            ImageView iv = (ImageView) findViewById(R.id.story_Image);

            iv.setImageResource(imageAr[intent.getExtras().getInt("trackID")]);

            TextView tv = (TextView) findViewById(R.id.story_name);
            tv.setText(intent.getStringExtra("textR"));
        storyPlayer(intent.getExtras().getInt("trackID"));
    }

    MediaPlayer player;
    public void storyPlayer(int trackID){
        String filePath [] = {null,
                "deti-online.com_-_volshebnik-izumrudnogo-goroda.mp3",
                "deti-online.com_-_volk-i-semero-kozljat.mp3",
                "deti-online.com_-_vasilisa-prekrasnaja.mp3",
                "deti-online.com_-_carevna-ljagushka.mp3",
                "deti-online.com_-_teremok2.mp3",
                "deti-online.com_-_snezhnaja-koroleva-1.mp3",
                "deti-online.com_-_skazka-o-rybake-i-rybke.mp3",
                "deti-online.com_-_skazka-o-care-saltane.mp3",
                "deti-online.com_-_rusalochka.mp3",
                "deti-online.com_-_rapuncel.mp3",
                "deti-online.com_-_princessa-na-goroshine.mp3",
                "deti-online.com_-_moidodyr.mp3",
                "deti-online.com_-_morozko.mp3",
                "deti-online.com_-_masha-i-medved.mp3",
                "deti-online.com_-_malenkiy-princ.mp3",
                "deti-online.com_-_malenkii-muk.mp3",
                "deti-online.com_-_kurochka-rjaba.mp3",
                "deti-online.com_-_koshkin-dom.mp3",
                "deti-online.com_-_kolobok-3.mp3",
                "deti-online.com_-_kasha-iz-topora.mp3",
                "deti-online.com_-_karlik-nos-2.mp3",
                "deti-online.com_-_ivan-krestjanskii-syn-i-chudo-yudo.mp3",
                "deti-online.com_-_ilja-muromec-i-solovei-razboinik.mp3",
                "deti-online.com_-_gorshochek-kashi.mp3",
                "deti-online.com_-_gadkii-utenok.mp3",
                "deti-online.com_-_petushok-i-bobovoe-zernyshko.mp3",
                "deti-online.com_-_belosnezhka-i-sem-gnomov.mp3",
                "deti-online.com_-_aibolit.mp3"
                //,
                //"deti-online.com_-_12-mesjacev.mp3",
                //"deti-online.com_-_alenkii-cvetochek.mp3",
                //"deti-online.com_-_bremenskie-muzykanty.mp3",
                //"deti-online.com_-_cvetik-semicvetik.mp3",
                //"deti-online.com_-_dyuimovochka-2.mp3",
                //"deti-online.com_-_kurochka-rjaba-short.mp3",
                //"deti-online.com_-_rumpelshtilchen.mp3",
                //"deti-online.com_-_shelkunchik-i-myshinyi-korol.mp3",
                //"deti-online.com_-_skazka-o-myortvoi-carevne-i-semi-bogatyrjah.mp3",
                //"deti-online.com_-_zhivaya-voda.mp3"
        }; // 38 tracks
        try {
            player = new MediaPlayer();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource("http://tsimbalyukstudio.esy.es/"+filePath[trackID]);
            player.prepare();
            BackgroundSoundService.player.pause();
            player.start();
            Stories_Player.this.runOnUiThread(new Runnable()
            {
                public void run()
                {
                    text.setText("Аудио сказка");
                }
            });
        } catch (Exception e) {
            //Toast.makeText(this, "Ошибка, попробуйте позже!", Toast.LENGTH_SHORT).show();
            // TODO: handle exception
        }
    }

    int currentPos;
    public void storyPlay(View view){
        BackgroundSoundService.player.pause();
        try {
            if (!player.isPlaying()) {
                player.seekTo(currentPos);
                player.start();
            }
        }
        catch(Exception e ){}
    }

    public void storyPause(View view){
        currentPos = player.getCurrentPosition();
        player.pause();
        try {
        if(BackgroundSoundService.musicFlag == true){BackgroundSoundService.player.start();}
    }
        catch(Exception e ){}
    }

    public void storyMoveFuture(View view){
        int now = player.getCurrentPosition();
        now +=15000;
        try {
        player.seekTo(now);
    }
        catch(Exception e ){}

    }

    public void storyMoveBack(View view){
        int now = player.getCurrentPosition();
        now +=15000;
        try {
        player.seekTo(now);
    }
        catch(Exception e ){}
    }

    @Override
    public void onBackPressed() {
        try{
        player.stop();
        Intent intent = new Intent(this, Strories_menu.class);
        startActivity(intent);
        finish();
        }
        catch (Exception e){}
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
