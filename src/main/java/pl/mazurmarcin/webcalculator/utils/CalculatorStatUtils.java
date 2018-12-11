package pl.mazurmarcin.webcalculator.utils;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import pl.mazurmarcin.webcalculator.entity.CalculatorStat;

/**
 * Interface used to perform operations on calculator statistics
 * 
 * @author Marcin Mazur
 *
 */
public interface CalculatorStatUtils {

	/**
	 * Creates and returns the CalculatorStat with given name
	 * 
	 * @param calcName
	 *            The String containing the name of the calculator
	 * @return A CalculatorStat representing the CalculatorStat object
	 * @throws ParseException A ParseException is thrown when the String can't be parsed to Date
	 */
	CalculatorStat createNewCalculatorStat(String calcName) throws ParseException;

	/**
	 * Prepares the list of statistics to display, <br>
	 * The list must contains the number of elements no less then resultRange. <br>
	 * If the resultRange = 999 than the list can contain any number of elements
	 * 
	 * @param resultList
	 *            The List&lt;Object[]&gt; containing the list to be
	 * @param resultRange
	 *            The long containing the number of results to be returned
	 * @param locale
	 *            The Locale containing the user`s locale data
	 */
	void prepareListForDisplay(List<Object[]> resultList, long resultRange, Locale locale);

	/**
	 * Returns the date minus given value
	 * 
	 * @param value
	 *            The int containing the value
	 * @return A String representing the new date
	 */
	String getDateMinusGivenValue(int value);

	/**
	 * Returns the current date. Format: yyyy-MM-dd hh:mm:ss.S
	 * 
	 * @return A string representing the current date
	 */
	String getToday();

	/**
	 * Creates and return the list of monthly statistics ready to display
	 * 
	 * @param resultList
	 *            The List&lt;Object[]&gt; containing the list of
	 * @param monthLength
	 *            The int containing the length of the month
	 * @return A List&lt;Object[]&gt; representing the list of monthly statistics
	 *         ready to display
	 */
	List<Object[]> createListToDisplay(List<Object[]> resultList, int monthLength);

}
