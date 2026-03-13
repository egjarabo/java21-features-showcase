package com.egjarabo.sealed;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class OrderStatusServiceTest {

    private final OrderStatusService service = new OrderStatusService();
    private final LocalDateTime now = LocalDateTime.now();

    @Test
    void pendingOrderCanBeCancelled() {
        var status = new Pending(now);
        assertTrue(service.canBeCancelled(status));
    }

    @Test
    void shippedOrderCannotBeCancelled() {
        var status = new Shipped(now, "TRACK-123");
        assertFalse(service.canBeCancelled(status));
    }

    @Test
    void pendingOrderCanBeConfirmed() {
        var pending = new Pending(now);
        var result = service.confirmOrder(pending, "admin");
        assertInstanceOf(Confirmed.class, result);
    }

    @Test
    void describeShippedOrderIncludesTrackingCode() {
        var status = new Shipped(now, "TRACK-XYZ");
        assertTrue(service.describe(status).contains("TRACK-XYZ"));
    }
}
