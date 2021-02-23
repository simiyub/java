package com.monotonic.collections._2_what_are_collections.before;

import com.monotonic.collections.common.Product;

import java.sql.Array;
import java.util.Arrays;

public class TheArrayProblem
{
    public static void main(String[] args)
    {
        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        // Create
        Product[] products = {door,floorPanel};
        // Print
        System.out.println(Arrays.toString(products));
        // Add
         products = add(window,products);
        System.out.println(Arrays.toString(products));
        // Duplicate
    }

    private static Product[] add(Product product, Product[] array)
    {
        int length = array.length;
        Product[] newArray = Arrays.copyOf(array, length + 1);
        newArray[length] = product;
        return newArray;
    }
}
