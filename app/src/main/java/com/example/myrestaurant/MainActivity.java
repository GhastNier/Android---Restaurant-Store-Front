package com.example.myrestaurant;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myrestaurant.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    boolean isLargeLayout;
    public static int itemNumber = 1000;
    public static final String cartKey = "cartKey";
    public static ListMultimap<String, String> items;
    public static SharedPreferences cart;
    private static int subItem;
    private static String item;

    public static int getSubItem() {
        return subItem;
    }

    public static void setSubItem(int subItem) {
        MainActivity.subItem = subItem;
    }

    public static String getItem() {
        return item;
    }

    public static void setItem(String item) {
        MainActivity.item = item;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items = MultimapBuilder.treeKeys().arrayListValues().build();
        isLargeLayout = getResources().getBoolean(R.bool.large_layout);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        cart = getSharedPreferences(cartKey, Context.MODE_PRIVATE);
        cart.edit().putString(cartKey, "0").apply();
        Log.v("CartKey Value: ", String.valueOf(Double.parseDouble(cart.getString(cartKey, ""))));
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(view -> Snackbar.make(view, "This is going to be the cart", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }
}

