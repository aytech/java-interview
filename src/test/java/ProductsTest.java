import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductsTest {

    private Products products;

    @BeforeEach
    void setUp() {
        products = new Products();
    }

    @Test
    void testAggregateSales() {
        List<String> transactions = List.of(
                "Apple,2,3.50",
                "Banana,5,1.20",
                "apple,1,3.50",
                "Orange,3,2.00",
                "Banana,2,1.20",
                "InvalidLine"
        );

        Map<String, Double> result = products.aggregateSales(transactions);

        assertEquals(10.50, result.get("apple"));
        assertEquals(8.40, result.get("banana"));
        assertEquals(6.00, result.get("orange"));
    }
}
