package pl.mazurmarcin.webcalculator.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.json.JSONException;

import pl.mazurmarcin.webcalculator.utils.Currency;

public interface CalculatorsService {

	double[] calculateSquare(String paramName, Double paramValue);

	double[] calculateRectangle(String paramName, Double paramValue1, Double paramValue2);

	BigDecimal[] calculateLength(String inputId, String inputValue);

	BigDecimal[] calculateWeight(String inputId, String inputValue);

	BigDecimal[] calculateArea(String inputId, String inputValue);

	List<Currency> calculateCurrency(String selectedCurrencyCode) throws JSONException, IOException;

	String calculatePercentage(int operationNumber, double paramValue1, double paramValue2);

}
