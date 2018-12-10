package pl.mazurmarcin.webcalculator.calculators;

/**
 * Interface used to perform calculation for geometric calculator.
 * 
 * @author Marcin Mazur
 *
 */
public interface GeometryCalculator {

	/**
	 * Geometric Calculator: Square<br>
	 * <br>
	 * Returns the set of the results for given name of the parameter and given
	 * value.<br>
	 * <br>
	 * The paramName determines which type of calculation should be performed
	 * 
	 * @param paramName
	 *            The String containing the name of the calculation type
	 * @param paramValue
	 *            The String containing the value
	 * @return A double[] representing the set of the results
	 */
	double[] calculateSquare(String paramName, Double paramValue);

	/**
	 * Geometric Calculator: Rectangle<br>
	 * <br>
	 * Returns the set of the results for given name of the parameter and given
	 * values.<br>
	 * <br>
	 * The paramName determines which type of calculation should be performed
	 * 
	 * @param paramName
	 *            The String containing the name of the calculation type
	 * @param paramValue1
	 *            The String containing the first value
	 * @param paramValue2
	 *            The String containing the second value          
	 * @return A double[] representing the set of the results
	 */
	double[] calculateRectangle(String paramName, Double paramValue1, Double paramValue2);

}
