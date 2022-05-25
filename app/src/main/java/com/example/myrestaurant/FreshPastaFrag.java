package com.example.myrestaurant;

import static com.example.myrestaurant.MainActivity.setSubItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.databinding.FreshPastaBinding;

public class FreshPastaFrag extends Fragment {

    private FreshPastaBinding fresh;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        fresh = FreshPastaBinding.inflate(inflater, container, false);
        return fresh.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fresh.firstItemPasta.setOnClickListener(view0 -> {
            setSubItem(30);
            navigateTo();
        });
        fresh.secondItemPasta.setOnClickListener(view1 -> {
            setSubItem(31);
            navigateTo();
        });
        fresh.thirdItemPasta.setOnClickListener(view2 -> {
            setSubItem(32);
            navigateTo();
        });
    }

    private void navigateTo() {
        NavHostFragment.findNavController(FreshPastaFrag.this)
                .navigate(R.id.action_freshPasta_to_itemDescription);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fresh = null;
    }
}
