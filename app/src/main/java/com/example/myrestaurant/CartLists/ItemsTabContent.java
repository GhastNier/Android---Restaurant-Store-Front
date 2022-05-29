package com.example.myrestaurant.CartLists;

import static com.example.myrestaurant.MainActivity.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class ItemsTabContent {

    public static final List<ItemsTab> ITEMS = new ArrayList<ItemsTab>();
    public static final Map<String, ItemsTab> ITEM_MAP = new HashMap<String, ItemsTab>();

    static {
        for (String key : items.keySet()) {
            addItem(createItem(items.get(key).get(0), items.get(key).get(1)));
        }
    }

    private static void addItem(ItemsTab item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ItemsTab createItem(String id, String name) {
        return new ItemsTab(id, name);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static void clearContent() {
        ITEMS.clear();
        ITEM_MAP.clear();
    }
    public static void updateDataSet() {
        ItemsTabContent.clearContent();
        for (String key : items.keySet()) {
            new ItemsTabContent.ItemsTab(items.get(key).get(0), items.get(key).get(1));
        }
    }
    public static class ItemsTab {
        public final String id;
        public final String content;

        public ItemsTab(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }


}