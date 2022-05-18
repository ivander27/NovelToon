package com.example.noveltoon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.noveltoon.databinding.ActivityMainBinding;
import com.example.noveltoon.databinding.ActivityNavigationBinding;

public class MainActivity extends AppCompatActivity {

    private Button btnNextPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNextPage = findViewById(R.id.button_nextpage);
        //     btnNextPage.setOnClickListener(new View.OnClickListener() {
        //           @Override
        //           public void onClick(View view) {
        //               FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        //               fragmentTransaction.replace(R.id.welcome, new HomeFragment()).commit();
        //           }
        //       });

        btnNextPage.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), signin.class)); //sign in
        });
    }



}