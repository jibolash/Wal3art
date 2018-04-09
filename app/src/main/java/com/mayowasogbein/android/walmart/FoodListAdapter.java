package com.mayowasogbein.android.walmart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mayowasogbein.android.walmart.models.Food;

import java.util.List;

public class FoodListAdapter extends ArrayAdapter<Food> {

    public FoodListAdapter(Context context, int resource) {
        super(context, resource);
    }

    public FoodListAdapter(Context context, int resource, List<Food> foods) {
        super(context, resource, foods);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater layoutInflater;
            layoutInflater = LayoutInflater.from(getContext());
            v = layoutInflater.inflate(R.layout.food_list_row, null);
        }

        Food food = getItem(position);

        if (food != null) {
            TextView foodName = v.findViewById(R.id.foodName);
            TextView foodDescription = v.findViewById(R.id.foodDescription);

            if (foodName != null) {
                foodName.setText(food.getName());
            }

            if (foodDescription != null) {
                foodDescription.setText(food.getDescription());
            }
        }
        return v;
    }
}