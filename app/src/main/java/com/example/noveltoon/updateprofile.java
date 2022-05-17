package com.example.noveltoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class updateprofile extends AppCompatActivity {
    private Button btnsaveprofile;
    private Button btnbackprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprofile);

        btnsaveprofile = findViewById(R.id.button_saveprofil);
        btnbackprofile = findViewById(R.id.button_backprofile);


        btnbackprofile.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), profile.class));
        });
    }
}