package com.egjarabo.record;

import java.math.BigDecimal;
import java.util.List;

public record OrderSummary(String orderId, String customerId, List<OrderItem> items) {

    public BigDecimal total(){
        return items.stream()
                .map(OrderItem::subtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int totalItems() {
        return items.stream()
                .mapToInt(OrderItem::quantity).sum();
    }
}
