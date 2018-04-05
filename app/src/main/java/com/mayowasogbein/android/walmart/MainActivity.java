package com.mayowasogbein.android.walmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText usernameField, passwordField;
    private Button signIn;
    private Button createNewAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        signIn = findViewById(R.id.signInButton);
        usernameField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        createNewAccount = findViewById(R.id.createAccountButton);

        usernameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();

                for(User user : UserDAO.users){
                    if(user.getUsername().equals(username)) {
                        if(user.getPassword().equals(password)) {
                            Intent i = new Intent(MainActivity.this, ShoppingCategory.class);
                            i.putExtra("username", username);
                            startActivity(i);
                        }
                    }
                }
            }
        });

        createNewAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
