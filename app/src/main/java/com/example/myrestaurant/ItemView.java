package com.example.myrestaurant;

import static com.example.myrestaurant.MainActivity.clearList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.cart.ui.main.ItemTab;

public class ItemView extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.text1 = (TextView) getActivity().findViewById(R.id.cart_amount) ;
    }

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
                clearList();
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