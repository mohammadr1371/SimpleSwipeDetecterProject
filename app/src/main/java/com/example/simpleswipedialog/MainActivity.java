package com.example.simpleswipedialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.example.simpleswipedialog.ui.MainLayout;

public class MainActivity extends AppCompatActivity implements MainLayout.OnRowClickListeners {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        gestureDetector = new GestureDetector(this);
        MainLayout customLayout = new MainLayout(this);
        customLayout.setShortCallback(this);
        setContentView(customLayout);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        gestureDetector.onTouchEvent(event);
//        return super.onTouchEvent(event);
//    }

    @Override
    public void onRowShortClick(String number) {
        ZoomDialogFragment zoomDialogFragment = ZoomDialogFragment.newInstance(number);
        zoomDialogFragment.show(getSupportFragmentManager(), "zoom dialog fragment");
    }


//    @Override
//    public boolean onDown(MotionEvent e) {
//        return false;
//    }
//
//    @Override
//    public void onShowPress(MotionEvent e) {
//
//    }
//
//    @Override
//    public boolean onSingleTapUp(MotionEvent e) {
//        return false;
//    }
//
//    @Override
//    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        return false;
//    }
//
//    @Override
//    public void onLongPress(MotionEvent e) {
//
//    }
//
//    @Override
//    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        float diffX = e2.getX() - e1.getX();
//        float diffY = e2.getY() - e1.getY();
//        if (Math.abs(diffX) > Math.abs(diffY)) {
//            //is a horizontally swipe
//            return false;
//        } else {
//            //is a vertically swipe
//            if (diffY < -100) {
//                finish();
//                return true;
//            }
//        }
//        return false;
//    }
}