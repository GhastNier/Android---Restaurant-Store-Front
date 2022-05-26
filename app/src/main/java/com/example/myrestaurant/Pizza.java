package com.example.myrestaurant;

import static com.example.myrestaurant.GetterAndSetter.setSubItem;

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
    )
    {
        pizza = PizzaBinding.inflate(inflater, container, false);
        return pizza.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity.fabVisibilityOn(pizza.fabPizza);
        pizza.firstItemPizza.setOnClickListener(view0 -> {
            setSubItem(40);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
        pizza.secondItemPizza.setOnClickListener(view1 -> {
            setSubItem(41);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
        pizza.thirdItemPizza.setOnClickListener(view2 -> {
            setSubItem(42);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
        pizza.fourthItemPizza.setOnClickListener(view3 -> {
            setSubItem(43);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
        pizza.fifthItemPizza.setOnClickListener(view4 -> {
            setSubItem(44);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
        pizza.sixthItemPizza.setOnClickListener(view5 -> {
            setSubItem(45);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
        pizza.seventhItemPizza.setOnClickListener(view6 -> {
            setSubItem(46);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
        pizza.fabPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(R.id.action_pizza_to_cartView);
                MainActivity.fabVisibilityOff(view);
            }
        });
    }
    public void navigateTo(int frag) {
        NavHostFragment.findNavController(this)
                .navigate(frag);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        pizza = null;
    }
}