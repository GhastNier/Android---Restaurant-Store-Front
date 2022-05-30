package com.example.myrestaurant.menus;

import static com.example.myrestaurant.GetterAndSetter.setItem;
import static com.example.myrestaurant.GetterAndSetter.setSubItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.R;
import com.example.myrestaurant.databinding.SteakBinding;

public class Steak extends Fragment {

    private SteakBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = SteakBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setItem("steak");
        binding.firstItemSteak.setOnClickListener(view1 -> {
            setSubItem(20);
            navigateTo(R.id.action_steak_to_itemDescription);
        });
        binding.secondItemSteak.setOnClickListener(view12 -> {
            setSubItem(21);
            navigateTo(R.id.action_steak_to_itemDescription);
        });
        binding.thirdItemSteak.setOnClickListener(view13 -> {
            setSubItem(22);
            navigateTo(R.id.action_steak_to_itemDescription);
        });
    }
    private void navigateTo(int frag) {
        NavHostFragment.findNavController(this)
                .navigate(frag);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}