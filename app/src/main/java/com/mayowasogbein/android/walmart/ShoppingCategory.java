package com.mayowasogbein.android.walmart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ShoppingCategory extends AppCompatActivity implements View.OnClickListener {
    private TextView welcomeMessageTextView;
    private LinearLayout beauty, food, clothing, electronics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_category);

        String username = getIntent().getStringExtra("username");

        welcomeMessageTextView = findViewById(R.id.welcomeMessage);

        beauty = findViewById(R.id.beauty);
        beauty.setOnClickListener(this);
        food = findViewById(R.id.food);
        food.setOnClickListener(this);
        clothing = findViewById(R.id.clothing);
        clothing.setOnClickListener(this);
        electronics = findViewById(R.id.electronics);
        electronics.setOnClickListener(this);

        welcomeMessageTextView.setText("Welcome " + username);
    }

    @Override
    public void onClick(View view) {
        String categoryName = "";
        switch (view.getId()) {
            case R.id.beauty:
                categoryName = "Beauty";
                break;
            case R.id.food:
                categoryName = "Food";
                break;
            case R.id.clothing:
                categoryName = "Clothing";
                break;
            case R.id.electronics:
                categoryName = "Electronics";
                break;
        }
        Toast.makeText(getApplicationContext(), "You have chosen the "+ categoryName +" category of shopping", Toast.LENGTH_SHORT).show();

    }
}
