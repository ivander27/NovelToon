package com.example.noveltoon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


public class profile extends AppCompatActivity {
    private Button btnupdateprofile;
    private Button btnupdatepassword;
    private TextView viewname,viewemail;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnupdateprofile = findViewById(R.id.button_Updateprofil);
        btnupdatepassword = findViewById(R.id.button_Updatepassword);
        viewname = findViewById(R.id.fieldnama);
        viewemail = findViewById(R.id.fieldemail);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        nama = firebaseAuth.getCurrentUser().getUid();

        firebaseFirestore.collection(nama)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(DocumentSnapshot documentSnapshot:task.getResult()){
                                viewname.setText(documentSnapshot.getString("email"));
                                viewemail.setText(documentSnapshot.getString("email"));
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("This",e.getMessage());
                    }
                });

        btnupdateprofile.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), updateprofile.class));
        });
        btnupdatepassword.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), updatepassword.class));
        });
    }
}