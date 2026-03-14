package com.egjarabo.patterns;

import com.egjarabo.sealed.Cancelled;
import com.egjarabo.sealed.Confirmed;
import com.egjarabo.sealed.Delivered;
import com.egjarabo.sealed.OrderStatus;
import com.egjarabo.sealed.Pending;
import com.egjarabo.sealed.Shipped;

import java.time.LocalDateTime;

public class OrderClassifier {

    // Pattern matching con instanceof
    public boolean isDelivered(OrderStatus status) {
        return status instanceof Delivered d
                && d.deliveredAt().isBefore(LocalDateTime.now());
    }

    // Switch con pattern matching y guards (when)
    public String classify(OrderStatus status) {
        return switch (status) {
            case Pending p when p.createdAt()
                    .isBefore(LocalDateTime.now().minusHours(24))
                    -> "STALE - pending too long";
            case Pending p       -> "NEW - recently created";
            case Confirmed c     -> "CONFIRMED by " + c.confirmedBy();
            case Shipped s       -> "IN_TRANSIT - tracking: " + s.trackingCode();
            case Delivered d     -> "COMPLETED";
            case Cancelled c     -> "CANCELLED - reason: " + c.reason();
        };
    }

    // Extracción de datos con pattern matching
    public String getTrackingInfo(OrderStatus status) {
        if (status instanceof Shipped shipped) {
            return "Tracking code: " + shipped.trackingCode();
        }
        if (status instanceof Delivered delivered) {
            return "Delivered at: " + delivered.deliveredAt();
        }
        return "No tracking info available";
    }
}
