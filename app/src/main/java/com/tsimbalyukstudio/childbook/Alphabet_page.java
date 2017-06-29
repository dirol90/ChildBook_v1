package com.tsimbalyukstudio.childbook;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class Alphabet_page extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Integer [] alphabet_ar = {R.drawable.alphabet_1,  R.drawable.alphabet_3, R.drawable.alphabet_5,  R.drawable.alphabet_7,  R.drawable.alphabet_9,  R.drawable.alphabet_11,  R.drawable.alphabet_13,  R.drawable.alphabet_15,  R.drawable.alphabet_17,  R.drawable.alphabet_19,  R.drawable.alphabet_21,  R.drawable.alphabet_23,  R.drawable.alphabet_25,R.drawable.alphabet_27,R.drawable.alphabet_29,R.drawable.alphabet_31,R.drawable.alphabet_33};
    private Integer [] alphabet_arSec = {R.drawable.alphabet_2, R.drawable.alphabet_4, R.drawable.alphabet_6, R.drawable.alphabet_8, R.drawable.alphabet_10, R.drawable.alphabet_12, R.drawable.alphabet_14, R.drawable.alphabet_16, R.drawable.alphabet_18, R.drawable.alphabet_20, R.drawable.alphabet_22, R.drawable.alphabet_24, R.drawable.alphabet_26,R.drawable.alphabet_28,R.drawable.alphabet_30, R.drawable.alphabet_32,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ADDS add = new ADDS(this);
        add.addBottomBanner(this);
        //ADDS.addNonSkipVideo(this);

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mRecyclerView = (RecyclerView) findViewById(R.id.gvMain);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(alphabet_ar);
        mRecyclerView.setAdapter(mAdapter);
    }

    VoiseSound vs = new VoiseSound();
    int alphabet[] = {R.raw.let1, R.raw.let2, R.raw.let3, R.raw.let4,
            R.raw.let5, R.raw.let6, R.raw.let7, R.raw.let8,
            R.raw.let9, R.raw.let10, R.raw.let11, R.raw.let12,
            R.raw.let13, R.raw.let14, R.raw.let15, R.raw.let16,
            R.raw.let16_1, R.raw.let17, R.raw.let18, R.raw.let19,
            R.raw.let20, R.raw.let21, R.raw.let22, R.raw.let23,
            R.raw.let24, R.raw.let25, R.raw.let26, R.raw.let27,
            R.raw.let28, R.raw.let29, R.raw.let30, R.raw.let31,
            R.raw.let32};
    public void playAlphabet(View v) {
        BackgroundSoundService.player.setVolume(0,0);
        vs.changeTrack(Alphabet_page.this, alphabet[(int)v.getTag()]);
        //Toast.makeText(this, v.getTag()+"HELLO", Toast.LENGTH_SHORT).show();
    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        public  Integer[] mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder

        public  class ViewHolder extends RecyclerView.ViewHolder {

            // each data item is just a string in this case

            public ImageView mImageView;
            public ImageView mImageViewTwo;
            public ViewHolder(View v) {
                super(v);
                mImageView = (ImageView) v.findViewById(R.id.alphabet_image);
                mImageViewTwo = (ImageView) v.findViewById(R.id.alphabet_image_two);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(Integer[] myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.alphabet_layout, parent, false);
            // set the view's size, margins, paddings and layout parameters
            //v.setLayoutParams(new RecyclerView.LayoutParams(width, height/2));
            //v.setMinimumWidth(width);
            //v.setMinimumHeight(height/3);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.mImageView.setImageResource(alphabet_ar[position]);
            holder.mImageViewTwo.setImageResource(alphabet_arSec[position]);
            if (position == 0){
                holder.mImageView.setTag(position);
                holder.mImageViewTwo.setTag(position+1);
            } else {
                holder.mImageView.setTag(position*2);
                holder.mImageViewTwo.setTag(position*2+1);
            }
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.length;
        }
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

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(this, lowAgePage_menu.class);
        startActivity(intent);
    }

    public void back(View view) {
        onBackPressed();
    }

}