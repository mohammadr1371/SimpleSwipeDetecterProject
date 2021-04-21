package com.example.simpleswipedialog;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.simpleswipedialog.ui.DialogLayout;


public class ZoomDialogFragment extends DialogFragment implements DialogLayout.OnUpDownMotionListener, View.OnTouchListener, GestureDetector.OnGestureListener {


    private String number;
    private DialogLayout dialogLayout;
    private SwipingDetector swipingDetector;
    private GestureDetector gestureDetector;

    public static ZoomDialogFragment newInstance(String number) {
        ZoomDialogFragment fragment = new ZoomDialogFragment();
        Bundle args = new Bundle();
        args.putString("number", number);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        number = getArguments().getString("number");
        gestureDetector = new GestureDetector(getActivity(),this);
    }

    @Override
    public void onStart() {
        super.onStart();

        final View decorView = getDialog().getWindow().getDecorView();

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(decorView,
                PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f),
                PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f),
                PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        scaleDown.setDuration(300);
        scaleDown.start();
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        dialogLayout = new DialogLayout(getActivity());
        dialogLayout.getTextView().setText(number);
        dialogLayout.setTouchCallback(ZoomDialogFragment.this);
        dialogLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(dialogLayout);
        return builder.create();
    }





    @Override
    public void onUpDownMotion() {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
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
            if (diffY > 1000) {
                final View decorView = getDialog()
                        .getWindow()
                        .getDecorView();

                ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(decorView,
                        PropertyValuesHolder.ofFloat("scaleX", 1.0f , 0.0f),
                        PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f),
                        PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f));
                scaleDown.setDuration(300);
                scaleDown.start();
                scaleDown.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        dismiss();
                    }

                    @Override
                    public void onAnimationStart(Animator animation) {
                    }
                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }
                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }
                });
                return true;
            }
        }
        return false;
    }
}