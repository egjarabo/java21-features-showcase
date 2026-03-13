package com.egjarabo.sealed;

import java.time.LocalDateTime;

public record Shipped(LocalDateTime shippedAt, String trackingCode) implements OrderStatus {
}
