package com.example.noveltoon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    private EditText editName, editEmail, editPassword, editConfirmPassword;
    private Button btnRegister, btnBack;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editName = findViewById(R.id.nama);
        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.password);
        editConfirmPassword = findViewById(R.id.confirmpassword);
        btnRegister= findViewById(R.id.button_signup);
        btnBack = findViewById(R.id.button_back);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(signup.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);
        btnBack.setOnClickListener(v ->{
            finish();
        });
        btnRegister.setOnClickListener(v -> {
            if(editName.getText().length()>0 && editEmail.getText().length()>0 && editPassword.getText().length()>0 && editConfirmPassword.getText().length()>0){
                if(editPassword.getText().toString().equals(editConfirmPassword.getText().toString())){
                    register(editName.getText().toString(), editEmail.getText().toString(), editPassword.getText().toString());
                    startActivity(new Intent(getApplicationContext(), signin.class));
                }else{
                    Toast.makeText(getApplicationContext(), "Password tidak sesuai", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), "Silahkan isi semua data", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void register(String name, String email, String password){
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    User user = new User(name,email,password);

                    FirebaseDatabase.getInstance().getReference("User")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"You are successfully Registered", Toast.LENGTH_SHORT).show();
                            } else
                            {
                                Toast.makeText(getApplicationContext(),"You are not Registered! Try again",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(),"You are not Registered! Try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}