package pl.mazurmarcin.webcalculator.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class CurrencyUtilsTest {

	private CurrencyUtilsImpl currencyUtilsImpl = new CurrencyUtilsImpl();

	@Test
	void shouldDownloadCurrencyArray() throws JSONException, IOException {

		JSONArray jsonArray = currencyUtilsImpl.downloadCurrencyArray();
		assertNotNull(jsonArray);
		assertTrue(jsonArray.length() == 2);

	}

	@Test
	void shouldCreatePolishCurrency() {

		Currency currency = currencyUtilsImpl.createPolishCurrency();

		assertEquals("PLN", currency.getCode());
		assertEquals("Polski Złoty", currency.getCurrencyName());
		assertEquals("1.0000", currency.getMid());
		assertEquals("1.0000", currency.getPrevMid());
	}

	@Test
	void shouldExtractCurrencyFromJsonObject() throws JSONException {

		JSONObject jsonObject11 = new JSONObject("{\"code\":\"PLN\",\"currency\":\"Polski Złoty\",\"mid\":\"1.0000\"}");
		JSONObject jsonObject12 = new JSONObject("{\"code\":\"PLN\",\"currency\":\"Polski Złoty\",\"mid\":\"1.1000\"}");

		Currency currency = currencyUtilsImpl.extractCurrencyFromJsonObject(jsonObject11, jsonObject12);

		assertEquals("PLN", currency.getCode());
		assertEquals("Polski Złoty", currency.getCurrencyName());
		assertEquals("1.1000", currency.getMid());
		assertEquals("1.0000", currency.getPrevMid());

	}

	@Test
	void shouldRecalculateCurrency() {

		List<Currency> currencyList = new ArrayList<>();

		Currency currency = new Currency("PLN", "Polski Złoty", "1.1000", "1.0000");
		currencyList.add(currency);

		currency = new Currency("EUR", "Euro", "4.1234", "4.1222");
		currencyList.add(currency);

		currency = new Currency("GBP", "Pound", "4.7434", "4.7222");
		currencyList.add(currency);

		currencyUtilsImpl.recalculateCurrency(currencyList, "EUR");

		assertTrue(currencyList.size() == 3);

		assertEquals("0.2668", currencyList.get(0).getMid());
		assertEquals("0.2426", currencyList.get(0).getPrevMid());

		assertEquals("1.0000", currencyList.get(1).getMid());
		assertEquals("1.0000", currencyList.get(1).getPrevMid());

		assertEquals("1.1504", currencyList.get(2).getMid());
		assertEquals("1.1456", currencyList.get(2).getPrevMid());

	}

	@Test
	void shouldAddCurrencyStatus() {

		List<Currency> currencyList = new ArrayList<>();

		Currency currency = new Currency("PLN", "Polski Złoty", "1.1000", "1.0000");
		currencyList.add(currency);

		currency = new Currency("EUR", "Euro", "4.1234", "4.1222");
		currencyList.add(currency);

		currency = new Currency("GBP", "Pound", "4.7134", "4.7222");
		currencyList.add(currency);

		currencyUtilsImpl.addCurrencyStatus(currencyList);

		assertEquals("plus", currencyList.get(0).getStatus());
		assertEquals("plus", currencyList.get(1).getStatus());
		assertEquals("minus", currencyList.get(2).getStatus());

	}

	@Test
	void shouldReturnCurrencyList() throws JSONException, IOException {

		List<Currency> currencyList = currencyUtilsImpl.getCurrencyList("PLN");

		assertEquals(36, currencyList.size());
		assertEquals("PLN", currencyList.get(0).getCode());
		assertEquals("1.0000", currencyList.get(0).getMid());

	}

}
