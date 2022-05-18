package com.example.noveltoon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.logout:
                        finish();
//                        startActivity(new Intent(getApplicationContext(), signin.class));
//                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}