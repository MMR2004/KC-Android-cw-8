package com.example.cw8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Item> itemArrayList = new ArrayList<>();

    private Snackbar snackbar;
    private RelativeLayout relativeLayout;
    private ImageView show_snackbar_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.relativeLayout);
        show_snackbar_btn = findViewById(R.id.showButton);

        show_snackbar_btn.setOnClickListener(view -> {
            Snackbar.make(relativeLayout, "This is Snackbar !", Snackbar.LENGTH_LONG)
                    .setAction("Close", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        }
                    })
                    .setActionTextColor(getResources().getColor(android.R.color.holo_blue_light))
                    .show();
        });



        View parentLayout = findViewById(android.R.id.content);
        Snackbar.make(parentLayout, "Hello to my appShop", Snackbar.LENGTH_LONG)
                .setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                })
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                .show();






        ListView listView = findViewById(R.id.listListView);

        TextView nameItem = findViewById(R.id.itemName);
        TextView priceItem = findViewById(R.id.itemPrice);
        ImageView imageItem = findViewById(R.id.itemImage);


        Item cheese = new Item("Cheese", R.drawable.cheese, 2.0);
        Item chocolate = new Item("Chocolate", R.drawable.chocolate, 5.0);
        Item coffee = new Item("Coffee", R.drawable.coffee, 7.0);
        Item donut = new Item("Donut", R.drawable.donut, 3.0);
        Item fries = new Item("Fries", R.drawable.fries, 5.0);
        Item honey = new Item("Honey", R.drawable.honey, 15.0);

        itemArrayList.add(cheese);
        itemArrayList.add(chocolate);
        itemArrayList.add(coffee);
        itemArrayList.add(donut);
        itemArrayList.add(fries);
        itemArrayList.add(honey);



        ShopAdapter p = new ShopAdapter(this, 0, itemArrayList);

        ListView itemListview = findViewById(R.id.listListView);

        itemListview.setAdapter(p);

        itemListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item currentItems = itemArrayList.get(i);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Item", currentItems);
                startActivity(intent);

            }
        });










    }
}