package com.example.noveltoon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signin extends AppCompatActivity {
    private EditText editEmail, editPassword;
    private Button btnsignin, btnsignup;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.password);
        btnsignin = findViewById(R.id.button_signin);
        btnsignup = findViewById(R.id.button_register);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(signin.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);

        btnsignup.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), signup.class));
        });
        btnsignin.setOnClickListener(v ->{
            if(editEmail.getText().length()>0 && editPassword.getText().length()>0){
                login(editEmail.getText().toString(), editPassword.getText().toString());
            }else{
                Toast.makeText(getApplicationContext(), "Silahkan isi semua data", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() && task.getResult()!=null){
                    if(task.getResult().getUser()!=null){
                        reload();
                    }else{
                        Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void reload(){
        startActivity(new Intent(getApplicationContext(), home.class));
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }
}