package com.example.simpleswipedialog.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;

public class DialogLayout extends FrameLayout implements GestureDetector.OnGestureListener {

    private TextView textView;
    private GestureDetector gestureDetector;


    public TextView getTextView() {
        return textView;
    }


    public DialogLayout(@NonNull Context context) {
        super(context);
        gestureDetector = new GestureDetector(this);
        textView = new TextView(context);
        textView.setTextSize(100f);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(Color.RED);
        textView.setTextColor(Color.WHITE);
        addView(textView, 1000, 2000);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float diffX = e2.getX() - e1.getX();
        float diffY = e2.getY() - e1.getY();
        if (Math.abs(diffX) > Math.abs(diffY)) {
            //is a horizontally swipe
            return false;
        } else {
            //is a vertically swipe
            if (diffY > 100) {
                return true;
            }
        }
        return false;
    }

}
