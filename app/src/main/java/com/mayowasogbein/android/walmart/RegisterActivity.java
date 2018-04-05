package com.mayowasogbein.android.walmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button createAccount;
    private EditText firstNameField, lastNameField, emailAddressField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        createAccount = findViewById(R.id.createAccountButton);
        firstNameField = findViewById(R.id.firstNameField);
        lastNameField = findViewById(R.id.lastNameField);
        emailAddressField = findViewById(R.id.emailAddressField);
        passwordField = findViewById(R.id.passwordField);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = emailAddressField.getText().toString();
                String password = passwordField.getText().toString();
                if(username.length() > 0 && password.length() > 0) {
                    User u = new User(username, password);
                    UserDAO.addUser(u);
                    Toast.makeText(getApplicationContext(), "Account created successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}