package com.example.myrestaurant;
import static com.example.myrestaurant.MainActivity.item;
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
        item = 0;
        firstBinding.antepastoConst.setOnClickListener(view0 -> {
            item = 0;
            navigateTo(R.id.action_FirstFragment_to_SecondFragment);
        });
        firstBinding.pizzaConst.setOnClickListener(view1 -> {
            item = 1;
            navigateTo(R.id.action_FirstFragment_to_pizza);
        });
        firstBinding.pastaConst.setOnClickListener(view2 -> {
            item = 2;
            navigateTo(R.id.action_FirstFragment_to_freshPasta);
        });
        firstBinding.tiramisuConst.setOnClickListener(view3 -> {
            item = 3;
            navigateTo(R.id.action_FirstFragment_to_tiramisu);
        });
        firstBinding.steakConst.setOnClickListener(view4 -> {
            item = 4;
            navigateTo(R.id.action_FirstFragment_to_steak);
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
}