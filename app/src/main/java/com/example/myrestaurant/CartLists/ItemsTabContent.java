package com.example.myrestaurant.CartLists;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemsTabContent {

    public static final List<ItemsTab> ITEMS = new ArrayList<>();
    public static final Map<String, ItemsTab> ITEM_MAP = new HashMap<>();

    private static void addItem(ItemsTab item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ItemsTab createItem(String id, String name) {
        return new ItemsTab(id, name);
    }


    public static void resetItemsItemMap() {
        ITEMS.clear();
        ITEM_MAP.clear();
    }
    public static void removeCartItem(int position) {
        ITEM_MAP.remove(ITEMS.get(position).id, ITEMS.get(position));
        ITEMS.remove(position);
        resetItemsItemMap();
    }
    public static class ItemsTab {
        public final String id;
        public final String content;

        public ItemsTab(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @NonNull
        @Override
        public String toString() {
            return content;
        }
    }


}