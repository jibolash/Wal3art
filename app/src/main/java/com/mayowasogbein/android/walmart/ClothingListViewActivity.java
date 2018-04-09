package com.mayowasogbein.android.walmart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mayowasogbein.android.walmart.models.Clothing;

import java.util.ArrayList;
import java.util.List;

public class ClothingListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing_list_view);

        Clothing[] listOfClothing = new Clothing[] {
                new Clothing("Jeans", "Very Durable"),
                new Clothing("Shirt", "For men and women"),
                new Clothing("Shoes", "Black and brown leather shoes"),
                new Clothing("Tie", "For coperate ocassions"),
                new Clothing("Socks", "In interesting colours")
        };

        ArrayAdapter adapter = new ArrayAdapter<Clothing>(this, R.layout.clothing_list_activity_listview, listOfClothing);

        ListView clothingListView = findViewById(R.id.clothingList);
        clothingListView.setAdapter(adapter);

        clothingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Clothing clothing = (Clothing) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), clothing.getDescription(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
