package com.example.myrestaurant.cart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myrestaurant.R;
import com.example.myrestaurant.cart.ui.main.CartTab;
import com.example.myrestaurant.cart.ui.main.ItemTab;
import com.example.myrestaurant.cart.ui.main.SectionsPagerAdapter;
import com.example.myrestaurant.databinding.ActivityCartTabBinding;
import com.google.android.material.tabs.TabLayout;

public class CartTabActivity extends AppCompatActivity {

    private ActivityCartTabBinding binding;
    private SectionsPagerAdapter fragPager;
    TabLayout tabs;
    ViewPager viewPager;
    private PagerAdapter pagerAdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding();
        fragPager.addFragment(ItemTab.newInstance(1),"Items");
        fragPager.addFragment(CartTab.newInstance(1),"Cart");
        viewPager.setAdapter(fragPager);
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setIcon(R.drawable.ic_list);
        tabs.getTabAt(1).setIcon(R.drawable.ic_cart);

    }
    private void setBinding() {
        binding = ActivityCartTabBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragPager = new SectionsPagerAdapter(this, getSupportFragmentManager());
        tabs = binding.tabs;
        viewPager = binding.viewPager;
    }
}