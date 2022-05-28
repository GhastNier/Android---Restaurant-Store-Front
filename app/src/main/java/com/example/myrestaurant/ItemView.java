package com.example.myrestaurant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class ItemView extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ){
        return inflater.inflate(R.layout.list_view,container,false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new ItemTab();
        view.findViewById(R.id.list_view_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MainActivity().clearList();
            }
        });
        view.findViewById(R.id.list_view_cart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(R.id.action_itemView_to_cartView);
            }
        });
    }

    private void navigateTo(int frag) {
        NavHostFragment.findNavController(ItemView.this)
                .navigate(frag);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}