package pl.mazurmarcin.webcalculator.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.json.JSONException;

import pl.mazurmarcin.webcalculator.utils.Currency;

/**
 * Interface for managing calculations.
 * 
 * @author Marcin Mazur
 *
 */
public interface CalculatorsService {

	/**
	 * Square Calculator. <br>
	 * <br>
	 * Returns the set of the result as a double[] for given paramName and
	 * paramValue.
	 * 
	 * @param paramName
	 *            The String containing the name of calculation type
	 * @param paramValue
	 *            The String containing the value to be calculated
	 * @return A double[] representing the set of results
	 */
	double[] calculateSquare(String paramName, Double paramValue);

	/**
	 * Rectangle Calculator. <br>
	 * <br>
	 * Returns the set of the result as a double[] for given paramName and
	 * paramValue.
	 * 
	 * @param paramName
	 *            The String containing the name of calculation type
	 * @param paramValue1
	 *            The String containing the first value to be calculated
	 * @param paramValue2
	 *            The String containing the second value to be calculated
	 * @return A double[] representing the set of results
	 */
	double[] calculateRectangle(String paramName, Double paramValue1, Double paramValue2);

	/**
	 * Unit converter: Length <br>
	 * <br>
	 * Returns the set of the result as a BigDecimal[] for given calculator id and
	 * inputValue
	 * 
	 * inputId determines what kind of calculations should be performed
	 * 
	 * @param inputId
	 *            The String containing the id of type of calculation
	 * @param inputValue
	 *            The String containing the value to be calculated
	 * @return A BigDecimal[] representing the set of results
	 */
	BigDecimal[] calculateLength(String inputId, String inputValue);

	/**
	 * Unit converter: Weight <br>
	 * <br>
	 * Returns the set of the result as a BigDecimal[] for given calculator id and
	 * inputValue
	 * 
	 * inputId determines what kind of calculations should be performed
	 * 
	 * @param inputId
	 *            The String containing the id of type of calculation
	 * @param inputValue
	 *            The String containing the value to be calculated
	 * @return A BigDecimal[] representing the set of results
	 */
	BigDecimal[] calculateWeight(String inputId, String inputValue);

	/**
	 * Unit converter: Area <br>
	 * <br>
	 * Returns the set of the result as a BigDecimal[] for given calculator id and
	 * inputValue
	 * 
	 * inputId determines what kind of calculations should be performed
	 * 
	 * @param inputId
	 *            The String containing the id of type of calculation
	 * @param inputValue
	 *            The String containing the value to be calculated
	 * @return A BigDecimal[] representing the set of results
	 */
	BigDecimal[] calculateArea(String inputId, String inputValue);

	/**
	 * Returns the list of the Currency for given currency code
	 * 
	 * @param selectedCurrencyCode
	 *            The String containing the code of the currency
	 * @return A List&lt;Currency&gt; representing the list of the currencies
	 * @throws JSONException
	 *             A JSONException is thrown when downloaded string can't be parsed
	 *             to the JSONArray
	 * @throws IOException
	 *             A IOException is thrown when the method can't download the
	 *             currency table
	 */
	List<Currency> calculateCurrency(String selectedCurrencyCode) throws JSONException, IOException;

	/**
	 * Returns the result for given values and operation number.
	 * 
	 * @param operationNumber
	 *            The int containing the number of the operation type
	 * @param paramValue1
	 *            The double containing the first value to be calculated
	 * @param paramValue2
	 *            The double containing the second value to be calculated
	 * @return A String representing the result
	 */
	String calculatePercentage(int operationNumber, double paramValue1, double paramValue2);

}
