package com.example.myrestaurant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myrestaurant.databinding.CartViewBinding;
import com.google.android.material.tabs.TabLayout;

public class CartView extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ){
        return inflater.inflate(R.layout.cart_view,container,false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tl = (TabLayout) view.findViewById(R.id.tabMenu);
        ViewPager2 vp2 = (ViewPager2)
    }

    private void navigateTo(int frag) {
        NavHostFragment.findNavController(CartView.this)
                .navigate(frag);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        cartViewBinding = null;
    }
}