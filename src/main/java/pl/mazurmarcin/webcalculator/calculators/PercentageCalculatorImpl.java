package pl.mazurmarcin.webcalculator.calculators;

import org.springframework.stereotype.Component;

/**
 * Utility class used to perform calculation for percentage calculator.
 * 
 * @author Marcin Mazur
 *
 */
@Component
public class PercentageCalculatorImpl implements PercentageCalculator {

	/**
	 * Returns the rounded value
	 * 
	 * @param result
	 *            The String containing the value to be rounded
	 * @return A double representing the rounded value
	 */
	public double roundResult(Double result) {
		String resultText = Double.toString(Math.abs(result));
		int integerPlaces = resultText.indexOf('.');
		int decimalPlaces = resultText.length() - integerPlaces - 1;

		if (decimalPlaces > 2)
			result = Math.round(result * 100.00) / 100.00;
		return result;
	}

	@Override
	public String calculatePercentge(int operationNumber, double paramValue1, double paramValue2) {

		double result;
		String resultString;

		if (operationNumber == 101) {

			result = roundResult(paramValue2 * (paramValue1 / 100));
			resultString = Double.toString(result);

		} else if (operationNumber == 102) {

			result = roundResult((paramValue2 / paramValue1) * 100);
			resultString = Double.toString(result);
			resultString += "%";

		} else if (operationNumber == 103) {

			result = roundResult((paramValue1 / paramValue2) * 100);
			resultString = Double.toString(result);
			resultString += "%";

		} else if (operationNumber == 104) {

			result = roundResult((paramValue1 * (paramValue2 / 100)) + paramValue1);
			resultString = Double.toString(result);

		} else if (operationNumber == 105) {

			result = roundResult(paramValue1 - (paramValue1 * (paramValue2 / 100)));
			resultString = Double.toString(result);

		} else if (operationNumber == 106) {

			result = roundResult((Math.abs(paramValue1 - paramValue2) / paramValue1) * 100);
			resultString = Double.toString(result);
			resultString += "%";

		} else if (operationNumber == 107) {

			result = roundResult((paramValue1 / paramValue2) * 100);
			resultString = Double.toString(result);
			resultString += "%";

		} else {
			resultString = "0";
		}

		return resultString;

	}

}
