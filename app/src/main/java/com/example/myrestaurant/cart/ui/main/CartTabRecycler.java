package com.example.myrestaurant.cart.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myrestaurant.CartLists.CartTabContent.CartTab;
import com.example.myrestaurant.databinding.CartTabBinding;

import java.util.List;

public class CartTabRecycler extends RecyclerView.Adapter<CartTabRecycler.ViewHolder> {

    private final List<CartTab> mValues;

    public CartTabRecycler(List<CartTab> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(CartTabBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mItemName.setText(mValues.get(position).name);
        holder.mItemQty.setText(mValues.get(position).qty);
        holder.mItemPrice.setText(mValues.get(position).price);
        holder.mItemTotal.setText(mValues.get(position).total);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mItemName, mItemPrice,mItemQty,mItemTotal ;
        public CartTab mItem;

        public ViewHolder(CartTabBinding binding) {
            super(binding.getRoot());
            mItemName = binding.itemName;
            mItemQty = binding.itemQty;
            mItemPrice = binding.itemPrice;
            mItemTotal = binding.itemTotal;

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItemName.getText() + "'";
        }
    }
}