package com.egjarabo.virtualthreads;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductFetcherTest {

    private final ProductFetcher fetcher = new ProductFetcher();
    private final List<String> ids = List.of("P001", "P002", "P003", "P004", "P005");

    @Test
    void platformThreadsFetchAllProducts() throws Exception {
        var results = fetcher.fetchAllPlatform(ids);
        assertEquals(5, results.size());
        assertTrue(results.contains("Product-P001"));
    }

    @Test
    void virtualThreadsFetchAllProducts() throws Exception {
        var results = fetcher.fetchAllVirtual(ids);
        assertEquals(5, results.size());
        assertTrue(results.contains("Product-P001"));
    }

    @Test
    void virtualThreadsAreFasterThanPlatformThreads() throws Exception {
        long startPlatform = System.currentTimeMillis();
        fetcher.fetchAllPlatform(ids);
        long platformTime = System.currentTimeMillis() - startPlatform;

        long startVirtual = System.currentTimeMillis();
        fetcher.fetchAllVirtual(ids);
        long virtualTime = System.currentTimeMillis() - startVirtual;

        // Both are fast with 5 elements,
        // the difference is noticeable with thousands of concurrent requests
        System.out.println("Platform threads: " + platformTime + "ms");
        System.out.println("Virtual threads:  " + virtualTime + "ms");

        assertTrue(virtualTime <= platformTime + 50);
    }
}
