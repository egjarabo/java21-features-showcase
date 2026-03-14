# Java 21 Features Showcase

Practical examples of modern Java 21 features applied to a generic
e-commerce domain. Each package is self-contained and focuses on
one specific feature.

## Features covered

| Feature | Package |
|---|---|
| Records | `com.egjarabo.record` |
| Sealed Classes | `com.egjarabo.sealed` |
| Pattern Matching | `com.egjarabo.patterns` |
| Text Blocks | `com.egjarabo.textblocks` | 
| Virtual Threads | `com.egjarabo.virtualthreads` |

## Records
Immutable data carriers for DTOs and domain events.
Covers compact constructors, validation, and derived methods.

**Key classes:** `Product`, `OrderItem`, `OrderSummary`

## Sealed Classes
Modeling a complete order lifecycle with exhaustive
type-safe switch expressions. Compiler enforces all states are handled.

**Key classes:** `OrderStatus`, `OrderStatusService`

## Pattern Matching
Type-safe pattern matching with guards using `when` clauses.
Combines sealed classes with switch expressions for expressive domain logic.

**Key classes:** `OrderClassifier`

## Text Blocks
Clean multiline strings for JSON, SQL and HTML templates.
No escape characters, no concatenations.

**Key classes:** `ProductTemplates`

## Virtual Threads
Comparison between platform threads and Virtual Threads (Project Loom).
Demonstrates how Virtual Threads scale with high-concurrency I/O workloads.

**Key classes:** `ProductFetcher`

## How to run
```bash
mvn test
```

## Requirements
- Java 21+
- Maven 3.9+
