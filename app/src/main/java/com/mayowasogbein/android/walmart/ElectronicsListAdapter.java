package com.mayowasogbein.android.walmart;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mayowasogbein.android.walmart.models.Food;
import com.mayowasogbein.android.walmart.models.Product;

import java.util.List;

public class ElectronicsListAdapter extends ArrayAdapter<Product> {

    public ElectronicsListAdapter(Context context, int resource) {
        super(context, resource);
    }

    public ElectronicsListAdapter(Context context, int resource, List<Product> products) {
        super(context, resource, products);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater layoutInflater;
            layoutInflater = LayoutInflater.from(getContext());
            v = layoutInflater.inflate(R.layout.electronics_list_row, null);
        }

        Product product = getItem(position);

        if (product != null) {
            ImageView productImage = v.findViewById(R.id.productImage);
            TextView productName = v.findViewById(R.id.productName);
            TextView productPrice = v.findViewById(R.id.productPrice);
            TextView productColor = v.findViewById(R.id.productColor);

            if(productImage != null) {
                productImage.setImageResource(R.drawable.wal);
                if(product.getTitle().equals("Television")) {
                    productImage.setImageResource(R.drawable.tv);
                }
                else if(product.getTitle().equals("Phone")) {
                    productImage.setImageResource(R.drawable.phone);
                }
                else  if(product.getTitle().equals("Ear pods")) {
                    productImage.setImageResource(R.drawable.ear);
                }else if(product.getTitle().equals("Dre Beats")) {
                    productImage.setImageResource(R.drawable.beats);
                }else if(product.getTitle().equals("Macbook")) {
                    productImage.setImageResource(R.drawable.mac);
                }
            }

            if (productName != null) {
                productName.setText(product.getTitle());
            }

            if (productPrice != null) {
                productPrice.setText("Price : " + " $" + product.getPrice());
            }

            if(productColor != null) {
                productColor.setText("Color: " + product.getColor());
            }
        }
        return v;
    }
}