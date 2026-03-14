package com.egjarabo.virtualthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProductFetcher {

    // Simulates a slow external call (database, API, etc.)
    public String fetchProduct(String productId) {
        try {
            Thread.sleep(100); // simulates network/database latency
            return "Product-" + productId;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "error";
        }
    }

    // Using traditional platform threads
    public List<String> fetchAllPlatform(List<String> ids) throws Exception {
        var results = new ArrayList<String>();
        try (var executor = Executors.newFixedThreadPool(10)) {
            var futures = ids.stream()
                    .map(id -> executor.submit(() -> fetchProduct(id)))
                    .toList();
            for (Future<String> future : futures) {
                results.add(future.get());
            }
        }
        return results;
    }

    // Using Virtual Threads — same logic, different executor
    public List<String> fetchAllVirtual(List<String> ids) throws Exception {
        var results = new ArrayList<String>();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var futures = ids.stream()
                    .map(id -> executor.submit(() -> fetchProduct(id)))
                    .toList();
            for (Future<String> future : futures) {
                results.add(future.get());
            }
        }
        return results;
    }
}
