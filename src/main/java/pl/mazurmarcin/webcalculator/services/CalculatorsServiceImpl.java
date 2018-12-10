package pl.mazurmarcin.webcalculator.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.mazurmarcin.webcalculator.calculators.ConverterCalculator;
import pl.mazurmarcin.webcalculator.calculators.GeometryCalculator;
import pl.mazurmarcin.webcalculator.calculators.PercentageCalculator;
import pl.mazurmarcin.webcalculator.utils.Currency;
import pl.mazurmarcin.webcalculator.utils.CurrencyUtils;

/**
 * Service class for managing calculations.
 * 
 * @author Marcin Mazur
 *
 */
@Service
public class CalculatorsServiceImpl implements CalculatorsService {

	/**
	 * The GeometryCalculator interface
	 */
	private GeometryCalculator geometryCalculator;

	/**
	 * The ConverterCalculator interface
	 */
	private ConverterCalculator converterCalculator;

	/**
	 * The CurrencyUtils interface
	 */
	private CurrencyUtils currencyUtils;

	/**
	 * The PercentageCalculator interface
	 */
	private PercentageCalculator percentageCalculator;

	/**
	 * Constructs a CalculatorsServiceImpl with the GeometryCalculator,
	 * ConverterCalculator, PercentageCalculator and CurrencyUtils.
	 * 
	 * @param geometryCalculator
	 *            The GeometryCalculator interface
	 * @param converterCalculator
	 *            The ConverterCalculator interface
	 * @param currencyUtils
	 *            The CurrencyUtils interface
	 * @param percentageCalculator
	 *            The PercentageCalculator interface
	 */
	@Autowired
	public CalculatorsServiceImpl(GeometryCalculator geometryCalculator, ConverterCalculator converterCalculator,
			CurrencyUtils currencyUtils, PercentageCalculator percentageCalculator) {
		this.geometryCalculator = geometryCalculator;
		this.converterCalculator = converterCalculator;
		this.currencyUtils = currencyUtils;
		this.percentageCalculator = percentageCalculator;
	}


	@Override
	public double[] calculateSquare(String paramName, Double paramValue) {
		return geometryCalculator.calculateSquare(paramName, paramValue);
	}


	@Override
	public double[] calculateRectangle(String paramName, Double paramValue1, Double paramValue2) {
		return geometryCalculator.calculateRectangle(paramName, paramValue1, paramValue2);
	}


	@Override
	public BigDecimal[] calculateLength(String inputId, String inputValue) {
		return converterCalculator.calculateLength(inputId, inputValue);
	}


	@Override
	public BigDecimal[] calculateWeight(String inputId, String inputValue) {
		return converterCalculator.calculateWeight(inputId, inputValue);
	}


	@Override
	public BigDecimal[] calculateArea(String inputId, String inputValue) {
		return converterCalculator.calculateArea(inputId, inputValue);
	}


	@Override
	public List<Currency> calculateCurrency(String selectedCurrencyCode) throws JSONException, IOException {
		return currencyUtils.getCurrencyList(selectedCurrencyCode);
	}


	@Override
	public String calculatePercentage(int operationNumber, double paramValue1, double paramValue2) {
		return percentageCalculator.calculatePercentge(operationNumber, paramValue1, paramValue2);
	}

}
