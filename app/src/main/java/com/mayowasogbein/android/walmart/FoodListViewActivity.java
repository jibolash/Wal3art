package com.mayowasogbein.android.walmart;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mayowasogbein.android.walmart.models.Clothing;
import com.mayowasogbein.android.walmart.models.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list_view);

        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Rice", "Carbs dense"));
        foodList.add(new Food("Beans", "Contains protein"));
        foodList.add(new Food("Tofu", "Highly proteinous"));
        foodList.add(new Food("Fruits", "For vitamins"));
        foodList.add( new Food("Salad", "All kinds of veggies"));

        ListView foodListView = findViewById(R.id.foodList);

//        ArrayAdapter foodAdapter = new ArrayAdapter<>(this, R.layout.food_list_activity_listview, foodList);
        ArrayAdapter foodAdapter = new FoodListAdapter(this, R.layout.food_list_row, foodList);
        foodListView.setAdapter(foodAdapter);

        foodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Food food = (Food) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), food.getDescription(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
