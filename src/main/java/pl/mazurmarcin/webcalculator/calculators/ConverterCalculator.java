package pl.mazurmarcin.webcalculator.calculators;

import java.math.BigDecimal;

/**
 * Interface used to perform calculation for unit converter
 * 
 * @author Marcin Mazur
 *
 */
public interface ConverterCalculator {

	/**
	 * Converter Calculator: Length <br>
	 * <Br>
	 * 
	 * Returns the result set for given id and value <br>
	 * <Br>
	 * The id determines which type of converting should be performed
	 * 
	 * @param inputId
	 *            The String containing the id of the conversion type
	 * @param inputValue
	 *            The String containing the value
	 * @return A BigDecimal[] representing the set of the results
	 * 
	 * @see java.math.BigDecimal[]
	 */
	BigDecimal[] calculateLength(String inputId, String inputValue);

	/**
	 * Converter Calculator: Weight <br>
	 * <br>
	 * Returns the result set for given id and value <br>
	 * <Br>
	 * The id determines which type of converting should be performed
	 * 
	 * @param inputId
	 *            The String containing the id of the conversion type
	 * @param inputValue
	 *            The String containing the value
	 * @return A BigDecimal[] representing the set of the results
	 */
	BigDecimal[] calculateWeight(String inputId, String inputValue);

	/**
	 * Converter Calculator: Area <br>
	 * <br>
	 * Returns the result set for given id and value <br>
	 * <Br>
	 * The id determines which type of converting should be performed
	 * 
	 * @param inputId
	 *            The String containing the id of the conversion type
	 * @param inputValue
	 *            The String containing the value
	 * @return A BigDecimal[] representing the set of the results
	 */
	BigDecimal[] calculateArea(String inputId, String inputValue);

}
