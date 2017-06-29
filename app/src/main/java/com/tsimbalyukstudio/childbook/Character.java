package com.tsimbalyukstudio.childbook;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;

public class Character {

    static boolean characterIsCreated = false;
    static String characterName = "BestBaby";
    static int characterImageId = 0;
    static int score;
    static int imageAr[] = {R.drawable.icon_baran, R.drawable.icon_cat, R.drawable.icon_chiken, R.drawable.icon_chiken_egg, R.drawable.icon_cow, R.drawable.icon_dog, R.drawable.icon_horse, R.drawable.icon_kozel, R.drawable.icon_mouse, R.drawable.icon_osel, R.drawable.icon_pig, R.drawable.icon_rabbit};
    static int compareLevel[] = {0, 0, 0, 0, 0, 0, 0, 0};


    Character() {

    }

    //SharedPreferences sPref;
/*
    void saveCharacter(Activity a) {
        sPref = a.getPreferences(MODE_APPEND);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putBoolean("characterIsCreated", characterIsCreated);
        ed.putString("characterName", characterName);
        ed.putInt("characterImageId", characterImageId);
        ed.putInt("score", score);
        int counter = 0;
        for (int x = 0; x < compareLevel.length; x++) {
            if (compareLevel[x] == 1) {
                counter++;
            }
        }
        ed.putInt("compareLevel", counter);
        ed.apply();
    }

    void loadCharacter(Activity a) {
        sPref = a.getPreferences(MODE_PRIVATE);
        boolean iscreated = sPref.getBoolean("characterIsCreated", false);
        characterIsCreated = iscreated;
        String name = sPref.getString("characterName", null);
        characterName = name;
        int imageId = sPref.getInt("characterImageId", 0);
        characterImageId = imageId;
        int score = sPref.getInt("score", 0);
        int counter = sPref.getInt("compareLevel", 0);
        while (counter != 0) {
            counter--;
            compareLevel[counter] = 1;
        }
    }
*/

    static File fileA;
    static File fileB;
    static File fileC;
    static File fileD;

    public static void writeFile(Activity a) {
        try {
            fileA = new File(a.getFilesDir() + File.separator + "dataA.txt");
            fileB = new File(a.getFilesDir() + File.separator + "dataB.txt");
            fileC = new File(a.getFilesDir() + File.separator + "dataC.txt");
            fileD = new File(a.getFilesDir() + File.separator + "dataD.txt");
            fileA.createNewFile();
            fileB.createNewFile();
            fileC.createNewFile();
            fileD.createNewFile();
            try {
                FileOutputStream outputStreamA = new FileOutputStream(fileA);
                FileOutputStream outputStreamB = new FileOutputStream(fileB);
                FileOutputStream outputStreamC = new FileOutputStream(fileC);
                FileOutputStream outputStreamD = new FileOutputStream(fileD);

                int counter = 0;
                for (int x = 0; x < compareLevel.length; x++) {
                    if (compareLevel[x] == 1) {
                        counter++;
                    }
                }

                outputStreamA.write((byte) (characterIsCreated ? 1 : 0 ));
                outputStreamB.write(characterName.getBytes());
                outputStreamC.write(characterImageId);
                outputStreamD.write(counter);
                outputStreamA.close();
                outputStreamB.close();
                outputStreamC.close();
                outputStreamD.close();

            } catch (Exception e) {
                Toast.makeText(a, "WRITE FAIL!", Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readFile(Activity a) {
        fileA = new File(a.getFilesDir() + File.separator + "dataA.txt");
        fileB = new File(a.getFilesDir() + File.separator + "dataB.txt");
        fileC = new File(a.getFilesDir() + File.separator + "dataC.txt");
        fileD = new File(a.getFilesDir() + File.separator + "dataD.txt");
        try {
            FileInputStream inputstreamA = new FileInputStream(fileA);
            FileInputStream inputstreamB = new FileInputStream(fileB);
            FileInputStream inputstreamC = new FileInputStream(fileC);
            FileInputStream inputstreamD = new FileInputStream(fileD);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();


            int vIn = inputstreamA.read();
            characterIsCreated = vIn!=0;

            int data;
            while ((data=inputstreamB.read())!=-1 ) {
                baos.write( data );
            }
            characterName = baos.toString();

            characterImageId = inputstreamC.read();
            int counter = inputstreamD.read();

            while (counter != 0) {
                counter--;
                compareLevel[counter] = 1;
            }
            //Toast.makeText(a, characterIsCreated+"", Toast.LENGTH_SHORT).show();
            //Toast.makeText(a, characterName+"", Toast.LENGTH_SHORT).show();
            //Toast.makeText(a, characterImageId+"", Toast.LENGTH_SHORT).show();
            //Toast.makeText(a, counter+"", Toast.LENGTH_SHORT).show();
            inputstreamA.close();
            inputstreamB.close();
            inputstreamC.close();
            inputstreamD.close();

        } catch (Exception e) {
        }
    }


}
