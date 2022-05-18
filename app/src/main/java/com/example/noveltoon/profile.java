package com.example.noveltoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;



public class profile extends AppCompatActivity {
    private Button btnupdateprofile;
    private TextView viewname,viewemail,viewumur;
    protected Cursor cursor;
    dbnoveltoon dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        dbHelper = new dbnoveltoon(this);
        btnupdateprofile = findViewById(R.id.button_Updateprofil);
        viewname = (TextView) findViewById(R.id.fieldnama);
        viewemail = (TextView) findViewById(R.id.fieldemail);
        viewumur = (TextView) findViewById(R.id.fieldUmur);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            cursor.moveToPosition(0);
            viewname.setText(cursor.getString(0).toString());
            viewemail.setText(cursor.getString(1).toString());
            viewumur.setText(cursor.getString(2).toString());
        }
        btnupdateprofile.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), updateprofile.class));
        });
    }
}