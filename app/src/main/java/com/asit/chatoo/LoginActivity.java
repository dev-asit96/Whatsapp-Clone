package com.asit.chatoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    MaterialEditText email, password;
    Button btn_login;

    TextView forgot_password;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        forgot_password = findViewById(R.id.forgot_password);
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
            }
        });

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*final ProgressDialog pd = new ProgressDialog(LoginActivity.this);
                pd.setMessage("Please wait...");
                pd.show();*/

                String txt_username = Objects.requireNonNull(email.getText()).toString();
                String txt_password = Objects.requireNonNull(password.getText()).toString();

                /* if (txt_username.equals("") || txt_password.equals("")) {*/
                //   Toast.makeText(LoginActivity.this, "All Fields required!", Toast.LENGTH_LONG).show();
                auth.signInWithEmailAndPassword(txt_username, txt_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        } else
                            Toast.makeText(LoginActivity.this, "Authentication Failed!", Toast.LENGTH_SHORT).show();

                    }
                });
            }

        });
    }
}