package com.example.myrestaurant;

import static com.example.myrestaurant.ItemDescription.df;
import static com.example.myrestaurant.MainActivity.value;
import static com.example.myrestaurant.MainActivity.valueKey;

public class GetterAndSetter {

    private static boolean isLargeLayout;
    private static int subItem;
    private static String item;
    private static int itemNumber = 1;
    private static double totalValue;
    public static boolean getLargeLayout() {
        return isLargeLayout;
    }
    private static int mColumnCount = 4;
    public static void setLargeLayout(boolean largeLayout) {
        GetterAndSetter.isLargeLayout = largeLayout;
    }
    public static int getColumnCount() {
        return mColumnCount;
    }
    public static void setmColumnCount(int mColumnCount) {
        GetterAndSetter.mColumnCount = mColumnCount;
    }


    public static int getItemNumber() {
        return itemNumber;
    }

    public static void setItemNumber(int itemNumber) {
        GetterAndSetter.itemNumber = itemNumber;
    }

    public static int getSubItem() {
        return subItem;
    }

    public static void setSubItem(int subItem) {
        GetterAndSetter.subItem = subItem;
    }

    public static String getItem() {
        return item;
    }

    public static void setItem(String item) {
        GetterAndSetter.item = item;
    }

    public static double getTotalValue() {
        return totalValue;
    }

    public static void setTotalValue(double totalValue) {
        value.edit().putString(valueKey,df.format(totalValue)).apply();
        GetterAndSetter.totalValue = totalValue;
    }

}
