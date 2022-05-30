package com.example.myrestaurant.CartLists;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrestaurant.CartLists.TabContent.TabItems;
import com.example.myrestaurant.CartTabActivity;
import com.example.myrestaurant.R;
import com.example.myrestaurant.databinding.CartTabBinding;

import java.util.List;

public class CartTabRecycler extends RecyclerView.Adapter<CartTabRecycler.ViewHolder> {

    private final List<TabItems> mValues;

    public CartTabRecycler(List<TabItems> items) {
        mValues = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(CartTabBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mItemName.setText(mValues.get(position).name);
        holder.mItemQty.setText(mValues.get(position).qty);
        holder.mItemPrice.setText(mValues.get(position).price);
        holder.mItemTotal.setText(mValues.get(position).total);
        holder.mCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemRemoveDialog(holder, view);
                    holder.getBindingAdapter().notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mItemName, mItemPrice, mItemQty, mItemTotal;
        public TabItems mItem;
        public CartTabBinding mBinding;
        public final CardView mCard;

        public ViewHolder(CartTabBinding binding) {
            super(binding.getRoot());
            mCard = binding.cartCardView;
            mItemName = binding.itemName;
            mItemQty = binding.itemQty;
            mItemPrice = binding.itemPrice;
            mItemTotal = binding.itemTotal;
            mBinding = binding;

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItemName.getText() + "'";
        }
    }

    public int itemRemoveDialog(ViewHolder holder, View v) {
        Intent intent = new Intent(v.getRootView().getContext(), CartTabActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        final int[] i = {0};
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(v.getRootView().getContext());
        alertDialog.setTitle("Remove Item: " + holder.mItemName.getText());
        alertDialog.setMessage(com.example.myrestaurant.CartLists.TabContent.makeDetails(holder.getBindingAdapterPosition()));
        alertDialog.setPositiveButton(R.string.cancel, (dialog, which) -> dialog.cancel());
        alertDialog.setNegativeButton(R.string.accept, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                com.example.myrestaurant.CartLists.TabContent.removeCartItem(which);
                ItemsTabContent.removeCartItem(which);
                i[0]++;
                Navigation.findNavController(holder.mBinding.getRoot().getRootView()).navigate(R.id.action_global_cartTabActivity);
            }
        });

        AlertDialog dialog = alertDialog.create();
        dialog.show();
        return i[0];
    }

}

