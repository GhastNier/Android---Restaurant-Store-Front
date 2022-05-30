package com.example.myrestaurant.CartLists;

import static com.example.myrestaurant.CartLists.TabContent.makeDetails;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;

import com.example.myrestaurant.CartLists.TabContent.TabItems;
import com.example.myrestaurant.R;
import com.example.myrestaurant.databinding.ItemTabBinding;

import java.util.List;

public class ItemTabsRecycler extends androidx.recyclerview.widget.RecyclerView.Adapter<ItemTabsRecycler.ViewHolder> {

    private final List<TabItems> mValues;

    public ItemTabsRecycler(List<TabItems> items) {

        mValues = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(ItemTabBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mItemName.setText(mValues.get(position).name);
        holder.mCard.setOnClickListener(v -> {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(v.getContext());
            alertDialog.setTitle("Remove Item: " + holder.mItemName.getText());
            alertDialog.setMessage(makeDetails(holder.getBindingAdapterPosition()));
            alertDialog.setPositiveButton(R.string.cancel, (dialog, which) -> dialog.cancel());
            alertDialog.setNegativeButton(R.string.accept, (dialog, which) -> {
                ItemsTabContent.removeCartItem(which);
                holder.getBindingAdapter().notifyDataSetChanged();
                Toast.makeText(v.getRootView().getContext(), holder.mItemName.getText()+" "+ R.string.item_removed,Toast.LENGTH_SHORT).show();
            });
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public final TextView mItemName;
        public final CardView mCard;
        public ItemTabBinding mBinding;
        public TabItems mItem;

        public ViewHolder(ItemTabBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mCard = binding.itemCard;
            mItemName = binding.itemListName;
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '" + mItemName.getText() + "'";
        }
    }
}