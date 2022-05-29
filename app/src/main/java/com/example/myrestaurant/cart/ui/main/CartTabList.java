package com.example.myrestaurant.cart.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myrestaurant.CartLists.CartTabContent;
import com.example.myrestaurant.R;

/**
 * A fragment representing a list of Items.
 */
public class CartTabList extends Fragment {


    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CartTabList() {
    }

    @SuppressWarnings("unused")
    public static CartTabList newInstance(int columnCount) {
        CartTabList fragment = new CartTabList();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_tab_list, container, false);
        // Set the adapter
        if (view instanceof androidx.recyclerview.widget.RecyclerView) {
            Context context = view.getContext();
            androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new CartTabRecycler(CartTabContent.ITEMS));
        }
        return view;
    }
}