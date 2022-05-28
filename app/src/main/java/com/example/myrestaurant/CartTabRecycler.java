package com.example.myrestaurant;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myrestaurant.CartItems.CartTabContent.CartTab;
import com.example.myrestaurant.databinding.CartTabBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link CartTab}.
 * TODO: Replace the implementation with code for your data type.
 */
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
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public CartTab mItem;

        public ViewHolder(CartTabBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}