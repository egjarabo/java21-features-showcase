package com.egjarabo.textblocks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTemplatesTest {
    private final ProductTemplates templates = new ProductTemplates();

    @Test
    void jsonContainsProductData() {
        var json = templates.toJson("P001", "Laptop", 1200.00);
        assertTrue(json.contains("\"id\": \"P001\""));
        assertTrue(json.contains("\"name\": \"Laptop\""));
        assertTrue(json.contains("1200.00"));
    }

    @Test
    void sqlContainsCategoryFilter() {
        var sql = templates.toSqlQuery("Electronics", 500.00);
        assertTrue(sql.contains("Electronics"));
        assertTrue(sql.contains("500.00"));
    }

    @Test
    void emailContainsOrderId() {
        var html = templates.toEmailHtml("ORD-001", "1200.00");
        assertTrue(html.contains("ORD-001"));
        assertTrue(html.contains("1200.00"));
    }
}
