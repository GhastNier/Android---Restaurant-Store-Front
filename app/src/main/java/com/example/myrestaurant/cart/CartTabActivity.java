package com.example.myrestaurant.cart;

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

import com.example.myrestaurant.R;
import com.example.myrestaurant.cart.ui.main.CartTab;
import com.example.myrestaurant.cart.ui.main.ItemTab;
import com.example.myrestaurant.cart.ui.main.SectionsPagerAdapter;
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
        showButtons();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_cart_tab);
        fragPager.addFragment(CartTab.newInstance(1), "Items");
        fragPager.addFragment(ItemTab.newInstance(1), "Cart");
        viewPager.setAdapter(fragPager);
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setIcon(R.drawable.ic_list);
        tabs.getTabAt(1).setIcon(R.drawable.ic_cart);
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

    public void showButtons() {
        main.setText(df.format(getTotalValue()));
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_global_mainActivity);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearList();
                main.setText(df.format(getTotalValue()));
            }
        });
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