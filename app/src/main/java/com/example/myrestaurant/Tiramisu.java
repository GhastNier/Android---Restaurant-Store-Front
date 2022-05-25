package com.example.myrestaurant;
import static com.example.myrestaurant.MainActivity.setSubItem;
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
        dessert.firstItemTiramisu.setOnClickListener(view0 -> {
            setSubItem(50);
            navigateTo();
        });
        dessert.secondItemTiramisu.setOnClickListener(view1 -> {
            setSubItem(51);
            navigateTo();
        });
        dessert.thirdItemTiramisu.setOnClickListener(view2 -> {
            setSubItem(52);
            navigateTo();
        });
        dessert.fourthItemTiramisu.setOnClickListener(view3 -> {
            setSubItem(53);
            navigateTo();
        });
    }

    private void navigateTo() {
        NavHostFragment.findNavController(Tiramisu.this)
                .navigate(R.id.action_tiramisu_to_itemDescription);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dessert = null;
    }
}