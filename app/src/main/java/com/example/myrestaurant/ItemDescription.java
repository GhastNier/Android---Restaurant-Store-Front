package com.example.myrestaurant;

import static com.example.myrestaurant.MainActivity.cart;
import static com.example.myrestaurant.MainActivity.cartKey;
import static com.example.myrestaurant.MainActivity.itemNumber;
import static com.example.myrestaurant.MainActivity.items;
import static java.lang.String.valueOf;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
        binding.addToCart.setOnClickListener(view0 -> {
            canOrAdd = 0;
            EditText editText = (EditText) binding.qty;
            int itemQty = Integer.parseInt(editText.getText().toString());
            try {
                if (itemQty > 0) {
                    String current = String.valueOf(itemNumber);
                    double sum = price * itemQty;
                    Log.println(Log.INFO, "The sum of price * quantity ", valueOf(df.format(sum)));
                    Snackbar.make(getActivity().findViewById(R.id.snack_text), "You've added " + Integer.parseInt(valueOf(itemQty)) + " " + itemName + " to your Cart." +
                            "\nFor a total of " + df.format(sum), Snackbar.LENGTH_LONG).show();
                    cartSetter.putString(cartKey, df.format(Double.parseDouble(cart.getString(cartKey, "")) + sum)).apply();
                    addItemToMulti(current, itemName, String.valueOf(itemQty), df.format(price), df.format(sum));

                    Log.println(Log.INFO, "Item:", items.get(current).toString());
                    Log.println(Log.INFO, "All Items:", items.toString());
                    setID();
                } else {
                    makeToastZero();
                }
            } catch (IllegalArgumentException e) {
                makeToastZero();
            }
            closeDialog();
        });
        binding.cancel.setOnClickListener(view1 -> {
            canOrAdd = 1;
            closeDialog();
        });
    }

    private void makeToastZero() {
        Toast.makeText(getDialog().getContext(), "Sorry 0 isn't a valid quantity.", Toast.LENGTH_SHORT).show();
    }

    private void addItemToMulti(String current, String itemName, String qty, String cost, String sum) {
        items.put(current, current);
        items.put(current, itemName);
        items.put(current, qty);
        items.put(current, cost);
        items.put(current, sum);
    }

    public void setDialog() {
        Log.println(Log.INFO, "Sub Item Value: ", valueOf(MainActivity.subItem));
        switch (MainActivity.item) {
            case 0:
                switch (MainActivity.subItem) {
                    case 0:
                        price = Double.parseDouble(getString(R.string.bruschetta_price));
                        itemName = getString(R.string.bruschetta);
                        dialogValues(itemName, getString(R.string.bruschetta_desc), getString(R.string.bruschetta_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.brus));
                        break;
                    case 1:
                        price = Double.parseDouble(getString(R.string.melon_price));
                        itemName = getString(R.string.melon);
                        dialogValues(itemName, getString(R.string.melon_desc), getString(R.string.melon_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.melon));
                        break;
                    case 2:
                        price = Double.parseDouble(getString(R.string.anti_cheese_price));
                        itemName = getString(R.string.anti_cheese);
                        dialogValues(itemName, getString(R.string.anti_cheese_desc), getString(R.string.anti_cheese_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.antecheese));
                        break;
                    case 3:
                        price = Double.parseDouble(getString(R.string.olives_price));
                        itemName = getString(R.string.olives);
                        dialogValues(itemName, getString(R.string.olives_desc), getString(R.string.olives_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.olives));
                        break;
                }
            case 1:
                switch (MainActivity.subItem) {
                    case 0:
                        price = Double.parseDouble(getString(R.string.bistecca_price));
                        itemName = getString(R.string.bistecca);
                        dialogValues(itemName, getString(R.string.bistecca_desc), getString(R.string.bistecca_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.bistecca));
                        break;
                    case 1:
                        price = Double.parseDouble(getString(R.string.tagliata_price));
                        itemName = getString(R.string.tagliata);
                        dialogValues(itemName, getString(R.string.tagliata_desc), getString(R.string.tagliata_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.tagliata));
                        break;
                    case 2:
                        price = Double.parseDouble(getString(R.string.palermo_price));
                        itemName = getString(R.string.palermo);
                        dialogValues(itemName, getString(R.string.palermo_desc), getString(R.string.palermo_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.palermo));
                        break;
                }
            case 2:
                switch (MainActivity.subItem) {
                    case 0:
                        price = Double.parseDouble(getString(R.string.trofie_price));
                        itemName = getString(R.string.trofie);
                        dialogValues(itemName, getString(R.string.trofie_desc), getString(R.string.trofie_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.trofie));
                        break;
                    case 1:
                        price = Double.parseDouble(getString(R.string.chitarra_price));
                        itemName = getString(R.string.chitarra);
                        dialogValues(itemName, getString(R.string.chitarra_desc), getString(R.string.chitarra_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.chitarra));
                        break;
                    case 2:
                        price = Double.parseDouble(getString(R.string.ravioli_price));
                        itemName = getString(R.string.ravioli);
                        dialogValues(itemName, getString(R.string.ravioli_desc), getString(R.string.ravioli_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.ravioli));
                        break;
                }
            case 3:
                switch (MainActivity.subItem) {
                    case 0:
                        price = Double.parseDouble(getString(R.string.napoletana_price));
                        itemName = getString(R.string.napoletana);
                        dialogValues(itemName, getString(R.string.napoletana_desc), getString(R.string.napoletana_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.napoletana));
                        break;
                    case 1:
                        price = Double.parseDouble(getString(R.string.alla_pala_price));
                        itemName = getString(R.string.alla_pala);
                        dialogValues(itemName, getString(R.string.alla_pala_desc), getString(R.string.alla_pala_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.alla_pala));
                        break;
                    case 2:
                        price = Double.parseDouble(getString(R.string.tonda_price));
                        itemName = getString(R.string.tonda);
                        dialogValues(itemName, getString(R.string.tonda_desc), getString(R.string.tonda_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.tonda));
                        break;
                    case 3:
                        price = Double.parseDouble(getString(R.string.taglio_price));
                        itemName = getString(R.string.taglio);
                        dialogValues(itemName, getString(R.string.taglio_desc), getString(R.string.taglio_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.taglio));
                        break;
                    case 4:
                        price = Double.parseDouble(getString(R.string.fritta_price));
                        itemName = getString(R.string.fritta);
                        dialogValues(itemName, getString(R.string.fritta_desc), getString(R.string.fritta_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.fritta));
                        break;
                    case 5:
                        price = Double.parseDouble(getString(R.string.padellino_price));
                        itemName = getString(R.string.padellino);
                        dialogValues(itemName, getString(R.string.padellino_desc), getString(R.string.padellino_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.padellino));
                        break;
                    case 6:
                        price = Double.parseDouble(getString(R.string.siciliana_price));
                        itemName = getString(R.string.siciliana);
                        dialogValues(itemName, getString(R.string.siciliana_desc), getString(R.string.siciliana_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.siciliana));
                        break;
                }
            case 4:
                switch (MainActivity.subItem) {
                    case 0:
                        price = Double.parseDouble(getString(R.string.classic_price));
                        itemName = getString(R.string.classic);
                        dialogValues(itemName, getString(R.string.classic_desc), getString(R.string.classic_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.classic));
                        break;
                    case 1:
                        price = Double.parseDouble(getString(R.string.deconst_price));
                        itemName = getString(R.string.deconst);
                        dialogValues(itemName, getString(R.string.deconst_desc), getString(R.string.deconst_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.deconst));
                        break;
                    case 2:
                        price = Double.parseDouble(getString(R.string.cheese_cake_price));
                        itemName = getString(R.string.cheese_cake);
                        dialogValues(itemName, getString(R.string.cheese_cake_desc), getString(R.string.cheese_cake_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.tiramisu_cheese));
                        break;
                    case 3:
                        price = Double.parseDouble(getString(R.string.gelato_price));
                        itemName = getString(R.string.gelato);
                        dialogValues(itemName, getString(R.string.gelato_desc), getString(R.string.gelato_price), ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.gelato));
                        break;
                }
        }
    }

    private void dialogValues(String itemName, String iDesc, String iPrice, Drawable image) {
        binding.itemImg.setImageDrawable(image);
        binding.itemName.setText(itemName);
        binding.itemDesc.setText(iDesc);
        binding.itemCost.setText(iPrice);
    }

    public void closeDialog() {
        switch (MainActivity.item) {
            case 0:
                navigateTo(R.id.action_itemDescription_to_SecondFragment);
                checkCancelOrAdd();
                break;
            case 1:
                navigateTo(R.id.action_itemDescription_to_steak);
                checkCancelOrAdd();
                break;

            case 2:
                navigateTo(R.id.action_itemDescription_to_freshPasta);
                checkCancelOrAdd();
                break;

            case 3:
                navigateTo(R.id.action_itemDescription_to_pizza);
                checkCancelOrAdd();
                break;
            case 4:
                navigateTo(R.id.action_itemDescription_to_tiramisu);
                checkCancelOrAdd();
                break;
            default:
                break;
        }
    }

    private void checkCancelOrAdd() {
        if (canOrAdd == 1) {
            Toast.makeText(getDialog().getContext(), "The item was not added to your cart.", Toast.LENGTH_LONG).show();
            canOrAdd = 0;
        }
    }

    private String setID() {
        itemNumber++;
        return valueOf(itemNumber);
    }

    private void navigateTo(int frag) {
        NavHostFragment.findNavController(ItemDescription.this)
                .navigate(frag);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (getDialog() != null) {
            getDialog().dismiss();
        }
    }
}
