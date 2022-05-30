package com.example.myrestaurant;

import static com.example.myrestaurant.GetterAndSetter.getItem;
import static com.example.myrestaurant.GetterAndSetter.getItemNumber;
import static com.example.myrestaurant.GetterAndSetter.getSubItem;
import static com.example.myrestaurant.GetterAndSetter.getTotalValue;
import static com.example.myrestaurant.GetterAndSetter.setItemNumber;
import static com.example.myrestaurant.GetterAndSetter.setSubItem;
import static com.example.myrestaurant.GetterAndSetter.setTotalValue;
import static com.example.myrestaurant.MainActivity.cart;
import static com.example.myrestaurant.MainActivity.cartKey;
import static java.lang.String.valueOf;

import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.CartLists.TabContent;
import com.example.myrestaurant.databinding.ItemDescriptionBinding;

public class ItemDescription extends DialogFragment {
    public ItemDescriptionBinding binding;
    int canOrAdd;
    double price;
    public static final DecimalFormat df = new DecimalFormat("0.00");

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
        setDialog(getItem(), getSubItem());
        binding.addToCart.setOnClickListener(view0 -> {
            canOrAdd = 99;
            cartSetter();
        });
        binding.cancel.setOnClickListener(view1 -> {
            canOrAdd = -1;
            closeDialog();
        });
    }

    private void makeToastZero() {
        Toast.makeText(getDialog().getContext(), "Sorry 0 isn't a valid quantity.", Toast.LENGTH_SHORT).show();
    }

    public void setDialog(String item, int subItem) {
        Log.println(Log.INFO, "Item Value: ", valueOf(item));
        Log.println(Log.INFO, "Sub Item Value: ", valueOf(subItem));
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

    private void dialogValues(String itemName, String iDesc, String iPrice, int image) {
        price = Double.parseDouble(iPrice);
        binding.itemImg.setImageDrawable(ContextCompat.getDrawable(binding.getRoot().getContext(), image));
        binding.itemName.setText(itemName);
        binding.itemDesc.setText(iDesc);
        binding.itemCost.setText(iPrice);
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

    public void closeDialog() {
        navigateTo(R.id.action_itemDescription_pop);
        setSubItem(-1);
        checkCancelOrAdd();
    }

    private void checkCancelOrAdd() {
        if (canOrAdd == -1) {
            Toast.makeText(getDialog().getContext(), "The item was not added to your cart.", Toast.LENGTH_LONG).show();
            canOrAdd = 99;
        }
    }

    private void navigateTo(int frag) {
        NavHostFragment.findNavController(ItemDescription.this)
                .navigate(frag);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void cartSetter() {
        EditText editText = (EditText) binding.qty;
        SharedPreferences.Editor cartSetter = cart.edit();
        try {
            int itemQty = Integer.parseInt(editText.getText().toString());
            if (itemQty > 0) {
                String itemName = binding.itemName.getText().toString();
                double sum = price * itemQty;
                Toast.makeText(getContext(), "You've added " + Integer.parseInt(valueOf(itemQty)) + " " + itemName + " to your Cart." +
                        "\nFor a total of " + df.format(sum), Toast.LENGTH_SHORT).show();
                cartSetter.putString(cartKey, df.format(Double.parseDouble(cart.getString(cartKey, "")) + sum)).apply();
                new TabContent.TabItems(getItemNumber(), itemName, String.valueOf(itemQty), df.format(price), df.format(sum));
                cartUpdate(sum);
                setItemNumber(getItemNumber() + 1);
            } else {
                makeToastZero();
            }
        } catch (IllegalArgumentException e) {
            Log.println(Log.INFO, "Illegal Argument", "SO YEAH! " + e);
        }
        closeDialog();
    }

    private void cartUpdate(double sum){
        setTotalValue(getTotalValue() + sum);
        TextView text1 = getActivity().findViewById(R.id.cart_amount);
        StringBuilder builder = new StringBuilder();
        builder.append(getString(R.string.cart_val_void))
                .append(" ")
                .append(df.format(getTotalValue()))
                .append(getString(R.string.dollar));
        text1.setText(builder.toString());
    }

}