package com.example.noveltoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class updateprofile extends AppCompatActivity {
    private Button btnsaveprofile;
    private Button btnbackprofile;
    protected Cursor cursor;
    dbnoveltoon dbHelper;
    EditText text1, text2, text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprofile);

        dbHelper = new dbnoveltoon(this);
        text1 = (EditText) findViewById(R.id.fieldupdatenama);
        text2 = (EditText) findViewById(R.id.fieldupdateemail);
        text3 = (EditText) findViewById(R.id.fieldupdateumur);
        btnsaveprofile = findViewById(R.id.button_saveprofil);
        btnbackprofile = findViewById(R.id.button_backprofile);

        btnsaveprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into biodata(nama,email,umur) values('" +
                        text1.getText().toString() + "','" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "')");
                btnsaveprofile.setOnClickListener(v -> {
                    startActivity(new Intent(getApplicationContext(), profile.class));
                });
                btnbackprofile.setOnClickListener(v -> {
                    startActivity(new Intent(getApplicationContext(), profile.class));
                });
            }
        });
    }
}