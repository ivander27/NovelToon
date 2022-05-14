package com.example.noveltoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class profile extends AppCompatActivity {
    private Button btnupdateprofile;
    private Button btnupdatepassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnupdateprofile = findViewById(R.id.button_Updateprofil);
        btnupdatepassword = findViewById(R.id.button_Updatepassword);

        btnupdateprofile.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), updateprofile.class));
        });
        btnupdatepassword.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), updatepassword.class));
        });
    }
}