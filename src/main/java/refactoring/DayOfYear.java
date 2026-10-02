package refactoring;

/**
 * Smelly Example #1
 *
 * https://web.mit.edu/6.005/www/fa16/classes/04-code-review/
 *
 * Collaboratively authored with contributions from: Saman Amarasinghe, Adam
 * Chlipala, Srini Devadas, Michael Ernst, Max Goldman, John Guttag, Daniel
 * Jackson, Rob Miller, Martin Rinard, and Armando Solar-Lezama.
 *
 * This work is licensed under CC BY-SA 4.0.
 */
public class DayOfYear {
	
	public static void main (String [] args)
	{
		
	}

    /**
     * "The day of year (DOY) is the sequential day number starting with day 1 on
     * January 1st."
     *
     * https://nsidc.org/data/user-resources/help-center/day-year-doy-calendar
     *
     * This method calculates the day of the year (1-366) that corresponds to the
     * given month, day of month, and year. January 1st is day 1 of the year and
     * December 31st is day 365 (or 366 in a leap year).
     *
     * @param month      the month (1-12)
     * @param dayOfMonth the day of the month (1-31)
     * @param year       the year
     * @return the day of the year (1-366)
     */
    public static int dayOfYear(int month, int dayOfMonth, int year) {
        /*
         * You are expected to change this method in the exercise in order to fix the
         * bugs in it. You are also expected to improve the method's structure and
         * style to make it more readable and maintainable.
         *
         * You are allowed to throw runtime exceptions, such as
         * IllegalArgumentException, if the inputs are invalid.
         *
         * However, you are *not* allowed to change the method signature (name,
         * parameters, return type).
         */

    	if (month < 1 || month > 12 || dayOfMonth < 1 || dayOfMonth > 31) {
            throw new IllegalArgumentException("Invalid month or day");
        }

        int[] daysInMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if (isLeapYear) {
            daysInMonths[1] = 29;
        }

        int dayOfYear = dayOfMonth;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonths[i];
        }

        return dayOfYear;
    }
}
