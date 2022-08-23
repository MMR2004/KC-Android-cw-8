package com.example.cw8;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ShopAdapter extends ArrayAdapter {

    List<Item> ShopItemList;



    public ShopAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        ShopItemList = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlist, parent, false);

        Item currentItems = ShopItemList.get(position);


        TextView ItemName = view.findViewById(R.id.itemName);
        TextView ItemPrice = view.findViewById(R.id.itemPrice);
        ImageView ItemImage = view.findViewById(R.id.itemImage);

        ItemName.setText(currentItems.getItemName());
        ItemPrice.setText(String.valueOf(currentItems.getItemPrice()));
        ItemImage.setImageResource(currentItems.getItemImage());


        //Deleting Image
        ImageView delete = view.findViewById(R.id.delete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog;
                dialog = new AlertDialog.Builder(getContext());
                dialog.setCancelable(false);
                dialog.setTitle("You wont to delete that?");
                dialog.setMessage("Are you sure ???????");
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ShopItemList.remove(position);
                        notifyDataSetChanged();
                    }
                })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                final AlertDialog alert = dialog.create();
                alert.show();
            }
        });

        return view;
    }



}
