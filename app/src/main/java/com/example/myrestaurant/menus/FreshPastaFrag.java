package com.example.myrestaurant.menus;

import static com.example.myrestaurant.GetterAndSetter.setSubItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.R;
import com.example.myrestaurant.databinding.FreshPastaBinding;

public class FreshPastaFrag extends Fragment {

    private FreshPastaBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FreshPastaBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.firstItemPasta.setOnClickListener(view0 -> {
            setSubItem(30);
            navigateTo(R.id.action_freshPasta_to_itemDescription);
        });
        binding.secondItemPasta.setOnClickListener(view1 -> {
            setSubItem(31);
            navigateTo(R.id.action_freshPasta_to_itemDescription);
        });
        binding.thirdItemPasta.setOnClickListener(view2 -> {
            setSubItem(32);
            navigateTo(R.id.action_freshPasta_to_itemDescription);
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
        NavHostFragment.findNavController(FreshPastaFrag.this)
                .navigate(frag);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
