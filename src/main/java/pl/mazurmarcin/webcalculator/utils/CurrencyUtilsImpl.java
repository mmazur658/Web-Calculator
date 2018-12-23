package pl.mazurmarcin.webcalculator.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * Utility class used to download JSON Array with currencies from NBP.PL and
 * transform it into the List of Currency objects.
 * 
 * @author Marcin Mazur
 *
 */
@Component
public class CurrencyUtilsImpl implements CurrencyUtils {

	/**
	 * Downloads and returns the JSONArray with the currencies.
	 * 
	 * URL: "http://api.nbp.pl/api/exchangerates/tables/a/last/2/"
	 * 
	 * @return A JSONArray representing the downloaded JSONArray with currencies
	 * @throws JSONException
	 *             A JSONException is thrown when the String is not able to be
	 *             parsed to JSONArray
	 * @throws IOException
	 *             A IOException is thrown when the method is not able to download
	 *             the JSONArray from API
	 */
	public JSONArray downloadCurrencyArray() throws JSONException, IOException {

		URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/a/last/2/");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		InputStream is = connection.getInputStream();

		BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		StringBuilder responseStrBuilder = new StringBuilder();

		String inputStr;
		while ((inputStr = streamReader.readLine()) != null)
			responseStrBuilder.append(inputStr);

		JSONArray jsonArray = new JSONArray(responseStrBuilder.toString());
		is.close();

		return jsonArray;
	}

	/**
	 * Creates and returns a Currency object dedicated to Polish currency
	 * 
	 * @return The Currency representing the Polish currency
	 */
	public Currency createPolishCurrency() {

		Currency currency = new Currency();
		currency.setCode("PLN");
		currency.setCurrencyName("Polski Złoty");
		currency.setMid("1.0000");
		currency.setPrevMid("1.0000");

		return currency;
	}

	/**
	 * Returns a Currency extracted from JSON Objects.
	 * 
	 * @param jsonObject11
	 *            The JSONObject containing the present values of currency
	 * @param jsonObject12
	 *            The JSONObject containing the previous values of currency
	 * @return A Currency representing the Currency extracted from JSON Objects.
	 * @throws JSONException
	 *             A JSONException is thrown when the JSONObject is not able to
	 *             return requested value
	 */
	public Currency extractCurrencyFromJsonObject(JSONObject jsonObject11, JSONObject jsonObject12)
			throws JSONException {

		BigDecimal bgTemp;
		Currency currency = new Currency();

		currency.setCode(jsonObject12.get("code").toString());
		currency.setCurrencyName(jsonObject12.get("currency").toString());

		bgTemp = new BigDecimal(jsonObject12.get("mid").toString());
		bgTemp = bgTemp.setScale(4, RoundingMode.HALF_UP);
		currency.setMid(String.valueOf(bgTemp));

		bgTemp = new BigDecimal(jsonObject11.get("mid").toString());
		bgTemp = bgTemp.setScale(4, RoundingMode.HALF_UP);
		currency.setPrevMid(String.valueOf(bgTemp));

		return currency;
	}

	/**
	 * Converts the list of Currency according to the given code.
	 * 
	 * @param currencyList
	 *            The List&lt;Currency&gt; containing the list to be converted
	 * @param selectedCurrencyCode
	 *            The String containing the code of the currency
	 */
	public void recalculateCurrency(List<Currency> currencyList, String selectedCurrencyCode) {

		if (!selectedCurrencyCode.equals("PLN")) {

			double prevMid = 0;
			double mid = 0;
			double tempVal;
			for (Currency c : currencyList) {
				if (c.getCode().equals(selectedCurrencyCode)) {
					prevMid = Double.valueOf(c.getPrevMid());
					mid = Double.valueOf(c.getMid());
				}
			}

			if (prevMid != 0) {
				for (Currency c : currencyList) {
					tempVal = Double.valueOf(c.getMid()) / mid;
					c.setMid(String.valueOf(new BigDecimal(tempVal).setScale(4, RoundingMode.HALF_UP)));

					tempVal = Double.valueOf(c.getPrevMid()) / prevMid;
					c.setPrevMid(String.valueOf(new BigDecimal(tempVal).setScale(4, RoundingMode.HALF_UP)));
				}
			}
		}
	}

	/**
	 * Adds status of the currency to every element of the given list.<br>
	 * The status determines whether the value of the currency has increased or
	 * decreased.
	 * 
	 * @param currencyList
	 *            The List&lt;Currency&gt; containing the list of currencies
	 */
	void addCurrencyStatus(List<Currency> currencyList) {

		double change2;
		double change1;
		BigDecimal bgTemp;

		for (Currency c : currencyList) {
			change1 = Double.valueOf(c.getPrevMid());
			change2 = Double.valueOf(c.getMid());

			bgTemp = new BigDecimal(change2 - change1);
			bgTemp = bgTemp.setScale(6, RoundingMode.HALF_UP);
			c.setChange(String.valueOf(bgTemp));

			bgTemp = new BigDecimal(((change2 - change1) / change2) * 100);
			bgTemp = bgTemp.setScale(6, RoundingMode.HALF_UP);
			c.setPercentageChange(String.valueOf(bgTemp));

			c.setStatus((change2 - change1) >= 0 ? "plus" : "minus");
		}
	}

	@Override
	public List<Currency> getCurrencyList(String selectedCurrencyCode) throws JSONException, IOException {

		// download the JSONArray with the currencies
		JSONArray jsonArray = downloadCurrencyArray();

		// Separate JSONArray into to 2 arrays, first with current currencies and the
		// second with the previous currencies
		JSONObject jsonObject1 = jsonArray.getJSONObject(0);
		JSONObject jsonObject2 = jsonArray.getJSONObject(1);
		JSONArray jsonArray1 = jsonObject1.optJSONArray("rates");
		JSONArray jsonArray2 = jsonObject2.optJSONArray("rates");

		List<Currency> currencyList = new ArrayList<>();

		// add Polish currency to the list
		currencyList.add(createPolishCurrency());

		// extract currencies form the JSON objects and add them to the list
		JSONObject jsonObject11;
		JSONObject jsonObject12;

		for (int i = 0; i < jsonArray1.length(); i++) {
			jsonObject11 = jsonArray1.getJSONObject(i);
			jsonObject12 = jsonArray2.getJSONObject(i);
			currencyList.add(extractCurrencyFromJsonObject(jsonObject11, jsonObject12));
		}

		if (selectedCurrencyCode == null)
			selectedCurrencyCode = "PLN";

		recalculateCurrency(currencyList, selectedCurrencyCode);
		addCurrencyStatus(currencyList);

		return currencyList;
	}
}