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
        assertEquals("10,50 €", formatter.formatPrice(10.50));
    }

    @Test
    public void testThousandsSeparatorWithSpace() {
        // Thousands separator must be exactly a space ' '
        assertEquals("1 000,50 €", formatter.formatPrice(1000.50));
        assertEquals("123 456,79 €", formatter.formatPrice(123456.789));
        assertEquals("1 000 000,00 €".replace(",00", ""), formatter.formatPrice(1000000.0));
        assertEquals("1 000 000 €", formatter.formatPrice(1000000.0));
    }

    @Test
    public void testDecimalSeparatorWithComma() {
        // Decimal separator must be a comma ','
        assertEquals("0,50 €", formatter.formatPrice(0.50));
        assertEquals("12,34 €", formatter.formatPrice(12.34));
    }

    @Test
    public void testDecimalRoundingToNearestCent() {
        // Rounding to the nearest hundredth (cent)
        assertEquals("3,14 €", formatter.formatPrice(3.141));
        assertEquals("3,15 €", formatter.formatPrice(3.146));
        assertEquals("0,01 €", formatter.formatPrice(0.006));
    }

    @Test
    public void testZeroDecimalOmission() {
        // If the decimal part is zero, it must be omitted entirely
        assertEquals("100 €", formatter.formatPrice(100.00));
        assertEquals("0 €", formatter.formatPrice(0.0));
        assertEquals("1 000 €", formatter.formatPrice(1000.0));
    }

    @Test
    public void testEuroSymbolAndPosition() {
        // The Euro symbol € must be placed at the end with a leading space
        String result = formatter.formatPrice(5.0);
        assertEquals("5 €", result);
        assertEquals("12,34 €", formatter.formatPrice(12.34));
    }
}
