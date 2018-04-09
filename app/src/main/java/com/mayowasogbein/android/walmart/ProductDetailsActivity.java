package com.mayowasogbein.android.walmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mayowasogbein.android.walmart.models.Product;

public class ProductDetailsActivity extends AppCompatActivity {
    private ImageView productImage;
    private TextView productName, productColor, productId, productDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        productImage = findViewById(R.id.productImage);
        productName = findViewById(R.id.productName);
        productColor = findViewById(R.id.productColor);
        productId = findViewById(R.id.productId);
        productDescription = findViewById(R.id.productDescription);

        Product p = (Product) getIntent().getSerializableExtra("product");

        if(p.getTitle().equals("Television")) {
            productImage.setImageResource(R.drawable.tv);
        }
        else if(p.getTitle().equals("Phone")) {
            productImage.setImageResource(R.drawable.phone);
        }
        else  if(p.getTitle().equals("Ear pods")) {
            productImage.setImageResource(R.drawable.ear);
        }else if(p.getTitle().equals("Dre Beats")) {
            productImage.setImageResource(R.drawable.beats);
        }else if(p.getTitle().equals("Macbook")) {
            productImage.setImageResource(R.drawable.mac);
        }

        productName.setText(p.getTitle());
        productColor.setText("Color : " + p.getColor());
        productId.setText("Walmart #: " + p.getItemid());
        productDescription.setText(p.getDesc());
    }
}
