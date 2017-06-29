package com.tsimbalyukstudio.childbook;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Drag_drop_clothes_page extends Activity {
    float xStart;
    float yStart;
    float xEnd;
    float yEnd;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_drag_drop_clothes_page);
            findViewById(R.id.cl_kurtka).setOnTouchListener(new MyTouchListener());
            findViewById(R.id.cl_platie_one).setOnTouchListener(new MyTouchListener());
            findViewById(R.id.cl_platie_two).setOnTouchListener(new MyTouchListener());
            findViewById(R.id.cl_sviter).setOnTouchListener(new MyTouchListener());
            findViewById(R.id.cl_kurtka).setOnDragListener(new MyDragListener());
            findViewById(R.id.cl_platie_one).setOnDragListener(new MyDragListener());
            findViewById(R.id.cl_platie_two).setOnDragListener(new MyDragListener());
            findViewById(R.id.cl_sviter).setOnDragListener(new MyDragListener());

            xStart = findViewById(R.id.winter).getX();
            yStart = findViewById(R.id.winter).getY();
            xEnd = xStart + findViewById(R.id.winter).getWidth();
            yEnd = yStart + findViewById(R.id.winter).getHeight();
        }

        private final class MyTouchListener implements OnTouchListener {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                            view);
                    view.startDrag(data, shadowBuilder, view, 0);
                    view.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        }

        class MyDragListener implements OnDragListener {
            Drawable enterShape = getResources().getDrawable(
                    R.drawable.cl_kurtka);
            Drawable normalShape = getResources().getDrawable(R.color.mainBackground);

            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        v.setBackgroundDrawable(enterShape);
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        v.setBackgroundDrawable(normalShape);
                        break;
                    case DragEvent.ACTION_DROP:
                        // Dropped, reassign View to ViewGroup
                        if (findViewById(R.id.cl_kurtka).getY() >= yStart && findViewById(R.id.cl_kurtka).getY() <=yEnd)
                        {
                            if (findViewById(R.id.cl_kurtka).getX() >= xStart && findViewById(R.id.cl_kurtka).getX() <=xEnd){
                                Toast.makeText(Drag_drop_clothes_page.this, "OK!!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        View view = (View) event.getLocalState();
                        ViewGroup owner = (ViewGroup) view.getParent();
                        owner.removeView(view);
                        LinearLayout container = (LinearLayout) v;
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        //v.setBackgroundDrawable(normalShape);
                    default:
                        break;
                }
                return true;
            }
        }
    @Override
    protected void onPause() {
        BackgroundSoundService.player.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        BackgroundSoundService.player.start();
        super.onResume();
    }
    }
