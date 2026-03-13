package com.egjarabo.sealed;

import java.time.LocalDateTime;

public record Confirmed(LocalDateTime confirmedAt, String confirmedBy) implements OrderStatus{
}
