package com.monotonic.collections._5_streams.after;

import com.monotonic.collections._5_streams.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class EnterTheCollector
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
        products.add(floorPanel);

        Map<String, Long> lightProducts = products
            .stream()
            .filter(product -> product.getWeight() < 30)
            .sorted(comparingInt(Product::getWeight))
            .collect(groupingBy(Product::getName, counting()));

        System.out.println(lightProducts);
    }
}
