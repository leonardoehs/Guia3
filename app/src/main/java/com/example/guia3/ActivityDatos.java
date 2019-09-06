package com.example.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("HS16-I04-001");
        }
    }
}
