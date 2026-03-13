package com.egjarabo.record;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderItemTest {

    @Test
    void shouldRejectNegativeQuantity() {
        var product = new Product("P1", "Laptop", new BigDecimal(1), "Electronics");
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem(product, -1));
    }

    @Test
    void shouldCalculateSubtotalCorrectly() {
        var product = new Product("P1", "Laptop", new BigDecimal("100"), "Electronics");
        var orderItem = new OrderItem(product, 20);
        assertEquals(new BigDecimal(2000), orderItem.subtotal());
    }
}
