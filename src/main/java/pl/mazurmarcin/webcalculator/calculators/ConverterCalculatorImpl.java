package pl.mazurmarcin.webcalculator.calculators;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

/**
 * Utility class used to perform calculation for unit converter
 * 
 * @author Marcin Mazur
 *
 */
@Component
public class ConverterCalculatorImpl implements ConverterCalculator {

	private final Length[] ORDERED_LENGTHS = { Length.MILLIMETER, Length.CENTIMETER, Length.METER, Length.KILOMETER,
			Length.INCH, Length.FOOT, Length.YARD, Length.MILE, Length.NAUTICA_MILE, Length.ASTRONOMICAL_UNIT,
			Length.LIGHT_YEAR, Length.PARSEC };

	private final Weight[] ORDERED_WEIGHTS = { Weight.MILLIGRAM, Weight.GRAM, Weight.DEKAGRAM, Weight.KILOGRAM,
			Weight.TON, Weight.OUNCE, Weight.POUND, Weight.SHORT_TON, Weight.LONG_TON, Weight.GRAIN, Weight.CENTAL,
			Weight.CARAT };

	private final Area[] ORDERED_AREAS = { Area.SQUARE_MILLIMETER, Area.SQUARE_CENTIMETER, Area.SQUARE_DECIMETER,
			Area.SQUARE_METER, Area.SQUARE_KILOMETER, Area.AR, Area.HECTARE, Area.SQUARE_INCH, Area.SQUARE_FOOT,
			Area.SQUARE_YARD, Area.SQUARE_MILE, Area.ACRE };

	@Override
	public BigDecimal[] calculateLength(String inputId, String inputValue) {

		BigDecimal[] resultSet = new BigDecimal[12];
		BigDecimal meter = null;
		BigDecimal inputValueBd = new BigDecimal(inputValue);

		for (Length length : ORDERED_LENGTHS) {
			if (inputId.contains(length.getDescription()))
				meter = inputValueBd.multiply(new BigDecimal(length.getValue()));
		}

		if (meter == null)
			meter = new BigDecimal("0.00");

		int scale = 10;
		for (int i = 0; i < resultSet.length; i++) {
			if (i == 9)
				scale = 30;
			resultSet[i] = meter.divide(new BigDecimal(ORDERED_LENGTHS[i].getValue()), scale, RoundingMode.HALF_UP);
		}

		resultSet[2] = meter;

		return resultSet;

	}

	@Override
	public BigDecimal[] calculateWeight(String inputId, String inputValue) {

		BigDecimal[] resultSet = new BigDecimal[12];
		BigDecimal kilogram = null;
		BigDecimal inputValueBd = new BigDecimal(inputValue);

		for (Weight weight : ORDERED_WEIGHTS) {
			if (inputId.contains(weight.getDescription()))
				kilogram = inputValueBd.multiply(new BigDecimal(weight.getValue()));
		}

		if (kilogram == null)
			kilogram = new BigDecimal("0.00");

		int scale = 10;
		for (int i = 0; i < resultSet.length; i++)
			resultSet[i] = kilogram.divide(new BigDecimal(ORDERED_WEIGHTS[i].getValue()), scale, RoundingMode.HALF_UP);

		resultSet[3] = kilogram;

		return resultSet;

	}

	@Override
	public BigDecimal[] calculateArea(String inputId, String inputValue) {

		BigDecimal[] resultSet = new BigDecimal[12];
		BigDecimal squareMeter = null;
		BigDecimal inputValueBd = new BigDecimal(inputValue);

		for (Area area : ORDERED_AREAS) {
			if (inputId.contains(area.getDescription()))
				squareMeter = inputValueBd.multiply(new BigDecimal(area.getValue()));
		}

		int scale = 10;
		for (int i = 0; i < resultSet.length; i++)
			resultSet[0] = squareMeter.divide(new BigDecimal(ORDERED_AREAS[i].getValue()), scale, RoundingMode.HALF_UP);

		resultSet[3] = squareMeter;

		return resultSet;

	}

}
