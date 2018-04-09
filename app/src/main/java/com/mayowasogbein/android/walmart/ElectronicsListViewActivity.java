package com.mayowasogbein.android.walmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mayowasogbein.android.walmart.FoodListAdapter;
import com.mayowasogbein.android.walmart.R;
import com.mayowasogbein.android.walmart.models.Food;
import com.mayowasogbein.android.walmart.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics_list_view);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Television", 140.0, "Black", "url", "114390", "Sony 32 inch tv"));
        products.add(new Product("Phone", 260.0, "Blue", "url", "283619", "LG end of line phone"));
        products.add(new Product("Ear pods", 320.0, "Yellow", "url", "472013", "High end earpiece"));
        products.add(new Product("Dre Beats", 120.0, "Pink", "url", "012844", "Super performance headphones"));
        products.add(new Product("Macbook", 2300.0, "Red", "url", "925175", "High capacity laptop"));

        ListView productListView = findViewById(R.id.productList);

        ArrayAdapter productAdapter = new ElectronicsListAdapter(this, R.layout.electronics_list_row, products);
        productListView.setAdapter(productAdapter);

        productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product = (Product) adapterView.getItemAtPosition(i);
//                Toast.makeText(getApplicationContext(), product.getDesc(), Toast.LENGTH_LONG).show();


                Intent productDetailsIntent = new Intent(ElectronicsListViewActivity.this, ProductDetailsActivity.class);
                productDetailsIntent.putExtra("product", product);
                startActivity(productDetailsIntent);
                }
        });
    }
}
