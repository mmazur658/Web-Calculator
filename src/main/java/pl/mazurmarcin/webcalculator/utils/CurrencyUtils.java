package pl.mazurmarcin.webcalculator.utils;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

public interface CurrencyUtils {

	List<Currency> getCurrencyList(String selectedCurrencyCode) throws JSONException, IOException;

}
