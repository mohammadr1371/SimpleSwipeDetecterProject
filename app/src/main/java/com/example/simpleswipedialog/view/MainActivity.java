package com.example.simpleswipedialog.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;

import com.example.simpleswipedialog.ui.MainLayout;

public class MainActivity extends AppCompatActivity implements MainLayout.OnRowClickListeners {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainLayout mainLayout = new MainLayout(this);
        mainLayout.setShortCallback(this);
        setContentView(mainLayout);
    }


    @Override
    public void onRowShortClick(String number) {
        ShowingDialogFragment showingDialogFragment = ShowingDialogFragment.newInstance(number);
        showingDialogFragment.show(getSupportFragmentManager(), "showing dialog fragment");
    }
}