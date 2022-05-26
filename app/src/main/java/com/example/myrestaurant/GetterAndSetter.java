package com.example.myrestaurant;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GetterAndSetter {

    private static boolean isLargeLayout;
    private static int subItem;
    private static String item;
    private static FloatingActionButton fab;
    private static int itemNumber = 1;
    private static double totalValue;
    public static boolean getLargeLayout() {
        return isLargeLayout;
    }

    public static void setLargeLayout(boolean largeLayout) {
        GetterAndSetter.isLargeLayout = largeLayout;
    }
    public static void setFAB(FloatingActionButton fabVa){
        GetterAndSetter.fab = fabVa;
    }
    public static FloatingActionButton getFAB(){
        return fab;
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
        MainActivity.value.edit().putString(MainActivity.valueKey,ItemDescription.df.format(totalValue)).apply();
        GetterAndSetter.totalValue = totalValue;
    }

}
