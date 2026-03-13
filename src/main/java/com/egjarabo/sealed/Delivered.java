package com.egjarabo.sealed;

import java.time.LocalDateTime;

public record Delivered(LocalDateTime deliveredAt) implements OrderStatus {
}
