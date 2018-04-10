package com.mayowasogbein.android.walmart;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        signIn = findViewById(R.id.signInButton);
        usernameField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        createNewAccount = findViewById(R.id.createAccountButton);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        usernameField.setText(sharedpreferences.getString(USERNAME, ""));
        passwordField.setText(sharedpreferences.getString(PASSWORD, ""));

        signIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this, ShoppingCategory.class);
//                i.putExtra("username", "test@gmail.com");
//                startActivity(i);

                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();
                UserDAO.loadUsers();
                for(User user : UserDAO.users){
                    if(user.getUsername().equals(username)) {
                        if(user.getPassword().equals(password)) {

                            SharedPreferences.Editor editor = sharedpreferences.edit();

                            editor.putString(USERNAME, username);
                            editor.putString(PASSWORD, password);
                            editor.commit();

                            Intent categoryIntent = new Intent(MainActivity.this, ShoppingCategory.class);
                            categoryIntent.putExtra("username", username);
                            startActivity(categoryIntent);
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
