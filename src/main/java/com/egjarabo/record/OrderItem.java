package com.egjarabo.record;

import java.math.BigDecimal;

public record OrderItem(Product product, int quantity) {

    public OrderItem{
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
    }

    public BigDecimal subtotal() {
        return product.price().multiply(new BigDecimal(quantity));
    }
}

