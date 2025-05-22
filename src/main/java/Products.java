import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Products {
    // - Write a method that takes a string that is a comma-separated list of products
    // in format <product_name>,<quantity>,<price_per_unit>
    // - Parse the input lines.
    // - Aggregate the total sales amount (quantity × price) per product.
    // - Return a `Map<String, Double>` where the key is the product name and the value
    // is the total sales amount for that product.
    // - Ignore lines that are malformed
    // - Product names are case-insensitive
    // - Round the total sales amount for each product to two decimal places.

    // Notes: to round to 2 decimal places, we need to use BigDecimal,
    // so the signature of the method should be updated, and price converted,
    // e.g., new BigDecimal(price).setScale(2, RoundingMode.HALF_UP)

    Map<String, Double> aggregateSales(List<String> csvLines) {
        Map<String, Double> products = new HashMap<>();
        csvLines.forEach(csvLine -> {
            String[] split = csvLine.split(",");
            if (split.length != 3) {
                return;
            }
            String productName = split[0].trim().toLowerCase();
            int quantity = Integer.parseInt(split[1].trim());
            double pricePerUnit;
            if (products.containsKey(productName)) {
                pricePerUnit = products.get(productName) + (quantity * Double.parseDouble(split[2].trim()));
            } else {
                pricePerUnit = quantity * Double.parseDouble(split[2].trim());
            }
            products.put(productName, pricePerUnit);
        });
        return products;
    }
}
