package com.egjarabo.record;

import java.math.BigDecimal;
import java.util.Objects;

public record Product(String id, String name, BigDecimal price, String category) {

    public Product{
        Objects.requireNonNull(id, "id cannot be null");
        Objects.requireNonNull(name, "name cannot be null");
        Objects.requireNonNull(price, "price cannot be null");
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("price cannot be negative");
        }
        name = name.trim();
    }

    public boolean isExpensive() {
        return price.compareTo(new BigDecimal(50)) > 0;
    }

    public Product withDiscount(int percent) {
        BigDecimal factor = BigDecimal.valueOf(100 - percent).divide(BigDecimal.valueOf(100));
        return new Product(id, name, price.multiply(factor), category);
    }
}
