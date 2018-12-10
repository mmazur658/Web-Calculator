package pl.mazurmarcin.webcalculator.dao;

import java.util.Date;
import java.util.List;

import pl.mazurmarcin.webcalculator.entity.CalculatorStat;

/**
 * Interface for performing database operations on CalculatorStat objects.
 * 
 * @author Marcin Mazur
 *
 */
public interface ClaculatorStatDao {

	/**
	 * Saves the CalculatorStat object in the database.<br>
	 * <br>
	 * If the object already exists in the database, then increase its count value
	 * by 1.
	 * 
	 * @param calculatorStat
	 *            The CalculatorStat object to be saved
	 */
	void saveCalculatorStat(CalculatorStat calculatorStat);

	/**
	 * Returns the calcName and number of usage as a List of Object[] for given date
	 * range. <br>
	 * The number of the returned calculators is limited by the value of
	 * resultRange. Set resultRange as 999 to get all calculators. StartDate and
	 * endDate must be strings that match the pattern: yyyy-MM-dd HH:mm:ss.S, for
	 * example:<br>
	 * startDate: 2018-12-05 00:00:00.0 <br>
	 * endDate: 2018-12-06 23:59:59.9
	 * 
	 * @param resultRange
	 *            The number of calculators to returned
	 * @param startDate
	 *            The first day of the range
	 * @param endDate
	 *            The last daty of the range
	 * @return The list of Object[]
	 */
	List<Object[]> getTopXCalculatorStatsForGivenDateRange(String startDate, String endDate, long resultRange);

	/**
	 * Returns the number of calculator type
	 * 
	 * @return The number of calculator type
	 */
	long getNumberOfCalculatorsType();

	/**
	 * Returns the number of all calculators usage for given date range. StartDate
	 * and endDate must be strings that match the pattern: yyyy-MM-dd HH:mm:ss.S,
	 * for example:<br>
	 * startDate: 2018-12-05 00:00:00.0 <br>
	 * endDate: 2018-12-06 23:59:59.9
	 * 
	 * @param startDate
	 *            The first day of the range
	 * @param endDate
	 *            The last daty of the range
	 * @return The sum of calculator usage
	 */
	long sumOfCalculationForGivenDateRange(String startDate, String endDate);

	/**
	 * Returns the number of calculator usage as a string for given calculator name
	 * and given date range. StartDate and endDate must be strings that match the
	 * pattern: yyyy-MM-dd HH:mm:ss.S, for example:<br>
	 * startDate: 2018-12-05 00:00:00.0 <br>
	 * endDate: 2018-12-06 23:59:59.9
	 * 
	 * @param startDate
	 *            The first day of the range
	 * @param endDate
	 *            The last daty of the range
	 * @param calculatorName
	 *            The name of the calculator
	 * @return The number of calculator usage as a String
	 */
	String sumOfCalculationOfSelectedCalculatorForGivenDateRange(String startDate, String endDate,
			String calculatorName);

	/**
	 * Returns the date of the first use of the calculator for given calculator
	 * name.
	 * 
	 * @param calculatorName
	 *            The name of the calculator
	 * @return The date of the first use
	 */
	Date getCalculatorFirstUse(String calculatorName);

	/**
	 * Returns date and number of usage as a List of Object[] for given calculator
	 * name and given month.
	 * 
	 * @param calculatorName
	 *            The Calculator name
	 * @param startDate
	 *            The first day of the month
	 * @param endDate
	 *            The last day of the month
	 * @return The list of Object[]
	 */
	List<Object[]> getSelectedCalculatorMonthlyData(String calculatorName, String startDate, String endDate);

}
