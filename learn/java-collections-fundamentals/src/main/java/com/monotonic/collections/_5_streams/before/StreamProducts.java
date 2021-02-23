package com.monotonic.collections._5_streams.before;

import com.monotonic.collections._5_streams.Product;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class StreamProducts
{
    public static void main(String[] args)
    {
        Product door = new Product(1, "Wooden Door", 35);
        Product floorPanel = new Product(2, "Floor Panel", 25);
        Product window = new Product(3, "Glass Window", 10);

        List<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);
        products.add(floorPanel);
        products.add(window);

        namesOfLightProductsWeightSortedLoop(products);
    }

    private static void namesOfLightProductsWeightSortedLoop(
        List<Product> products)
    {
        List<Product> lightProducts = new ArrayList<>();

        for (Product product : products)
        {
            if (product.getWeight() < 30)
            {
                lightProducts.add(product);
            }
        }

        lightProducts.sort(comparingInt(Product::getWeight));

        for (Product product : lightProducts)
        {
            System.out.println(product.getName());
        }
    }
}
