package pl.mazurmarcin.webcalculator.utils;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

/**
 * Interface used to download JSON Array with currencies from NBP.PL and
 * transform it into the List of Currency objects.
 * 
 * @author Marcin Mazur
 *
 */
public interface CurrencyUtils {

	/**
	 * Returns the list of the Currency for given currency code
	 * 
	 * @param selectedCurrencyCode
	 *            The String containing the code of the currency
	 * @return A The List&lt;Currency&gt; representing the list of currencies
	 * @throws JSONException
	 *             A JSONException is thrown when the JSONObject is not able to
	 *             return requested value
	 * @throws IOException
	 *             A IOException is thrown then the JSONArray is not able to be
	 *             download
	 */
	List<Currency> getCurrencyList(String selectedCurrencyCode) throws JSONException, IOException;

}
