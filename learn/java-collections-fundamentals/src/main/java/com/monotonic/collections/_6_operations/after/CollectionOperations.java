package com.monotonic.collections._6_operations.after;

import com.monotonic.collections.common.Product;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionOperations
{
    public static Product door = new Product("Wooden Door", 35);
    public static Product floorPanel = new Product("Floor Panel", 25);
    public static Product window = new Product("Glass Window", 10);

    public static void main(String[] args)
    {
        var products = new ArrayList<Product>();
        Collections.addAll(products, door, floorPanel, window);

        Collections.fill(products, null);

        System.out.println("products = " + products);

    }
}
