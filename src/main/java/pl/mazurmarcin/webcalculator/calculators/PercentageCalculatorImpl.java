package pl.mazurmarcin.webcalculator.calculators;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Component;

/**
 * Utility class used to perform calculation for percentage calculator.
 * 
 * @author Marcin Mazur
 *
 */
@Component
public class PercentageCalculatorImpl implements PercentageCalculator {

	private final int OPERATION_101 = 101;
	private final int OPERATION_102 = 102;
	private final int OPERATION_103 = 103;
	private final int OPERATION_104 = 104;
	private final int OPERATION_105 = 105;
	private final int OPERATION_106 = 106;
	private final int OPERATION_107 = 107;

	private final int[] OPERATIONS_WITH_PERCENTAGE_RESULT = { OPERATION_102, OPERATION_103, OPERATION_106,
			OPERATION_107 };

	/**
	 * Returns the rounded value
	 * 
	 * @param result
	 *            The String containing the value to be rounded
	 * @return A double representing the rounded value
	 */
	double roundResult(Double result) {
		String resultText = Double.toString(Math.abs(result));
		int integerPlaces = resultText.indexOf('.');
		int decimalPlaces = resultText.length() - integerPlaces - 1;

		if (decimalPlaces > 2)
			result = Math.round(result * 100.00) / 100.00;
		return result;
	}

	/**
	 * Adds a percent symbol to the end of the result if the
	 * OPERATIONS_WITH_PERCENTAGE_RESULT contains the given operationNumber.
	 * 
	 * @param result
	 *            The String containing the result to be transformed
	 * @param operationNumber
	 *            The int containing the number of operation
	 * @return A String representing the result
	 */
	private String addPercentSymbol(String result, int operationNumber) {

		if (Arrays.asList(OPERATIONS_WITH_PERCENTAGE_RESULT).contains(operationNumber))
			return result += "%";
		else
			return result;

	}

	@Override
	public String calculatePercentge(int operationNumber, double paramValue1, double paramValue2) {

		double result;

		switch (operationNumber) {
		case OPERATION_101:
			result = roundResult(paramValue2 * (paramValue1 / 100));
			break;
		case OPERATION_102:
			result = roundResult((paramValue2 / paramValue1) * 100);
			break;
		case OPERATION_103:
			result = roundResult((paramValue1 / paramValue2) * 100);
			break;
		case OPERATION_104:
			result = roundResult((paramValue1 * (paramValue2 / 100)) + paramValue1);
			break;
		case OPERATION_105:
			result = roundResult(paramValue1 - (paramValue1 * (paramValue2 / 100)));
			break;
		case OPERATION_106:
			result = roundResult((Math.abs(paramValue1 - paramValue2) / paramValue1) * 100);
			break;
		case OPERATION_107:
			result = roundResult((paramValue1 / paramValue2) * 100);
			break;
		default:
			result = 0;
		}

		String resultString = Double.toString(result);
		resultString = addPercentSymbol(resultString, operationNumber);

		return resultString;

	}
}
