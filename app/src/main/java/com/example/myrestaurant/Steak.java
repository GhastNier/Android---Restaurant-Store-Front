package com.example.myrestaurant;

import static com.example.myrestaurant.GetterAndSetter.setSubItem;

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
        steak.firstItemSteak.setOnClickListener(view1 -> {
            setSubItem(20);
            navigateTo(R.id.action_steak_to_itemDescription);
        });
        steak.secondItemSteak.setOnClickListener(view12 -> {
            setSubItem(21);
            navigateTo(R.id.action_steak_to_itemDescription);
        });
        steak.thirdItemSteak.setOnClickListener(view13 -> {
            setSubItem(22);
            navigateTo(R.id.action_steak_to_itemDescription);
        });
        steak.fabSteak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(R.id.action_steak_to_cartView);
                MainActivity.fabVisibilityOff(view);
            }
        });
    }
    private void navigateTo(int frag) {
        NavHostFragment.findNavController(this)
                .navigate(frag);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        steak = null;
    }
}