package com.example.myrestaurant.CartLists;

import static com.example.myrestaurant.MainActivity.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CartTabContent {


    public static final List<CartTab> ITEMS = new ArrayList<CartTab>();


    public static final Map<String, CartTab> ITEM_MAP = new HashMap<String, CartTab>();

    static {

        for (String key : items.keySet()) {

            addItem(createItem(items.get(key).get(1), items.get(key).get(2), items.get(key).get(3), items.get(key).get(4)));
        }
    }

    private static String getKey(String s, int i) {
        return items.get(s).get(i);
    }

    private static void addItem(CartTab item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }

    private static CartTab createItem(String s, String s2, String s3, String s4) {
        return new CartTab(s, s2, s3, s4);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class CartTab {

        public final String name;
        public final String qty;
        public final String price;
        public final String total;

        public CartTab(String name, String qty, String price, String total) {
            this.name = name;
            this.price = price;
            this.total = total;
            this.qty = qty;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}