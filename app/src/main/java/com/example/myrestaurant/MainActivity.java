package com.example.myrestaurant;

import static com.example.myrestaurant.GetterAndSetter.getItemNumber;
import static com.example.myrestaurant.GetterAndSetter.getTotalValue;
import static com.example.myrestaurant.GetterAndSetter.setItemNumber;
import static com.example.myrestaurant.GetterAndSetter.setLargeLayout;
import static com.example.myrestaurant.GetterAndSetter.setTotalValue;
import static com.example.myrestaurant.ItemDescription.df;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myrestaurant.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;

public class MainActivity extends AppCompatActivity {

    public static final String cartKey = "cartKey";
    public static final String itemNumKey = "numKey";
    public static final String valueKey = "valueKey";
    public static final String itemKey = "itemsKey";
    private NavController navController;
    public static ListMultimap<String, String> items;
    public static AppBarConfiguration appBarConfiguration;
    public static SharedPreferences cart, itemsList, value, numKey;

    private ActivityMainBinding binding;
    TextView text1;
    @Override
    protected void onRestart() {
        super.onRestart();
        loadCart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        text1 = (TextView) findViewById(R.id.cart_amount);
        onCartChange();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text1 = (TextView) findViewById(R.id.cart_amount);
        createBinding();
        createItemMap();
        createCartSharedPref();
    }

    public void onCartChange() {
        text1.setText("Cart Value: " + df.format(getTotalValue()) + "$");
    }

    public void clearList() {
        if (getItemNumber() > 1) {
            value.edit().putString(valueKey, "0.00").apply();
            itemsList.edit().clear().apply();
            items.clear();
            setTotalValue(0.00);
            onCartChange();
            setItemNumber(1);

            Toast.makeText(text1.getContext(), R.string.clear_cart, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(text1.getContext(), "The cart was already empty", Toast.LENGTH_SHORT).show();
        }
    }

    private void createCartSharedPref() {
        cart = getSharedPreferences(cartKey, Context.MODE_PRIVATE);
        value = getSharedPreferences(valueKey, Context.MODE_PRIVATE);
        cart.edit().putString(cartKey, "0").apply();
    }

    private void createBinding() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(findViewById(R.id.toolbar), navController, appBarConfiguration);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.my_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_global_cartTabActivity);
            }
        });
    }

    private void createItemMap() {
        items = MultimapBuilder.treeKeys().arrayListValues().build();
        setLargeLayout(getResources().getBoolean(R.bool.large_layout));
        itemsList = getSharedPreferences(itemKey, MODE_PRIVATE);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private void loadCart() {
        int j = 0;
        try {
            numKey = getSharedPreferences(itemNumKey, MODE_PRIVATE);
            try {
                j = Integer.parseInt(numKey.getString(itemNumKey, ""));
            } catch (NumberFormatException e) {
                Log.println(Log.ERROR, "Format Except", e.toString());
            }
            for (int i = 1; i < j; i++) {
                itemsList = getSharedPreferences(itemKey + i, MODE_PRIVATE);
                String[] temp = itemsList.getString(itemKey + i, "").split(",");
                items.put(String.valueOf(i),temp[0]);
                items.put(String.valueOf(i),temp[1]);
                items.put(String.valueOf(i),temp[2]);
                items.put(String.valueOf(i),temp[3]);
                items.put(String.valueOf(i),temp[4]);
                Log.println(Log.INFO, "Rebuilt Item", items.get(String.valueOf(i)).toString());
                onCartChange();
            }
            Log.println(Log.INFO, "Rebuilt Cart", items.toString());
        } catch (NullPointerException e) {
            Log.println(Log.INFO, "Cart was empty", e.toString());
        }
    }
}

