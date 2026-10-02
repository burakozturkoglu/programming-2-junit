

import org.junit.jupiter.api.Test;

import refactoring.DayOfYear;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DayOfYearTest {

    @Test
    public void testFirstDayOfYear() {
        assertEquals(1, DayOfYear.dayOfYear(1, 1, 2023));
    }

    @Test
    public void testLastDayOfNonLeapYear() {
    	//2023 is not a leap year
        assertEquals(365, DayOfYear.dayOfYear(12, 31, 2023));
    }

    @Test
    public void testLastDayOfLeapYear() {
    	// 2024 is a leap year
        assertEquals(366, DayOfYear.dayOfYear(12, 31, 2024));
    }

    @Test
    public void testLeapYearFebruary29() {
        // 2024 is a leap year
        assertEquals(60, DayOfYear.dayOfYear(2, 29, 2024));
    }

    @Test
    public void testMarch1stInLeapAndNonLeapYear() {
        // In a normal year 1st March is the 60th day
        assertEquals(60, DayOfYear.dayOfYear(3, 1, 2023));
        // In a leap year 1st March is 61th day
        assertEquals(61, DayOfYear.dayOfYear(3, 1, 2024));
    }

    @Test
    public void testLeapYearRulesCenturyYears() {
        // 1900 is not leap year
        assertEquals(365, DayOfYear.dayOfYear(12, 31, 1900));
        // 2000 is a leap year
        assertEquals(366, DayOfYear.dayOfYear(12, 31, 2000));
    }

    @Test
    public void testInvalidMonthOrDayThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> DayOfYear.dayOfYear(0, 15, 2023));
        assertThrows(IllegalArgumentException.class, () -> DayOfYear.dayOfYear(13, 15, 2023));
        assertThrows(IllegalArgumentException.class, () -> DayOfYear.dayOfYear(5, 0, 2023));
        assertThrows(IllegalArgumentException.class, () -> DayOfYear.dayOfYear(5, 32, 2023));
    }
}
