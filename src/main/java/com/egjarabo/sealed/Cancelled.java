package com.egjarabo.sealed;

import java.time.LocalDateTime;

public record Cancelled(LocalDateTime cancelledAt, String reason) implements OrderStatus {
}
