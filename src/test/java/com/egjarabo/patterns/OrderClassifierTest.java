package com.egjarabo.patterns;

import com.egjarabo.sealed.Pending;
import com.egjarabo.sealed.Shipped;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class OrderClassifierTest {

    private final OrderClassifier classifier = new OrderClassifier();
    private final LocalDateTime now = LocalDateTime.now();

    @Test
    void recentPendingOrderIsNew() {
        var status = new Pending(now);
        assertTrue(classifier.classify(status).startsWith("NEW"));
    }

    @Test
    void oldPendingOrderIsStale() {
        var status = new Pending(now.minusHours(48));
        assertTrue(classifier.classify(status).startsWith("STALE"));
    }

    @Test
    void shippedOrderContainsTrackingCode() {
        var status = new Shipped(now, "TRACK-999");
        assertTrue(classifier.classify(status).contains("TRACK-999"));
    }

    @Test
    void getTrackingInfoForShipped() {
        var status = new Shipped(now, "TRACK-123");
        assertEquals("Tracking code: TRACK-123", classifier.getTrackingInfo(status));
    }

    @Test
    void getTrackingInfoForPendingReturnsDefault() {
        var status = new Pending(now);
        assertEquals("No tracking info available", classifier.getTrackingInfo(status));
    }
}
