package com.example.myrestaurant;

import static com.example.myrestaurant.GetterAndSetter.setSubItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrestaurant.databinding.AntiPastoBinding;

public class AntiPasto extends Fragment {

    private AntiPastoBinding ap;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        ap = AntiPastoBinding.inflate(inflater, container, false);
        return ap.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity.fabVisibilityOn(ap.fabAnti);
        ap.firstItemAnti.setOnClickListener(view0 -> {
            setSubItem(10);
            navigateTo(R.id.action_SecondFragment_to_itemDescription);
        });
        ap.secondItemAnti.setOnClickListener(view1 -> {
            setSubItem(11);
            navigateTo(R.id.action_SecondFragment_to_itemDescription);
        });
        ap.thirdItemAnti.setOnClickListener(view2 -> {
            setSubItem(12);
            navigateTo(R.id.action_SecondFragment_to_itemDescription);

        });
        ap.fourthItemAnti.setOnClickListener(view3 -> {
            setSubItem(13);
            navigateTo(R.id.action_SecondFragment_to_itemDescription);
        });
        ap.fabAnti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(R.id.action_FirstFragment_to_cartView);
                MainActivity.fabVisibilityOff(view);
            }
        });
    }
    private void navigateTo(int frag) {
        NavHostFragment.findNavController(this)
                .navigate(frag);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ap = null;
    }
}