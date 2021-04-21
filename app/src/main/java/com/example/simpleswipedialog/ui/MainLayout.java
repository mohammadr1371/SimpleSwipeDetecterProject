package com.example.simpleswipedialog.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainLayout extends FrameLayout {

    private OnRowClickListeners shortCallback;
    private Context context;
    private TextView number1;
    private TextView number2;
    private TextView number3;
    private TextView number4;

    public void setShortCallback(OnRowClickListeners shortCallback) {
        this.shortCallback = shortCallback;
    }


    public MainLayout(Context context) {
        super(context);

        this.context = context;
        setBackgroundColor(Color.WHITE);
        initWidgets(context);
        setListeners();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int rootWidth = right - left;
        int rootHeight = bottom - top;
        number1.layout(rootWidth/2 - number1.getWidth()/2, 16, rootWidth/2 + number1.getWidth()/2, 16 + number1.getHeight());
        number2.layout(rootWidth/2 - number2.getWidth()/2, 32 + number1.getHeight(), rootWidth/2 + number2.getWidth()/2, 32 + number1.getHeight() + number2.getHeight());
        number3.layout(rootWidth/2 - number3.getWidth()/2, 48 + number1.getHeight() + number2.getHeight(),
                rootWidth/2 + number3.getWidth()/2, 64 + number1.getHeight() + number2.getHeight() + number3.getHeight());
        number4.layout(rootWidth/2 - number4.getWidth()/2, 64 + number1.getHeight() + number2.getHeight() + number3.getHeight(),
                rootWidth/2 + number4.getWidth()/2, 64 + number1.getHeight() + number2.getHeight() + number3.getHeight() + number4.getHeight());

    }

    private void initWidgets(Context context) {
        number1 = new TextView(context);
        number2 = new TextView(context);
        number3 = new TextView(context);
        number4 = new TextView(context);


        number1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 64f);
        number1.setTextColor(Color.BLUE);
        number1.setGravity(Gravity.CENTER);
        number1.setText("1");
        number1.setBackgroundColor(Color.LTGRAY);

        addView(number1, createLayoutParams(400, 400));

        number2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 64f);
        number2.setTextColor(Color.BLUE);
        number2.setGravity(Gravity.CENTER);
        number2.setText("2");
        number2.setBackgroundColor(Color.LTGRAY);

        addView(number2, createLayoutParams(400, 400));

        number3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 64f);
        number3.setTextColor(Color.BLUE);
        number3.setGravity(Gravity.CENTER);
        number3.setText("3");
        number3.setBackgroundColor(Color.LTGRAY);

        addView(number3, createLayoutParams(400, 400));

        number4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 64f);
        number4.setTextColor(Color.BLUE);
        number4.setGravity(Gravity.CENTER);
        number4.setText("4");
        number4.setBackgroundColor(Color.LTGRAY);

        addView(number4, createLayoutParams(400, 400));
    }

    private LayoutParams createLayoutParams(int width, int height) {
        LayoutParams layoutParams = new LayoutParams(width, height);
        return layoutParams;
    }

    private void setListeners (){
        number1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCallback.onRowShortClick(number1.getText().toString());
            }
        });
        number2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCallback.onRowShortClick(number2.getText().toString());
            }
        });
        number3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCallback.onRowShortClick(number3.getText().toString());
            }
        });
        number4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCallback.onRowShortClick(number4.getText().toString());
            }
        });
    }

    public interface OnRowClickListeners{
        void onRowShortClick(String number);
    }
}
