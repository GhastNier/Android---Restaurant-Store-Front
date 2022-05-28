package com.example.myrestaurant.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myrestaurant.cart.CartItems.ItemsTabContent.ItemsTab;
import com.example.myrestaurant.databinding.ItemTabBinding;

import java.util.List;

/**
 * {@link androidx.recyclerview.widget.RecyclerView.Adapter} that can display a {@link ItemsTab}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ItemTabsRecycler extends androidx.recyclerview.widget.RecyclerView.Adapter<ItemTabsRecycler.ViewHolder> {

    private final List<ItemsTab> mValues;

    public ItemTabsRecycler(List<ItemsTab> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(ItemTabBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
                public final TextView mContentView;
        public ItemsTab mItem;

        public ViewHolder(ItemTabBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}