package com.example.myrestaurant;
import static com.example.myrestaurant.MainActivity.subItem;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.databinding.PizzaBinding;

public class Pizza extends Fragment {

    private PizzaBinding pizza;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        pizza = PizzaBinding.inflate(inflater, container, false);
        return pizza.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        subItem = 0;
        pizza.firstItemPizza.setOnClickListener(view0 -> {
            subItem = 0;
            navigateTo();
        });
        pizza.secondItemPizza.setOnClickListener(view1 -> {
            subItem = 1;
            navigateTo();
        });
        pizza.thirdItemPizza.setOnClickListener(view2 -> {
            subItem = 2;
            navigateTo();

        });
        pizza.fourthItemPizza.setOnClickListener(view3 -> {
            subItem = 3;
            navigateTo();
        });
        pizza.fifthItemPizza.setOnClickListener(view4 -> {
            subItem = 4;
            navigateTo();
        });
        pizza.sixthItemPizza.setOnClickListener(view5 -> {
            subItem = 5;
            navigateTo();
        });
        pizza.seventhItemPizza.setOnClickListener(view6 -> {
            subItem = 6;
            navigateTo();
        });
    }

    private void navigateTo() {
        NavHostFragment.findNavController(Pizza.this)
                .navigate(R.id.action_pizza_to_itemDescription);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        pizza = null;
    }
}