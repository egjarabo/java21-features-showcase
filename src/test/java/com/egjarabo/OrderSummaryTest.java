package com.egjarabo;

import com.egjarabo.record.OrderItem;
import com.egjarabo.record.OrderSummary;
import com.egjarabo.record.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderSummaryTest {

    @Test
    void shouldCalculateTotalCorrectly() {
        var product = new Product("P1", "Laptop", new BigDecimal("100"), "Electronics");
        var orderItem = new OrderItem(product, 20);
        var orderSummary = new OrderSummary("1", "25", List.of(orderItem));
        assertEquals(new BigDecimal(2000), orderSummary.total());
    }

    @Test
    void shouldCalculateTotalItemsCorrectly() {
        var product = new Product("P1", "Laptop", new BigDecimal("100"), "Electronics");
        var orderItem = new OrderItem(product, 20);
        var orderSummary = new OrderSummary("1", "25",List.of(orderItem));
        assertEquals(20, orderSummary.totalItems());
    }
}
