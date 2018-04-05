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
    private List<User> users = new ArrayList<>();
    private EditText usernameField, passwordField;
    private Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users.add(new User("bill@gmail.com", "clinton"));
        users.add(new User("barack@gmail.com", "obama"));
        users.add(new User("george@gmail.com", "bush"));
        users.add(new User("bola@gmail.com", "tinubu"));
        users.add(new User("nelson@gmail.com", "mandela"));

        signIn = findViewById(R.id.signInButton);
        usernameField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);

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

                for(User user : users){
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
    }
}
