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
import com.example.myrestaurant.databinding.PizzaBinding;

public class Pizza extends Fragment {

    private PizzaBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    )
    {
        binding = PizzaBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setItem("pizza");
        binding.firstItemPizza.setOnClickListener(view0 -> {
            setSubItem(40);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
        binding.secondItemPizza.setOnClickListener(view1 -> {
            setSubItem(41);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
        binding.thirdItemPizza.setOnClickListener(view2 -> {
            setSubItem(42);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
        binding.fourthItemPizza.setOnClickListener(view3 -> {
            setSubItem(43);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
        binding.fifthItemPizza.setOnClickListener(view4 -> {
            setSubItem(44);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
        binding.sixthItemPizza.setOnClickListener(view5 -> {
            setSubItem(45);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
        binding.seventhItemPizza.setOnClickListener(view6 -> {
            setSubItem(46);
            navigateTo(R.id.action_pizza_to_itemDescription);
        });
    }
    public void navigateTo(int frag) {
        NavHostFragment.findNavController(this)
                .navigate(frag);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}