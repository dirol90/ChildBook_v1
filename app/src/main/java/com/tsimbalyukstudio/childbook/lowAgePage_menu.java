package com.tsimbalyukstudio.childbook;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class lowAgePage_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_low_age_page_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ADDS add = new ADDS(this);
        add.addBottomBanner(this);

    }

    public void first (View view){

        Intent intent = new Intent(this, lowAgePage_first.class);
        startActivity(intent);
        finish();
    }

    public void second (View view){

        Intent intent = new Intent(this, lowAgePage_second.class);
        startActivity(intent);
        finish();
    }

    public void third (View view){

        Intent intent = new Intent(this, lowAgePage_third.class);
        startActivity(intent);
        finish();
    }

    public void forth (View view){

        Intent intent = new Intent(this, ComparePage_one.class);
        startActivity(intent);
            finish();
    }

    public void fifth (View view){
        Intent intent = new Intent(this, Drag_drop_clothes_page.class);
        startActivity(intent);
        finish();
    }

    public void six (View view){

        Intent intent = new Intent(this, XylophonePage.class);
        startActivity(intent);
        finish();
    }

    public void seven (View view){

        Intent intent = new Intent(this, Ballon_Page.class);
        startActivity(intent);
        finish();
    }

    public void eight (View view){
        Intent intent = new Intent(this, Alphabet_page.class);
        startActivity(intent);
        finish();

    }

    public void nine (View view){
        Intent intent = new Intent(this, lowAgePage_colors.class);
        startActivity(intent);
        finish();

    }

    public void ten (View view){
        Intent intent = new Intent(this, lowAgePage_seasons.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Main_Page.class);
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
