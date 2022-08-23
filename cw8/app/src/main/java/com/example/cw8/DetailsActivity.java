package com.example.cw8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_details);
        super.onCreate(savedInstanceState);




        Bundle bundle = getIntent().getExtras();
        Item deliverItem = (Item) bundle.getSerializable("Item");

        TextView text = findViewById(R.id.textItem);
        TextView priceText = findViewById(R.id.priceItem);
        ImageView photo = findViewById(R.id.photoItem);


        text.setText(deliverItem.getItemName());
        priceText.setText(String.valueOf(deliverItem.getItemPrice()));
        photo.setImageResource(deliverItem.getItemImage());

        //Back
        ImageView backImg = findViewById(R.id.backImage);

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }
}