package pl.mazurmarcin.webcalculator.calculators;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component
public class ConverterCalculatorImpl implements ConverterCalculator {

	@Override
	public BigDecimal[] calculateLength(String inputId, String inputValue) {

		/*
		 * input ids 0 – millimeter, 1 – centimeter, 2 – meter, 3 – kilometer, 4 – inch,
		 * 5 – foot, 6 – yard, 7 – mile, 8 - nautica-mile, 9 - astronomical-unit, 10 -
		 * light-year, 11 - parsec
		 *
		 * "#length-parsec","#length-light-year","#length-astronomical-unit",
		 * "#length-nautica-mile","#length-yard","#length-mile","#length-foot",
		 * "#length-inch","#length-kilometer","#length-meter","#length-centimeter",
		 * "#length-millimeter"];
		 */

		BigDecimal[] resultSet = new BigDecimal[12];

		BigDecimal meter;
		BigDecimal inputValueBd = new BigDecimal(inputValue);

		if (inputId.equals("#length-parsec"))
			meter = inputValueBd.multiply(new BigDecimal("30857000000000000"));
		else if (inputId.equals("#length-light-year"))
			meter = inputValueBd.multiply(new BigDecimal("9460600000000000"));
		else if (inputId.equals("#length-astronomical-unit"))
			meter = inputValueBd.multiply(new BigDecimal("149597870700"));
		else if (inputId.equals("#length-nautica-mile"))
			meter = inputValueBd.multiply(new BigDecimal("1852"));
		else if (inputId.equals("#length-yard"))
			meter = inputValueBd.multiply(new BigDecimal("0.9144"));
		else if (inputId.equals("#length-mile"))
			meter = inputValueBd.multiply(new BigDecimal("1609.344"));
		else if (inputId.equals("#length-foot"))
			meter = inputValueBd.multiply(new BigDecimal("0.3048"));
		else if (inputId.equals("#length-inch"))
			meter = inputValueBd.multiply(new BigDecimal("0.0254"));
		else if (inputId.equals("#length-kilometer"))
			meter = inputValueBd.multiply(new BigDecimal("1000"));
		else if (inputId.equals("#length-meter"))
			meter = inputValueBd.multiply(new BigDecimal("1"));
		else if (inputId.equals("#length-centimeter"))
			meter = inputValueBd.multiply(new BigDecimal("0.01"));
		else if (inputId.equals("#length-millimeter"))
			meter = inputValueBd.multiply(new BigDecimal("0.001"));
		else
			meter = new BigDecimal("0.00");

		resultSet[0] = meter.divide(new BigDecimal("0.001"), 10, RoundingMode.HALF_UP);
		resultSet[1] = meter.divide(new BigDecimal("0.01"), 10, RoundingMode.HALF_UP);
		resultSet[2] = meter;
		resultSet[3] = meter.divide(new BigDecimal("1000"), 10, RoundingMode.HALF_UP);
		resultSet[4] = meter.divide(new BigDecimal("0.0254"), 10, RoundingMode.HALF_UP);
		resultSet[5] = meter.divide(new BigDecimal("0.3048"), 10, RoundingMode.HALF_UP);
		resultSet[6] = meter.divide(new BigDecimal("0.9144"), 10, RoundingMode.HALF_UP);
		resultSet[7] = meter.divide(new BigDecimal("1609.344"), 10, RoundingMode.HALF_UP);
		resultSet[8] = meter.divide(new BigDecimal("1852"), 10, RoundingMode.HALF_UP);
		resultSet[9] = meter.divide(new BigDecimal("149597870700"), 30, RoundingMode.HALF_UP);
		resultSet[10] = meter.divide(new BigDecimal("9460600000000000"), 30, RoundingMode.HALF_UP);
		resultSet[11] = meter.divide(new BigDecimal("30857000000000000"), 30, RoundingMode.HALF_UP);

		return resultSet;

	}

