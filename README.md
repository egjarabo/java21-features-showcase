# Java 21 Features Showcase

Practical examples of modern Java 21 features applied to a generic
e-commerce domain. Each package is self-contained and focuses on
one specific feature.

## Features covered

| Feature | Package |
|---|---|
| Records | `com.egjarabo.record` |
| Sealed Classes | `com.egjarabo.sealed` |

## Records
Immutable data carriers for DTOs and domain events.
Covers compact constructors, validation, and derived methods.

**Key classes:** `Product`, `OrderItem`, `OrderSummary`

## Sealed Classes
Modeling a complete order lifecycle with exhaustive
type-safe switch expressions. Compiler enforces all states are handled.

**Key classes:** `OrderStatus`, `OrderStatusService`

## How to run
```bash
mvn test
```

## Requirements
- Java 21+
- Maven 3.9+
