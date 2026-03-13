package com.egjarabo.record;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalog {

    public static void main(String[] args) {

        var laptop = new Product("P001", "Laptop Pro", new BigDecimal("1200"), "Electronics");
        var mouse  = new Product("P002", "  Wireless Mouse  ", new BigDecimal("35"), "Accessories");

        System.out.println(laptop);                          // toString automático
        System.out.println("Expensive? " + laptop.isExpensive());
        System.out.println("With 10% off: " + laptop.withDiscount(10));
        System.out.println("Name trimmed: '" + mouse.name() + "'"); // getter automático

        var order = new OrderSummary(
                "ORD-001", "customer-42",
                List.of(new OrderItem(laptop, 1), new OrderItem(mouse, 2))
        );

        System.out.println("\nOrder total: " + order.total());
        System.out.println("Total items: " + order.totalItems());
    }
}
