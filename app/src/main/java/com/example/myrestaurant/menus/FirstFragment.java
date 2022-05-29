package com.example.myrestaurant.menus;

import static com.example.myrestaurant.GetterAndSetter.setItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.R;
import com.example.myrestaurant.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setItem("");
        binding.antepastoConst.setOnClickListener(view0 -> {
            setItem("anti");
            navigateTo(R.id.action_FirstFragment_to_AntiPasto);
        });
        binding.pizzaConst.setOnClickListener(view1 -> {
            setItem("pizza");
            navigateTo(R.id.action_FirstFragment_to_pizza);
        });
        binding.pastaConst.setOnClickListener(view2 -> {
            setItem("pasta");
            navigateTo(R.id.action_FirstFragment_to_freshPasta);
        });
        binding.tiramisuConst.setOnClickListener(view3 -> {
            setItem("dessert");
            navigateTo(R.id.action_FirstFragment_to_tiramisu);
        });
        binding.steakConst.setOnClickListener(view4 -> {
            setItem("steak");
            navigateTo(R.id.action_FirstFragment_to_steak);
        });
        binding.getRoot().findViewById(R.id.btn_cart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(R.id.action_FirstFragment_to_cartTabActivity);
            }
        });
        binding.getRoot().findViewById(R.id.btn_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               navigateTo(R.id.action_FirstFragment_to_itemView);
            }
        });
    }


    private void navigateTo(int frag) {
        NavHostFragment.findNavController(FirstFragment.this)
                .navigate(frag);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void fabVisibilityOff(View view) {
        view.setVisibility(View.INVISIBLE);
    }
}