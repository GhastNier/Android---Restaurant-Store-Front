package com.example.myrestaurant;

import static com.example.myrestaurant.GetterAndSetter.getItemNumber;
import static com.example.myrestaurant.GetterAndSetter.getTotalValue;
import static com.example.myrestaurant.GetterAndSetter.setItemNumber;
import static com.example.myrestaurant.GetterAndSetter.setTotalValue;
import static com.example.myrestaurant.ItemDescription.df;
import static com.example.myrestaurant.MainActivity.items;
import static com.example.myrestaurant.MainActivity.itemsList;
import static com.example.myrestaurant.MainActivity.value;
import static com.example.myrestaurant.MainActivity.valueKey;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.example.myrestaurant.CartLists.CartTab;
import com.example.myrestaurant.CartLists.CartTabContent;
import com.example.myrestaurant.CartLists.ItemTab;
import com.example.myrestaurant.CartLists.ItemsTabContent;
import com.example.myrestaurant.CartLists.SectionsPagerAdapter;
import com.example.myrestaurant.databinding.ActivityCartTabBinding;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class CartTabActivity extends AppCompatActivity {
    private final int[] i = {1};
    private ActivityCartTabBinding binding;
    private SectionsPagerAdapter fragPager;
    private NavController navController;
    TabLayout tabs;
    ViewPager viewPager;
    ExtendedFloatingActionButton main;
    FloatingActionButton clear, home;


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding();
        setButton();
        setValue();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_cart_tab);
        fragPager.addFragment(CartTab.newInstance(1), "Items");
        fragPager.addFragment(ItemTab.newInstance(1), "Cart");
        viewPager.setAdapter(fragPager);
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setIcon(R.drawable.ic_list);
        tabs.getTabAt(1).setIcon(R.drawable.ic_cart);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navController.navigate(R.id.action_global_mainActivity);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
    }

    private void setBinding() {
        binding = ActivityCartTabBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragPager = new SectionsPagerAdapter(this, getSupportFragmentManager());
        tabs = binding.tabs;
        viewPager = binding.viewPager;
    }

    public void setValue() {
        main.setText(df.format(getTotalValue()) + getString(R.string.dollar));
    }

    public void clearButton(View view) {
        clearList();
        fragPager = new SectionsPagerAdapter(this, getSupportFragmentManager());
        tabs = binding.tabs;
        viewPager = binding.viewPager;
        fragPager.addFragment(ItemTab.newInstance(1),"Items");
        fragPager.addFragment(CartTab.newInstance(1),"Cart");
        viewPager.setAdapter(fragPager);
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setIcon(R.drawable.ic_list);
        tabs.getTabAt(1).setIcon(R.drawable.ic_cart);

    }

    public void toHome(View view) {
        navController.navigate(R.id.action_global_mainActivity);
    }

    private void setButton() {
        main = binding.myfab2;
        clear = binding.clearcartfab;
        home = binding.toHomeFab;
    }

    public void clearList() {
        if (getItemNumber() > 1) {
            value.edit().putString(valueKey, "0.00").apply();
            itemsList.edit().clear().apply();
            items.clear();
            setTotalValue(0.00);
            setItemNumber(1);
            main.setText("0.00$");
            CartTabContent.resetCartItemMap();
            ItemsTabContent.resetItemsItemMap();
            Toast.makeText(this, R.string.clear_cart, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "The cart was already empty", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}