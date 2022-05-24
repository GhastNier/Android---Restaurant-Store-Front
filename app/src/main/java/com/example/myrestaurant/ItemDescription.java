package com.example.myrestaurant;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.databinding.FragmentSecondBinding;
import com.example.myrestaurant.databinding.ItemDescriptionBinding;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;

public class ItemDescription extends DialogFragment {

    double itemQty;
    String itemName;
    public ItemDescriptionBinding binding;
    double price;
    LayoutInflater inflater;
    AlertDialog.Builder builder;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = ItemDescriptionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDialog();
        binding.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart(view);

            }
        });
    }
    public void setDialog() {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.item_description,null);
        ImageView itemImg = (ImageView) binding.itemImg;
        TextView desc = (TextView) binding.itemDesc;
        TextView cost = (TextView) binding.itemCost;
        TextView title = (TextView) binding.itemName;
        itemName = "";
        Log.println(Log.INFO,"Sub Item Value: ", String.valueOf(MainActivity.subItem));
        switch (MainActivity.subItem) {
            case 0:
                price = Double.parseDouble(getString(R.string.bruschetta_price));
                itemName = getString(R.string.bruschetta);
                Log.println(Log.INFO, "All the values: ", "Price: " + getString(R.string.bruschetta_price) + " Desc: " + getString(R.string.bruschetta_desc) + " Cost: " + getString(R.string.bruschetta_price));
                itemImg.setImageDrawable(ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.brus));
                title.setText(getString(R.string.bruschetta));
                desc.setText(getString(R.string.bruschetta_desc));
                cost.setText(getString(R.string.bruschetta_price));
                break;
            case 1:
                price = Double.parseDouble(getString(R.string.melon_price));
                itemName = getString(R.string.melon);
                Log.println(Log.INFO, "All the values: ", "Price: " + getString(R.string.melon_price) + " Desc: " + getString(R.string.melon_desc) + " Cost: " + getString(R.string.melon_price));
                itemImg.setImageDrawable(ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.melon));
                title.setText(getString(R.string.melon));
                desc.setText(getString(R.string.melon_desc));
                cost.setText(getString(R.string.melon_price));
                break;
            case 2:
                price = Double.parseDouble(getString(R.string.anti_cheese_price));
                itemName = getString(R.string.anti_cheese);
                Log.println(Log.INFO, "All the values: ", "Price: " + getString(R.string.anti_cheese_price) + " Desc: " + getString(R.string.anti_cheese_desc) + " Cost: " + getString(R.string.anti_cheese_price));
                itemImg.setImageDrawable(ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.antecheese));
                title.setText(getString(R.string.anti_cheese));
                desc.setText(getString(R.string.anti_cheese_desc));
                cost.setText(getString(R.string.anti_cheese_price));
                break;
            case 3:
                price = Double.parseDouble(getString(R.string.olives_price));
                itemName = getString(R.string.olives);
                Log.println(Log.INFO, "All the values: ", "Price: " + getString(R.string.olives_price) + " Desc: " + getString(R.string.olives_desc) + " Cost: " + getString(R.string.olives_price));
                itemImg.setImageDrawable(ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.olives));
                title.setText(getString(R.string.olives));
                desc.setText(getString(R.string.olives_desc));
                cost.setText(getString(R.string.olives_price));
                break;
        }
    }
    

    public void addToCart(View view) {
        TextView editText = (TextView) view.findViewById(R.id.qty);
        String itemQtyEdit = editText.getText().toString();
        Log.println(Log.INFO,"Quantity: ", itemQtyEdit);
        double itemQty=0;
        int sum;
        try {
            sum = Integer.parseInt(String.valueOf(price * itemQty));
            Log.println(Log.INFO, "The sum of price * quantity ", String.valueOf(sum));
            Toast.makeText(this.getContext(), "You've added " + Integer.parseInt(String.valueOf(itemQty)) + " " + itemName + " to your Cart." +
                    "\n For a total of " + sum, Toast.LENGTH_LONG).show();
        } catch (NumberFormatException | NullPointerException e) {
            Toast.makeText(this.getContext(), "Sorry 0 isn't a valid quantity.", Toast.LENGTH_SHORT).show();
        }
    }


    public void cancelItem() {
        binding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (MainActivity.item) {
                    case 0:
                        NavHostFragment.findNavController(ItemDescription.this)
                                .navigate(R.id.action_itemDescription2_to_secondFragment2);
                        Snackbar.make(view, "The item was not added to your cart.", Snackbar.LENGTH_LONG).show();
                        break;
                    case 1:
                        NavHostFragment.findNavController(ItemDescription.this)
                                .navigate(R.id.action_itemDescription2_to_steak2);
                        Snackbar.make(view, "The item was not added to your cart.", Snackbar.LENGTH_LONG).show();
                        break;

                    case 2:
                        NavHostFragment.findNavController(ItemDescription.this)
                                .navigate(R.id.action_itemDescription2_to_freshPastaFrag);
                        Snackbar.make(view, "The item was not added to your cart.", Snackbar.LENGTH_LONG).show();
                        break;

                    case 3:
                        NavHostFragment.findNavController(ItemDescription.this)
                                .navigate(R.id.action_itemDescription2_to_pizza2);
                        Snackbar.make(view, "The item was not added to your cart.", Snackbar.LENGTH_LONG).show();
                        break;
                    case 4:
                        NavHostFragment.findNavController(ItemDescription.this)
                                .navigate(R.id.action_itemDescription2_to_tiramisu2);
                        Snackbar.make(view, "The item was not added to your cart.", Snackbar.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        if (getDialog() != null) {
            getDialog().dismiss();
        }
    }
}
