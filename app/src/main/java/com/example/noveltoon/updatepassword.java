package com.example.noveltoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class updatepassword extends AppCompatActivity {
    private Button btnsavepassword;
    private Button btnbackpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepassword);

        btnsavepassword = findViewById(R.id.button_savepassword);
        btnbackpassword = findViewById(R.id.button_backpassword);


        btnbackpassword.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), profile.class));
        });
    }
}