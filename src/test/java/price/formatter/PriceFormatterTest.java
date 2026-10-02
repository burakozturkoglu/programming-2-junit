package price.formatter;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write your tests for the PriceFormatter here. See the specification of the
 * PriceFormatter and formatPrice method in the PriceFormatter class and the
 * readme file.
 */
public class PriceFormatterTest {

	private PriceFormatter formatter;

    @BeforeEach
    public void setUp() {
        formatter = new PriceFormatter();
    }

    @Test
    public void testBasicPriceFormatting() {
        assertEquals("3,14 €", formatter.formatPrice(3.14159));
    }

    @Test
    public void testThousandsSeparator() {
        assertEquals("123 456,79 €", formatter.formatPrice(123456.789));
        assertEquals("1 000,00 €".replace(",00", ""), formatter.formatPrice(1000.00));
        assertEquals("1 000 €", formatter.formatPrice(1000.00));
    }

    @Test
    public void testDecimalRounding() {
        assertEquals("3,14 €", formatter.formatPrice(3.141));
        assertEquals("3,15 €", formatter.formatPrice(3.146));
    }

    @Test
    public void testZeroDecimalOmitted() {
        assertEquals("100 €", formatter.formatPrice(100.00));
        assertEquals("0 €", formatter.formatPrice(0.00));
    }

    @Test
    public void testEuroSymbolAtEnd() {
        String result = formatter.formatPrice(15.50);
        assertEquals("15,50 €", result);
    }
}
