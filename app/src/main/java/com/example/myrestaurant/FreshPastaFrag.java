package com.example.myrestaurant;

import static com.example.myrestaurant.GetterAndSetter.setSubItem;

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
        MainActivity.fabVisibilityOn(fresh.fabPasta);
        fresh.firstItemPasta.setOnClickListener(view0 -> {
            setSubItem(30);
            navigateTo(R.id.action_freshPasta_to_itemDescription);
        });
        fresh.secondItemPasta.setOnClickListener(view1 -> {
            setSubItem(31);
            navigateTo(R.id.action_freshPasta_to_itemDescription);
        });
        fresh.thirdItemPasta.setOnClickListener(view2 -> {
            setSubItem(32);
            navigateTo(R.id.action_freshPasta_to_itemDescription);
        });
        fresh.fabPasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(R.id.action_freshPasta_to_cartView);
                MainActivity.fabVisibilityOff(view);
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
        fresh = null;
    }
}
