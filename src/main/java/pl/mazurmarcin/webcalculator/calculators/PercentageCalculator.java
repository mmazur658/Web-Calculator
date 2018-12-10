package pl.mazurmarcin.webcalculator.calculators;

/**
 * Interface class used to perform calculation for percentage calculator.
 * 
 * @author Marcin Mazur
 *
 */
public interface PercentageCalculator {

	/**
	 * Returns the result of calculation for given operation number and given
	 * values.<br>
	 * <br>
	 * The operationNumber determines which type of calculation should be performed
	 * 
	 * @param operationNumber
	 *            The String containing the number of the calculation type
	 * @param paramValue1
	 *            The double containing the first value
	 * @param paramValue2
	 *            The double containing the second value
	 * @return A String representing the result
	 */
	String calculatePercentge(int operationNumber, double paramValue1, double paramValue2);

}