	@Override
	public BigDecimal[] calculateWeight(String inputId, String inputValue) {

		/*
		 * input ids 0 – milligram, 1 – gram, 2 – dekagram, 3 – kilogram, 4 – ton, 5 –
		 * ounce, 6 –pound, 7 - short-ton, 8 - long-ton, 9 – grain, 10 – cental, 11 -
		 * carat
		 * 
		 * "#weight-milligram","#weight-gram","#weight-dekagram","#weight-kilogram",
		 * "#weight-ton","#weight-ounce","#weight-pound","#weight-short-ton",
		 * "#weight-long-ton","#weight-grain","#weight-cental","#weight-carat"
		 */

		BigDecimal[] resultSet = new BigDecimal[12];
		BigDecimal kilogram;
		BigDecimal inputValueBd = new BigDecimal(inputValue);

		if (inputId.equals("#weight-milligram"))
			kilogram = inputValueBd.multiply(new BigDecimal("0.000001"));
		else if (inputId.equals("#weight-gram"))
			kilogram = inputValueBd.multiply(new BigDecimal("0.001"));
		else if (inputId.equals("#weight-dekagram"))
			kilogram = inputValueBd.multiply(new BigDecimal("0.01"));
		else if (inputId.equals("#weight-kilogram"))
			kilogram = inputValueBd.multiply(new BigDecimal("1"));
		else if (inputId.equals("#weight-ton"))
			kilogram = inputValueBd.multiply(new BigDecimal("1000"));
		else if (inputId.equals("#weight-ounce"))
			kilogram = inputValueBd.multiply(new BigDecimal("0.028349523"));
		else if (inputId.equals("#weight-pound"))
			kilogram = inputValueBd.multiply(new BigDecimal("0.45359237"));
		else if (inputId.equals("#weight-short-ton"))
			kilogram = inputValueBd.multiply(new BigDecimal("907.18474"));
		else if (inputId.equals("#weight-long-ton"))
			kilogram = inputValueBd.multiply(new BigDecimal("1016.0469088"));
		else if (inputId.equals("#weight-grain"))
			kilogram = inputValueBd.multiply(new BigDecimal("0.00006479891"));
		else if (inputId.equals("#weight-cental"))
			kilogram = inputValueBd.multiply(new BigDecimal("100"));
		else if (inputId.equals("#weight-carat"))
			kilogram = inputValueBd.multiply(new BigDecimal("0.0002"));
		else
			kilogram = new BigDecimal("0.00");

		resultSet[0] = kilogram.divide(new BigDecimal("0.000001"), 10, RoundingMode.HALF_UP);
		resultSet[1] = kilogram.divide(new BigDecimal("0.001"), 10, RoundingMode.HALF_UP);
		resultSet[2] = kilogram.divide(new BigDecimal("0.01"), 10, RoundingMode.HALF_UP);
		resultSet[3] = kilogram;
		resultSet[4] = kilogram.divide(new BigDecimal("1000"), 10, RoundingMode.HALF_UP);
		resultSet[5] = kilogram.divide(new BigDecimal("0.028349523"), 10, RoundingMode.HALF_UP);
		resultSet[6] = kilogram.divide(new BigDecimal("0.45359237"), 10, RoundingMode.HALF_UP);
		resultSet[7] = kilogram.divide(new BigDecimal("907.18474"), 10, RoundingMode.HALF_UP);
		resultSet[8] = kilogram.divide(new BigDecimal("1016.0469088"), 10, RoundingMode.HALF_UP);
		resultSet[9] = kilogram.divide(new BigDecimal("0.00006479891"), 10, RoundingMode.HALF_UP);
		resultSet[10] = kilogram.divide(new BigDecimal("100"), 10, RoundingMode.HALF_UP);
		resultSet[11] = kilogram.divide(new BigDecimal("0.0002"), 10, RoundingMode.HALF_UP);

		return resultSet;

	}

