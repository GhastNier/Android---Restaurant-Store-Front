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
import com.example.myrestaurant.databinding.TiramisuBinding;

public class Tiramisu extends Fragment {

    private TiramisuBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = TiramisuBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setItem("dessert");
        binding.firstItemTiramisu.setOnClickListener(view0 -> {
            setSubItem(50);
            navigateTo(R.id.action_tiramisu_to_itemDescription);
        });
        binding.secondItemTiramisu.setOnClickListener(view1 -> {
            setSubItem(51);
            navigateTo(R.id.action_tiramisu_to_itemDescription);
        });
        binding.thirdItemTiramisu.setOnClickListener(view2 -> {
            setSubItem(52);
            navigateTo(R.id.action_tiramisu_to_itemDescription);
        });
        binding.fourthItemTiramisu.setOnClickListener(view3 -> {
            setSubItem(53);
            navigateTo(R.id.action_tiramisu_to_itemDescription);
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