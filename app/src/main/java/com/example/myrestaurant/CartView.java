package com.example.myrestaurant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.databinding.CartviewBinding;

public class CartView extends DialogFragment {

    private CartviewBinding cartView;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        cartView = CartviewBinding.inflate(inflater, container, false);
        return cartView.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cartView.exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(R.id.action_cartView_pop);
            }
        });
    }

    private void navigateTo(int frag) {
        NavHostFragment.findNavController(CartView.this)
                .navigate(frag);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        cartView = null;
    }
}