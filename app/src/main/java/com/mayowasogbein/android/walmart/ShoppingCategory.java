package com.mayowasogbein.android.walmart;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
                Intent beautyIntent = new Intent(ShoppingCategory.this, BeautySpinner.class);
                startActivity(beautyIntent);
                break;
            case R.id.food:
                categoryName = "Food";
                Intent foodIntent = new Intent(ShoppingCategory.this, FoodListViewActivity.class);
                startActivity(foodIntent);
                break;
            case R.id.clothing:
                categoryName = "Clothing";
                Intent clothingIntent = new Intent(ShoppingCategory.this, ClothingListViewActivity.class);
                startActivity(clothingIntent);
                break;
            case R.id.electronics:
                categoryName = "Electronics";
                Intent electronicsIntent = new Intent(ShoppingCategory.this, ElectronicsListViewActivity.class);
                startActivity(electronicsIntent);
                break;
        }
        Toast.makeText(getApplicationContext(), "You have chosen the "+ categoryName +" category of shopping", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.categories, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.electronics:
                Intent electronicsIntent = new Intent(ShoppingCategory.this, ElectronicsListViewActivity.class);
                startActivity(electronicsIntent);
                return true;
            case R.id.clothing:
                Intent clothingIntent = new Intent(ShoppingCategory.this, ClothingListViewActivity.class);
                startActivity(clothingIntent);
                return true;
            case R.id.beauty:
                Intent beautyIntent = new Intent(ShoppingCategory.this, BeautySpinner.class);
                startActivity(beautyIntent);
                return true;
            case R.id.food:
                Intent foodIntent = new Intent(ShoppingCategory.this, FoodListViewActivity.class);
                startActivity(foodIntent);
                return true;
            case R.id.logout:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Logout");
                builder.setMessage("Do you want to Exit?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                AlertDialog.OnClickListener listener = new AlertDialog.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i == dialogInterface.BUTTON_POSITIVE) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                        else if(i == dialogInterface.BUTTON_NEGATIVE) {
                            dialogInterface.dismiss();
                        }
                    }
                };
                builder.setPositiveButton("Yes", listener);
                builder.setNegativeButton("No", listener);
                builder.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
