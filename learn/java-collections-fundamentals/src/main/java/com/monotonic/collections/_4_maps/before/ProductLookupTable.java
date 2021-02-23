package com.monotonic.collections._4_maps.before;

public interface ProductLookupTable
{
    Product lookupById(int id);

    void addProduct(Product productToAdd);

    void clear();
}
