package com.example.myrestaurant;

import static com.example.myrestaurant.GetterAndSetter.getFAB;
import static com.example.myrestaurant.GetterAndSetter.setLargeLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myrestaurant.databinding.ActivityMainBinding;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;

public class MainActivity extends AppCompatActivity {
    public static AppBarConfiguration appBarConfiguration;
    public static final String cartKey = "cartKey";
    public static final String valueKey = "valueKey";
    public static ListMultimap<String, String> items;
    public static SharedPreferences cart;
    private static final String listKey = "itemsKey";
    public static SharedPreferences itemsList;
    public static SharedPreferences value;
    public static ActivityMainBinding binding;
    private static String cartCost;

    public static String getCartCost() {
        return cartCost;
    }

    LayoutInflater inflater;

    public static void setCartCost(String cartCost) {
        MainActivity.cartCost = cartCost;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createItemMap();
        createBinding();

        createCartSharedPref();
        Log.v("CartKey Value: ", String.valueOf(Double.parseDouble(cart.getString(cartKey, ""))));
    }

    public static void onCartChange() {
        binding.cartAmount.setText("Cart Value: " + value.getString(valueKey, "") + "$");
    }

    private void clearList() {
        itemsList.edit().clear().apply();
        for (String key : items.keys()) {
            items.removeAll(key);
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
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(findViewById(R.id.toolbar), navController, appBarConfiguration);
    }

    public void closeList(View view) {
        getFAB().setVisibility(View.VISIBLE);
    }

    private void createItemMap() {
        items = MultimapBuilder.treeKeys().arrayListValues().build();
        setLargeLayout(getResources().getBoolean(R.bool.large_layout));
        itemsList = getSharedPreferences(listKey, MODE_PRIVATE);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public static void fabVisibilityOff(View view) {
        view.setVisibility(View.INVISIBLE);
    }

    public static void fabVisibilityOn(View view) {
        view.setVisibility(View.VISIBLE);
    }

/**    public void list() {
 String[] itemList = new String[GetterAndSetter.getItemNumber()];
 int i = 0;
 for (String key : items.keys()){
 itemList[i] = items.get(key).get(1);
 i++;
 }
 CartAdapter adapter = new CartAdapter(itemList);
 adapter.toString();
 }*/
}