	@Override
	public BigDecimal[] calculateArea(String inputId, String inputValue) {

		/*
		 * input ids 0 – millimeter, 1 – centimeter, 2 – decymeter, 3 - meter 4 –
		 * kilometer, 5 – ar, 6 – hectare, 7 – inch, 8 - foot 9 – yard, 10 – mile, 11 -
		 * acre
		 * 
		 * "#area-millimeter","#area-centimeter","#area-decymeter","#area-meter",
		 * "#area-kilometer","#area-ar","#area-hectare","#area-inch","#area-foot",
		 * "#area-yard","#area-mile","#area-acre"
		 */
		BigDecimal[] resultSet = new BigDecimal[12];
		BigDecimal squareMeter;
		BigDecimal inputValueBd = new BigDecimal(inputValue);

		if (inputId.equals("#area-millimeter"))
			squareMeter = inputValueBd.multiply(new BigDecimal("0.000001"));
		else if (inputId.equals("#area-centimeter"))
			squareMeter = inputValueBd.multiply(new BigDecimal("0.0001"));
		else if (inputId.equals("#area-decymeter"))
			squareMeter = inputValueBd.multiply(new BigDecimal("0.01"));
		else if (inputId.equals("#area-meter"))
			squareMeter = inputValueBd.multiply(new BigDecimal("1"));
		else if (inputId.equals("#area-kilometer"))
			squareMeter = inputValueBd.multiply(new BigDecimal("1000000"));
		else if (inputId.equals("#area-ar"))
			squareMeter = inputValueBd.multiply(new BigDecimal("100"));
		else if (inputId.equals("#area-hectare"))
			squareMeter = inputValueBd.multiply(new BigDecimal("10000"));
		else if (inputId.equals("#area-inch"))
			squareMeter = inputValueBd.multiply(new BigDecimal("0.00064513460025"));
		else if (inputId.equals("#area-foot"))
			squareMeter = inputValueBd.multiply(new BigDecimal("0.09290304"));
		else if (inputId.equals("#area-yard"))
			squareMeter = inputValueBd.multiply(new BigDecimal("0.83612736"));
		else if (inputId.equals("#area-mile"))
			squareMeter = inputValueBd.multiply(new BigDecimal("2589881.10336"));
		else if (inputId.equals("#area-acre"))
			squareMeter = inputValueBd.multiply(new BigDecimal("4046.8564224"));
		else
			squareMeter = new BigDecimal("0.00");

		resultSet[0] = squareMeter.divide(new BigDecimal("0.000001"), 10, RoundingMode.HALF_UP);
		resultSet[1] = squareMeter.divide(new BigDecimal(".0001"), 10, RoundingMode.HALF_UP);
		resultSet[2] = squareMeter.divide(new BigDecimal("0.01"), 10, RoundingMode.HALF_UP);
		resultSet[3] = squareMeter;
		resultSet[4] = squareMeter.divide(new BigDecimal("1000000"), 10, RoundingMode.HALF_UP);
		resultSet[5] = squareMeter.divide(new BigDecimal("100"), 10, RoundingMode.HALF_UP);
		resultSet[6] = squareMeter.divide(new BigDecimal("10000"), 10, RoundingMode.HALF_UP);
		resultSet[7] = squareMeter.divide(new BigDecimal("0.00064513460025"), 10, RoundingMode.HALF_UP);
		resultSet[8] = squareMeter.divide(new BigDecimal("0.09290304"), 10, RoundingMode.HALF_UP);
		resultSet[9] = squareMeter.divide(new BigDecimal("0.83612736"), 10, RoundingMode.HALF_UP);
		resultSet[10] = squareMeter.divide(new BigDecimal("2589881.10336"), 10, RoundingMode.HALF_UP);
		resultSet[11] = squareMeter.divide(new BigDecimal("4046.8564224"), 10, RoundingMode.HALF_UP);

		return resultSet;

	}

}
