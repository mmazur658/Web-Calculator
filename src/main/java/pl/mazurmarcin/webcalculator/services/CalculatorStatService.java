package pl.mazurmarcin.webcalculator.services;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

/**
 * Interface for managing statistics of the calculators.
 * 
 * @author Marcin Mazur
 *
 */
public interface CalculatorStatService {

	/**
	 * Saves the caculatorStat with given name
	 * 
	 * @param calcName
	 *            The String containing the name of the calculator
	 * @throws ParseException
	 *             A ParseException is thrown when the given String is not able to
	 *             be parsed to the Date.
	 */
	void saveCalculatorStat(String calcName) throws ParseException;

	/**
	 * Returns the specified number of date and the number of calculator usage for
	 * given date range.
	 * 
	 * @param startDate
	 *            The String containing the first day of the range
	 * @param endDate
	 *            The String containing the last day of the range
	 * @param resultRange
	 *            The long containing the number of returning results
	 * @param locale
	 *            The Locale containing the user`s locale
	 * @return A List&lt;Object[]&gt; representing the date and the number of
	 *         calculator usage
	 */
	List<Object[]> getTopXCalculatorStatsForGivenDateRange(String startDate, String endDate, long resultRange,
			Locale locale);

	/**
	 * Returns the result set of the general statistic of all calculators
	 * 
	 * @return A long[] representing the result set of the general statistic of all
	 *         calculators
	 */
	long[] getGeneralStatisticsResultSet();

	/**
	 * Returns the result set of the general statistic for given calculator name
	 * 
	 * @param calculatorName
	 *            The String containing the name of the calculator
	 * @return A String[] representing the result set of the general statistic for
	 *         given calculator name
	 */
	String[] getSelectedCalculatorGeneralStatistics(String calculatorName);

	/**
	 * Returns the monthly statistics for the given calculator name and date range.
	 * 
	 * @param calculatorName
	 *            The String containing the name of the calculator
	 * @param startDate
	 *            The String containing the first day of the range
	 * @param endDate
	 *            The String containing the last day of the range
	 * @param monthLength
	 *            The int containing the length of the month
	 * @return A List&lt;Object[]&gt; representing the monthly statistic data
	 */
	List<Object[]> getSelectedCalculatorMonthlyData(String calculatorName, String startDate, String endDate,
			int monthLength);

}
