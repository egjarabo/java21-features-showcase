package com.egjarabo.sealed;

public sealed interface OrderStatus
        permits Pending, Confirmed, Shipped, Delivered, Cancelled {
}
