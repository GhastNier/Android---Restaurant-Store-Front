package com.example.myrestaurant;

import static com.example.myrestaurant.MainActivity.subItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.databinding.AntiPastoBinding;

public class AntiPasto extends Fragment {

    private AntiPastoBinding ap;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        ap = AntiPastoBinding.inflate(inflater, container, false);
        return ap.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        subItem = 0;
        ap.firstItemAnti.setOnClickListener(view0 -> {
            subItem = 0;
            navigateTo();

        });
        ap.secondItemAnti.setOnClickListener(view1 -> {
            subItem = 1;

            navigateTo();
        });
        ap.thirdItemAnti.setOnClickListener(view2 -> {
            subItem = 2;

            navigateTo();

        });
        ap.fourthItemAnti.setOnClickListener(view3 -> {
            subItem = 3;
            navigateTo();
        });
    }

    private void navigateTo() {
        NavHostFragment.findNavController(AntiPasto.this)
                .navigate(R.id.action_SecondFragment_to_itemDescription);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ap = null;
    }
}