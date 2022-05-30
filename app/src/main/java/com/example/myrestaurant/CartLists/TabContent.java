package com.example.myrestaurant.CartLists;

import static com.example.myrestaurant.GetterAndSetter.getTotalValue;
import static com.example.myrestaurant.GetterAndSetter.setTotalValue;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TabContent {


    public static final List<TabItems> ITEMS = new ArrayList<TabItems>();
    public static final Map<String, TabItems> CART_MAP = new HashMap<String, TabItems>();

    public static void removeCartItem(int id) {
        setTotalValue(getTotalValue() - Double.parseDouble(String.valueOf(ITEMS.get(id).total)));
        CART_MAP.remove(ITEMS.get(id).name, ITEMS.get(id));
        ITEMS.remove(id);
        resetCartItemMap();
        Log.println(Log.INFO, "CartMap Values", CART_MAP.toString());
    }

    private static void addItem(TabItems item) {
        ITEMS.add(item);
        CART_MAP.put(item.name, item);
    }

    private static TabItems createItem(int i, String s, String s2, String s3, String s4) {
        return new TabItems(i, s, s2, s3, s4);
    }

    public static void resetCartItemMap() {
        ITEMS.clear();
        CART_MAP.clear();
    }

    public static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Do you wish to remove: \n")
                .append(ITEMS.get(position).qty)
                .append(" × ")
                .append(ITEMS.get(position).name)
                .append("\n \nFor a total of ")
                .append(ITEMS.get(position).total)
                .append("$");
        return builder.toString();
    }

    public static class TabItems {
        public final int id;
        public final String name;
        public final String qty;
        public final String price;
        public final String total;

        public TabItems(int id, String name, String qty, String price, String total) {
            this.id = id;
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