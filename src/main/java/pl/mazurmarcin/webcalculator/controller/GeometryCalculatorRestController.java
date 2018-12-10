package pl.mazurmarcin.webcalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.mazurmarcin.webcalculator.services.CalculatorsService;

/**
 * The rest controller class is used to perform actions depending on the
 * request.
 * 
 * @author Marcin Mazur
 *
 */
@RestController
@RequestMapping("/geometry-calculator")
public class GeometryCalculatorRestController {

	/**
	 * The CalculatorsService interface
	 */
	private CalculatorsService calculatorsService;

	/**
	 * Constructs a GeometryCalculatorRestController with the CalculatorsService.
	 * 
	 * @param calculatorsService
	 *            The CalculatorsService interface
	 */
	@Autowired
	public GeometryCalculatorRestController(CalculatorsService calculatorsService) {
		this.calculatorsService = calculatorsService;
	}

	/**
	 * Geometric Calculator: Square <br>
	 * <br>
	 * Returns the set of the result as a double[] for given parameter name and
	 * value.
	 * 
	 * @param paramName
	 *            The String containing the name of the parameter
	 * @param paramValue
	 *            The Double containing the value
	 * @return A double[] representing the set of the result
	 */
	@RequestMapping("/calculate-square")
	public double[] calculateSquare(@RequestParam("paramName") String paramName,
			@RequestParam("paramValue") Double paramValue) {

		return calculatorsService.calculateSquare(paramName, paramValue);
	}

	/**
	 * Geometric Calculator: Rectangle <br>
	 * <br>
	 * Returns the set of the result as a double[] for given parameter name and
	 * value.
	 * 
	 * @param paramName
	 *            The String containing the name of the parameter
	 * @param paramValue1
	 *            The Double containing the first value
	 * @param paramValue2
	 *            The Double containing the second value
	 * @return A double[] representing the set of the result
	 */
	@RequestMapping("/calculate-rectangle")
	public double[] calculateRectangle(@RequestParam("paramName") String paramName,
			@RequestParam("paramValue1") Double paramValue1, @RequestParam("paramValue2") Double paramValue2) {

		return calculatorsService.calculateRectangle(paramName, paramValue1, paramValue2);
	}

}
