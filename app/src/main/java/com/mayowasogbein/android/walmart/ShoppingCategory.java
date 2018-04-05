package com.mayowasogbein.android.walmart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ShoppingCategory extends AppCompatActivity {
    private TextView welcomeMessageTextView;
    private LinearLayout beauty, food, clothing, electronics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_category);

        String username = getIntent().getStringExtra("username");

        welcomeMessageTextView = findViewById(R.id.welcomeMessage);

        beauty = findViewById(R.id.beauty);
        food = findViewById(R.id.food);
        clothing = findViewById(R.id.clothing);
        electronics = findViewById(R.id.electronics);

        welcomeMessageTextView.setText("Welcome " + username);


        beauty.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String categoryName = "";
                if(view.getId() == R.id.beauty) {
                    categoryName = "Beauty";
                }
                Toast.makeText(getApplicationContext(), "You have chosen the " + categoryName + " category of shopping", Toast.LENGTH_SHORT).show();
            }
        });

        food.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String categoryName = "";
                if(view.getId() == R.id.food) {
                    categoryName = "Food";
                }
                Toast.makeText(getApplicationContext(), "You have chosen the " + categoryName + " category of shopping", Toast.LENGTH_SHORT).show();

            }
        });

        clothing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String categoryName = "";
                if(view.getId() == R.id.clothing) {
                    categoryName = "Clothing";
                }
                Toast.makeText(getApplicationContext(), "You have chosen the " + categoryName + " category of shopping", Toast.LENGTH_SHORT).show();

            }
        });

        electronics.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String categoryName = "";
                if(view.getId() == R.id.electronics) {
                    categoryName = "Electronics";
                }
                Toast.makeText(getApplicationContext(), "You have chosen the " + categoryName + " category of shopping", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
