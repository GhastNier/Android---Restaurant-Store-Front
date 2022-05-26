package com.example.myrestaurant;

import static com.example.myrestaurant.GetterAndSetter.setSubItem;
import static com.example.myrestaurant.MainActivity.fabVisibilityOn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.databinding.TiramisuBinding;

public class Tiramisu extends Fragment {

    private TiramisuBinding dessert;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        dessert = TiramisuBinding.inflate(inflater, container, false);
        return dessert.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fabVisibilityOn(dessert.fabTira);
        dessert.firstItemTiramisu.setOnClickListener(view0 -> {
            setSubItem(50);
            navigateTo(R.id.action_tiramisu_to_itemDescription);
        });
        dessert.secondItemTiramisu.setOnClickListener(view1 -> {
            setSubItem(51);
            navigateTo(R.id.action_tiramisu_to_itemDescription);
        });
        dessert.thirdItemTiramisu.setOnClickListener(view2 -> {
            setSubItem(52);
            navigateTo(R.id.action_tiramisu_to_itemDescription);
        });
        dessert.fourthItemTiramisu.setOnClickListener(view3 -> {
            setSubItem(53);
            navigateTo(R.id.action_tiramisu_to_itemDescription);
        });
        dessert.fabTira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(R.id.action_tiramisu_to_cartView);
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
        dessert = null;
    }
}