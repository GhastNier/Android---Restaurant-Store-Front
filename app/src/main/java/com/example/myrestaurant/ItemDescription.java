package com.example.myrestaurant;

import static com.example.myrestaurant.MainActivity.cart;
import static com.example.myrestaurant.MainActivity.cartKey;
import static com.example.myrestaurant.MainActivity.itemNumber;
import static com.example.myrestaurant.MainActivity.items;
import static java.lang.String.valueOf;

import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.databinding.ItemDescriptionBinding;
import com.google.android.material.snackbar.Snackbar;

public class ItemDescription extends DialogFragment {
    public ItemDescriptionBinding binding;
    int canOrAdd;
    String itemName;
    double price;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = ItemDescriptionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDialog();
        SharedPreferences.Editor cartSetter = cart.edit();
        binding.addToCart.setOnClickListener(view1 -> {
            canOrAdd = 0;
            EditText editText = (EditText) binding.qty;
            String itemQtyEdit = editText.getText().toString();
            int itemQty = Integer.parseInt(itemQtyEdit);
            try {
                if (itemQty > 0) {
                    String current = String.valueOf(itemNumber);
                    double sum = price * itemQty;
                    Log.println(Log.INFO, "The sum of price * quantity ", valueOf(df.format(sum)));
                    Snackbar.make(getActivity().findViewById(R.id.snack_text), "You've added " + Integer.parseInt(valueOf(itemQty)) + " " + itemName + " to your Cart." +
                            "\nFor a total of " + df.format(sum), Snackbar.LENGTH_LONG).show();
                    cartSetter.putString(cartKey, df.format(Double.parseDouble(cart.getString(cartKey, "")) + sum)).apply();
                    items.put(current, current);
                    items.put(current, itemName);
                    items.put(current, String.valueOf(itemQty));
                    items.put(current, df.format(price));
                    items.put(current, df.format(sum));
                    Log.println(Log.INFO, "Item:", items.get(current).toString());
                    Log.println(Log.INFO,"All Items:",items.toString());
                    setID();
                } else {
                    Toast.makeText(getDialog().getContext(), "Sorry 0 isn't a valid quantity.", Toast.LENGTH_SHORT).show();
                }
            } catch (IllegalArgumentException e) {
                Toast.makeText(getDialog().getContext(), "Sorry 0 isn't a valid quantity.", Toast.LENGTH_SHORT).show();
            }
            closeDialog();
        });
        binding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canOrAdd = 1;
                closeDialog();
            }
        });
    }

    public void setDialog() {
        ImageView itemImg = (ImageView) binding.itemImg;
        TextView desc = (TextView) binding.itemDesc;
        TextView cost = (TextView) binding.itemCost;
        TextView title = (TextView) binding.itemName;
        Log.println(Log.INFO, "Sub Item Value: ", valueOf(MainActivity.subItem));
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

    public void closeDialog() {
        switch (MainActivity.item) {
            case 0:
                NavHostFragment.findNavController(ItemDescription.this)
                        .navigate(R.id.action_itemDescription_to_SecondFragment);
                if (canOrAdd == 1) {
                    Toast.makeText(getDialog().getContext(), "The item was not added to your cart.", Toast.LENGTH_LONG).show();
                    canOrAdd = 0;
                }
                break;
            case 1:
                NavHostFragment.findNavController(ItemDescription.this)
                        .navigate(R.id.action_itemDescription_to_steak);
                if (canOrAdd == 1) {
                    Toast.makeText(getDialog().getContext(), "The item was not added to your cart.", Toast.LENGTH_LONG).show();
                    canOrAdd = 0;
                }
                break;

            case 2:
                NavHostFragment.findNavController(ItemDescription.this)
                        .navigate(R.id.action_itemDescription_to_freshPasta);
                if (canOrAdd == 1) {
                    Toast.makeText(getDialog().getContext(), "The item was not added to your cart.", Toast.LENGTH_LONG).show();
                    canOrAdd = 0;
                }
                break;

            case 3:
                NavHostFragment.findNavController(ItemDescription.this)
                        .navigate(R.id.action_itemDescription_to_pizza);
                if (canOrAdd == 1) {
                    Toast.makeText(getDialog().getContext(), "The item was not added to your cart.", Toast.LENGTH_LONG).show();
                    canOrAdd = 0;
                }
                break;
            case 4:
                NavHostFragment.findNavController(ItemDescription.this)
                        .navigate(R.id.action_itemDescription_to_tiramisu);
                if (canOrAdd == 1) {
                    Toast.makeText(getDialog().getContext(), "The item was not added to your cart.", Toast.LENGTH_LONG).show();
                    canOrAdd = 0;
                }
                break;
            default:break;
        }
    }

    private String setID() {
        itemNumber++;
        return valueOf(itemNumber);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (getDialog() != null) {
            getDialog().dismiss();
        }
    }
}
