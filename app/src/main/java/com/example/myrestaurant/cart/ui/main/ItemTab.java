package com.example.myrestaurant.cart.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrestaurant.CartLists.ItemsTabContent;
import com.example.myrestaurant.R;

/**
 * A fragment representing a list of Items.
 */
public class ItemTab extends Fragment {


    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemTab() {
    }

    private ItemTabsRecycler itb;

    @SuppressWarnings("unused")
    public static ItemTab newInstance(int columnCount) {
        ItemTab fragment = new ItemTab();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onResume() {
        super.onResume();
        itb = new ItemTabsRecycler(ItemsTabContent.ITEMS);
        itb.notifyDataSetChanged();
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
        View view = inflater.inflate(R.layout.item_tab_list, container, false);
        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view;
        itb = new ItemTabsRecycler(ItemsTabContent.ITEMS);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(itb);
        for (int i = 0;i < itb.getItemCount();i++) {
            itb.notifyItemInserted(i);
        }
        return view;
    }
}