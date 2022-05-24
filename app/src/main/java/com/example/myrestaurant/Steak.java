package com.example.myrestaurant;

import static com.example.myrestaurant.MainActivity.subItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.databinding.SteakBinding;

public class Steak extends Fragment {

    private SteakBinding steak;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        steak = SteakBinding.inflate(inflater, container, false);
        return steak.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        subItem = 0;
        steak.firstItemSteak.setOnClickListener(view1 -> {
            subItem = 0;
            navigateTo();
        });
        steak.secondItemSteak.setOnClickListener(view12 -> {
            subItem = 1;
            navigateTo();
        });
        steak.thirdItemSteak.setOnClickListener(view13 -> {
            subItem = 2;
            navigateTo();
        });
    }

    private void navigateTo() {
        NavHostFragment.findNavController(Steak.this)
                .navigate(R.id.action_steak_to_itemDescription);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        steak = null;
    }
}