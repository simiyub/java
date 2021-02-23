package com.monotonic.collections._5_streams;

import java.util.Objects;

public class Product
{
    private final int id;
    private final String name;
    private final int weight;

    public Product(final int id, final String name, final int weight)
    {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public String getName()
    {
        return name;
    }

    public int getWeight()
    {
        return weight;
    }

    public int getId()
    {
        return id;
    }

    public String toString()
    {
        return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", weight=" + weight +
            '}';
    }

    public boolean equals(final Object o)
    {
        if (!(o instanceof Product)) return false;

        final Product product = (Product) o;

        return Objects.equals(id, product.id)
            && Objects.equals(weight, product.weight)
            && Objects.equals(name, product.name);
    }

    public int hashCode()
    {
        return Objects.hash(id, name, weight);
    }
}
