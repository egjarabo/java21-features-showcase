package com.egjarabo.textblocks;

public class ProductTemplates {

    public String toJson(String id, String name, double price) {
        return """
                {
                  "id": "%s",
                  "name": "%s",
                  "price": %.2f
                }
                """.formatted(id, name, price);
    }

    public String toSqlQuery(String category, double maxPrice) {
        return """
                SELECT id, name, price
                FROM products
                WHERE category = '%s'
                AND price < %.2f
                ORDER BY price ASC
                """.formatted(category, maxPrice);
    }

    public String toEmailHtml(String orderId, String total) {
        return """
                <html>
                  <body>
                    <h1>Order %s confirmed!</h1>
                    <p>Total: %s €</p>
                  </body>
                </html>
                """.formatted(orderId, total);
    }
}
