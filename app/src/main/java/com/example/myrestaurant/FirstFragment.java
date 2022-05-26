package com.example.myrestaurant;

import static com.example.myrestaurant.GetterAndSetter.setItem;
import static com.example.myrestaurant.MainActivity.fabVisibilityOn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding firstBinding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        firstBinding = FragmentFirstBinding.inflate(inflater, container, false);
        return firstBinding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setItem("");
        fabVisibilityOn(firstBinding.fabMain);
        firstBinding.antepastoConst.setOnClickListener(view0 -> {
            setItem("anti");
            navigateTo(R.id.action_FirstFragment_to_AntiPasto);
        });
        firstBinding.pizzaConst.setOnClickListener(view1 -> {
            setItem("pizza");
            navigateTo(R.id.action_FirstFragment_to_pizza);
        });
        firstBinding.pastaConst.setOnClickListener(view2 -> {
            setItem("pasta");
            navigateTo(R.id.action_FirstFragment_to_freshPasta);
        });
        firstBinding.tiramisuConst.setOnClickListener(view3 -> {
            setItem("dessert");
            navigateTo(R.id.action_FirstFragment_to_tiramisu);
        });
        firstBinding.steakConst.setOnClickListener(view4 -> {
            setItem("steak");
            navigateTo(R.id.action_FirstFragment_to_steak);
        });
        firstBinding.fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(R.id.action_FirstFragment_to_cartView);
                MainActivity.fabVisibilityOff(view);
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
        firstBinding = null;
    }
    public void fabVisibilityOff(View view) {
        view.setVisibility(View.INVISIBLE);
    }
}