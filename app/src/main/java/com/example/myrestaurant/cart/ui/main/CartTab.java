package com.example.myrestaurant.cart.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myrestaurant.CartLists.CartTabContent;
import com.example.myrestaurant.R;
import com.example.myrestaurant.databinding.CartTabBinding;

/**
 * A fragment representing a list of Items.
 */
public class CartTab extends Fragment {

    private CartTabBinding cartTabBinding;
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CartTab() {
    }
    private CartTabRecycler ctb;
    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CartTab newInstance(int columnCount) {
        CartTab fragment = new CartTab();
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
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onResume() {
        super.onResume();
        ctb = new CartTabRecycler(CartTabContent.ITEMS);
        ctb.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ctb = new CartTabRecycler(CartTabContent.ITEMS);
        View view = inflater.inflate(R.layout.cart_tab_list, container, false);
        Context context = view.getContext();
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(ctb);
        return view;
    }
}