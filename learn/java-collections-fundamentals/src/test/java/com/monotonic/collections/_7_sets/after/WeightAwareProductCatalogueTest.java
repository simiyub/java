package com.monotonic.collections._7_sets.after;

import com.monotonic.collections.common.Product;
import com.monotonic.collections.common.Supplier;
import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class WeightAwareProductCatalogueTest
{
    public static Product door = new Product("Wooden Door", 35);
    public static Product floorPanel = new Product("Floor Panel", 25);
    public static Product window = new Product("Glass Window", 10);

    @Test
    public void shouldFindLighterProducts()
    {
        Supplier johnsGlazing = new Supplier("John's Glazing");
        johnsGlazing.getProducts().add(window);

        Supplier allPurpose = new Supplier("All Purpose Supplies Ltd.");
        Collections.addAll(allPurpose.getProducts(), door, floorPanel, window);

        WeightAwareProductCatalogue catalogue = new WeightAwareProductCatalogue();
        catalogue.addSupplier(johnsGlazing);
        catalogue.addSupplier(allPurpose);

        Set<Product> lighterProducts = catalogue.findLighterProducts(door);
        assertThat(lighterProducts, contains(window, floorPanel));
    }
}
