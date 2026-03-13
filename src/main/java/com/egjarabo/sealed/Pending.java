package com.egjarabo.sealed;

import java.time.LocalDateTime;

public record Pending(LocalDateTime createdAt) implements OrderStatus {
}
