package com.egjarabo.sealed;

public class OrderStatusService {

    public String describe(OrderStatus status) {
        return switch (status) {
            case Pending p   -> "Order created at " + p.createdAt();
            case Confirmed c -> "Confirmed by " + c.confirmedBy() + " at " + c.confirmedAt();
            case Shipped s   -> "Shipped! Tracking code: " + s.trackingCode();
            case Delivered d -> "Delivered at " + d.deliveredAt();
            case Cancelled c -> "Cancelled: " + c.reason();
        };
    }

    public boolean canBeCancelled(OrderStatus status) {
        return switch (status) {
            case Pending p   -> true;
            case Confirmed c -> true;
            case Shipped s   -> false;
            case Delivered d -> false;
            case Cancelled c -> false;
        };
    }

    public OrderStatus confirmOrder(OrderStatus status, String confirmedBy) {
        return switch (status) {
            case Pending p   -> new Confirmed(p.createdAt().plusSeconds(1), confirmedBy);
            case Confirmed c -> throw new IllegalStateException("Already confirmed");
            default          -> throw new IllegalStateException("Cannot confirm from " + status);
        };
    }

}
