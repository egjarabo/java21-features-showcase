package com.egjarabo.record;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void shouldTrimNameOnCreation() {
        var product = new Product("P1", "  Laptop  ", new BigDecimal("100"), "Electronics");
        assertEquals("Laptop", product.name());
    }

    @Test
    void shouldRejectNegativePrice() {
        assertThrows(IllegalArgumentException.class,
                () -> new Product("P1", "Laptop", new BigDecimal("-1"), "Electronics"));
    }

    @Test
    void shouldApplyDiscountCorrectly() {
        var product = new Product("P1", "Laptop", new BigDecimal("100"), "Electronics");
        var discounted = product.withDiscount(10);
        assertEquals(new BigDecimal("90.0"), discounted.price());
    }

    @Test
    void recordsWithSameValuesShouldBeEqual() {
        var p1 = new Product("P1", "Laptop", new BigDecimal("100"), "Electronics");
        var p2 = new Product("P1", "Laptop", new BigDecimal("100"), "Electronics");
        assertEquals(p1, p2);
    }
}
