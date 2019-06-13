package com.dylan.practiceapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dylan.practiceapp.util.Utils;
import com.dylan.practiceapp.view15.TouchView;



public class MainActivity extends AppCompatActivity {

    private TouchView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.drawBadge(this);
    }


}
