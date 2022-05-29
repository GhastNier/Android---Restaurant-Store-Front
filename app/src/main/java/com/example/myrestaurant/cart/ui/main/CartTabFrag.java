package com.example.myrestaurant.cart.ui.main;

import static com.example.myrestaurant.GetterAndSetter.getColumnCount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myrestaurant.databinding.FragmentCartTabBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class CartTabFrag extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_COLUMN_COUNT = "column-count";
    private CartViewModel cartViewModel;
    private FragmentCartTabBinding binding;


    public CartTabFrag() {
    }

    public static CartTabFrag newInstance(int index) {
        CartTabFrag fragment = new CartTabFrag();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        bundle.putInt(ARG_COLUMN_COUNT, getColumnCount());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        cartViewModel.setIndex(index);
        cartViewModel.setRecycler(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentCartTabBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.sectionLabel;
        cartViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}