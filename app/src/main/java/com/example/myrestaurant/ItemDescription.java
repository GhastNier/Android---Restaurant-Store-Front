package com.example.myrestaurant;

import static com.example.myrestaurant.GetterAndSetter.*;
import static com.example.myrestaurant.MainActivity.*;
import static java.lang.String.valueOf;

import android.content.SharedPreferences;
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
    public ItemDescriptionBinding idb;
    int canOrAdd;
    double price;
    public static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        idb = ItemDescriptionBinding.inflate(inflater, container, false);
        return idb.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDialog(getItem(), getSubItem());
        idb.addToCart.setOnClickListener(view0 -> {
            canOrAdd = 0;
            cartSetter();
        });
        idb.cancel.setOnClickListener(view1 -> {
            canOrAdd = 1;
            closeDialog();
        });
    }

    private void makeToastZero() {
        try {
            Toast.makeText(getDialog().getContext(), "Sorry 0 isn't a valid quantity.", Toast.LENGTH_SHORT).show();
        } catch (NullPointerException e){
            Log.println(Log.INFO,"Make Toast Zero =>", e.toString());
        }
    }
    public void setDialog(String item, int subItem) {
        switch (item) {
            case "anti": {
                antiPastoSubItem(subItem);
            }
            case "steak": {
                steakSubItem(subItem);
            }
            case "pasta": {
                freshPastaSubItem(subItem);
            }
            case "pizza": {
                pizzaSubItem(subItem);
            }
            case "dessert": {
                tiramisuSubItem(subItem);
            }
            default: {
                break;
            }
        }
    }

    private void antiPastoSubItem(int subItem) {
        switch (subItem) {
            case 10: {
                dialogValues(getString(R.string.bruschetta), getString(R.string.bruschetta_desc), getString(R.string.bruschetta_price), R.drawable.brus);
                break;
            }
            case 11: {
                dialogValues(getString(R.string.melon), getString(R.string.melon_desc), getString(R.string.melon_price), R.drawable.melon);
                break;
            }
            case 12: {
                dialogValues(getString(R.string.anti_cheese), getString(R.string.anti_cheese_desc), getString(R.string.anti_cheese_price), R.drawable.antecheese);
                break;
            }
            case 13: {
                dialogValues(getString(R.string.olives), getString(R.string.olives_desc), getString(R.string.olives_price), R.drawable.olives);
                break;
            }
            default: {
                break;
            }
        }
    }

    private void steakSubItem(int subItem) {
        switch (subItem) {
            case 20: {
                dialogValues(getString(R.string.bistecca), getString(R.string.bistecca_desc), getString(R.string.bistecca_price), R.drawable.bistecca);
                break;
            }
            case 21: {
                dialogValues(getString(R.string.tagliata), getString(R.string.tagliata_desc), getString(R.string.tagliata_price), R.drawable.tagliata);
                break;
            }
            case 22: {
                dialogValues(getString(R.string.palermo), getString(R.string.palermo_desc), getString(R.string.palermo_price), R.drawable.palermo);
                break;
            }
            default: {
                break;
            }
        }
    }

    private void freshPastaSubItem(int subItem) {
        switch (subItem) {
            case 30: {
                dialogValues(getString(R.string.trofie), getString(R.string.trofie_desc), getString(R.string.trofie_price), R.drawable.trofie);
                break;
            }
            case 31: {
                dialogValues(getString(R.string.chitarra), getString(R.string.chitarra_desc), getString(R.string.chitarra_price), R.drawable.chitarra);
                break;
            }
            case 32: {
                dialogValues(getString(R.string.ravioli), getString(R.string.ravioli_desc), getString(R.string.ravioli_price), R.drawable.ravioli);
                break;
            }
            default: {
                break;
            }
        }
    }

    private void pizzaSubItem(int subItem) {
        switch (subItem) {
            case 40: {
                dialogValues(getString(R.string.napoletana), getString(R.string.napoletana_desc), getString(R.string.napoletana_price), R.drawable.napoletana);
                break;
            }
            case 41: {
                dialogValues(getString(R.string.alla_pala), getString(R.string.alla_pala_desc), getString(R.string.alla_pala_price), R.drawable.alla_pala);
                break;
            }
            case 42: {
                dialogValues(getString(R.string.tonda), getString(R.string.tonda_desc), getString(R.string.tonda_price), R.drawable.tonda);
                break;
            }
            case 43: {
                dialogValues(getString(R.string.taglio), getString(R.string.taglio_desc), getString(R.string.taglio_price), R.drawable.taglio);
                break;
            }
            case 44: {
                dialogValues(getString(R.string.fritta), getString(R.string.fritta_desc), getString(R.string.fritta_price), R.drawable.fritta);
                break;
            }
            case 45: {
                dialogValues(getString(R.string.padellino), getString(R.string.padellino_desc), getString(R.string.padellino_price), R.drawable.padellino);
                break;
            }
            case 46: {
                dialogValues(getString(R.string.siciliana), getString(R.string.siciliana_desc), getString(R.string.siciliana_price), R.drawable.siciliana);
                break;
            }
            default: {
                break;
            }
        }
    }

    private void tiramisuSubItem(int subItem) {
        switch (subItem) {
            case 50: {
                dialogValues(getString(R.string.classic), getString(R.string.classic_desc), getString(R.string.classic_price), R.drawable.classic);
                break;
            }
            case 51: {
                dialogValues(getString(R.string.deconst), getString(R.string.deconst_desc), getString(R.string.deconst_price), R.drawable.deconst);
                break;
            }
            case 52: {
                dialogValues(getString(R.string.cheese_cake), getString(R.string.cheese_cake_desc), getString(R.string.cheese_cake_price), R.drawable.tiramisu_cheese);
                break;
            }
            case 53: {
                dialogValues(getString(R.string.gelato), getString(R.string.gelato_desc), getString(R.string.gelato_price), R.drawable.gelato);
                break;
            }
            default: {
                break;
            }
        }
    }

    private void dialogValues(String itemName, String iDesc, String iPrice, int image) {
        price = Double.parseDouble(iPrice);
        idb.itemImg.setImageDrawable(ContextCompat.getDrawable(idb.getRoot().getContext(), image));
        idb.itemName.setText(itemName);
        idb.itemDesc.setText(iDesc);
        idb.itemCost.setText(iPrice);
    }

    public void closeDialog() {
        navigateTo(R.id.action_itemDescription_pop);
        setSubItem(-1);

        checkCancelOrAdd();
    }


    private void checkCancelOrAdd() {
        if (canOrAdd == 1) {
            Toast.makeText(getDialog().getContext(), "The item was not added to your cart.", Toast.LENGTH_LONG).show();
            canOrAdd = 0;
        }
    }

    private String setID() {
        setItemNumber(getItemNumber()+1);
        return valueOf(getItemNumber());
    }

    private void navigateTo(int frag) {
        NavHostFragment.findNavController(ItemDescription.this)
                .navigate(frag);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        idb = null;
    }

    private void cartSetter() {
        EditText editText = (EditText) idb.qty;
        SharedPreferences.Editor setter = cart.edit();
        try {
            int itemQty = Integer.parseInt(editText.getText().toString());
            if (itemQty > 0) {
                String itemName = idb.itemName.getText().toString();
                String current = String.valueOf(getItemNumber());
                double sum = price * itemQty;
                Log.println(Log.INFO, "The sum of price * quantity ", valueOf(df.format(sum)));
                Snackbar.make(getActivity().findViewById(R.id.snack_text), "You've added " + Integer.parseInt(valueOf(itemQty)) + " " + itemName + " to your Cart." +
                        "\nFor a total of " + df.format(sum), Snackbar.LENGTH_LONG).show();
                double total = getTotalValue()+sum;
                setTotalValue(total);
                setter.putString(cartKey, df.format(total)).apply();
                addItemToMulti(current, itemName, String.valueOf(itemQty), df.format(price), df.format(sum));
                addToSharedPref();
                setID();
            } else {
                makeToastZero();
            }
        } catch (IllegalArgumentException|NullPointerException e) {
            makeToastZero();
        }
        closeDialog();
    }
    public static void addItemToMulti(String current, String itemName, String qty, String
            cost, String sum) {
        items.put(current, current);
        items.put(current, itemName);
        items.put(current, qty);
        items.put(current, cost);
        items.put(current, sum);
        if (getTotalValue() == 0) {
            setTotalValue(Double.parseDouble(sum));
            new MainActivity().onCartChange();
        } else {
            setTotalValue(getTotalValue() + Double.parseDouble(sum));
            new MainActivity().onCartChange();
        }
    }
    private void addToSharedPref() {
        for (String key : items.keySet()) {
            itemsList.edit().putString(itemKey+key, items.get(key).toString()).apply();
            itemsList.edit().putString(itemNumKey,String.valueOf(getItemNumber())).apply();
        }
        Log.println(Log.INFO, "ItemList", itemsList.getAll().toString());
    }

}