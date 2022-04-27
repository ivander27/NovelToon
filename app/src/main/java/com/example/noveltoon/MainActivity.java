package com.example.noveltoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnNextPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNextPage = findViewById(R.id.button_nextpage);

        btnNextPage.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), signin.class));
        });
    }
}