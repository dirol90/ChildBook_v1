package com.tsimbalyukstudio.childbook;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.lang.*;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

public class ComparePage_two extends AppCompatActivity {

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_page_two);
        setRequestedOrientation(SCREEN_ORIENTATION_LANDSCAPE);

        ADDS add = new ADDS(this);
        add.addNonSkipVideo(this);

        if (Character.compareLevel[1]==1){
            next();
        }
        b = (Button) findViewById(R.id.next);
        b.setEnabled(false);
        b.setBackgroundColor(getResources().getColor(R.color.invisible));
    }

    int isOpen;
    int[] buttons = {R.id.comp2_b1_1, R.id.comp2_b2_1, R.id.comp2_b3_1, R.id.comp2_b4_1, R.id.comp2_b5_1, R.id.comp2_b6_1, R.id.comp2_b1_2, R.id.comp2_b2_2, R.id.comp2_b3_2, R.id.comp2_b4_2, R.id.comp2_b5_2, R.id.comp2_b6_2};
    boolean[] isCheckedButtons = new boolean[12];

    public void count(View view) {
        TextView tv = (TextView) findViewById(R.id.compareCounterText);
        int temp = view.getId();
        for (int x = 0; x < buttons.length; x++) {
            if (buttons[x] == temp && !isCheckedButtons[x]) {
                isOpen++;
                Button b = (Button) findViewById(buttons[x]);
                b.setBackgroundResource(R.drawable.correct);
                isCheckedButtons[x] = true;
                try {
                    isCheckedButtons[x + 6] = true;
                    Button bt = (Button) findViewById(buttons[x+6]);
                    bt.setBackgroundResource(R.drawable.correct);
                } catch (Exception e) {
                }
                try {
                    isCheckedButtons[x - 6] = true;
                    Button bt = (Button) findViewById(buttons[x-6]);
                    bt.setBackgroundResource(R.drawable.correct);
                } catch (Exception e) {
                }
                tv.setText("Найдено: "+isOpen+"/6");
            }

        }
        if(isOpen == 6) {b.setEnabled(true);
            b.setBackgroundResource(R.drawable.back);}
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, lowAgePage_menu.class);
        startActivity(intent);
        finish();
    }

    public void back(View view){
        onBackPressed();
    }

    public void next(View view){
        Intent intent = new Intent(this, ComparePage_three.class);
        Character.compareLevel[1] = 1;
        startActivity(intent);
        finish();
    }

    public void next(){
        Intent intent = new Intent(this, ComparePage_three.class);
        Character.compareLevel[1] = 1;
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
}
