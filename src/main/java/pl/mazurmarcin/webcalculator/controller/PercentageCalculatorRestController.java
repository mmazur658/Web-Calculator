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
@RequestMapping("/percentage-calculator")
public class PercentageCalculatorRestController {

	/**
	 * The CalculatorsService interface
	 */
	private CalculatorsService calculatorsService;

	/**
	 * Constructs PercentageCalculatorRestController a with the CalculatorsService.
	 * 
	 * @param calculatorsService
	 *            The CalculatorsService interface
	 */
	@Autowired
	public PercentageCalculatorRestController(CalculatorsService calculatorsService) {
		this.calculatorsService = calculatorsService;
	}

	/**
	 * Percentage Calculator.<br>
	 * <br>
	 * Returns the result of the calculation for the given values and
	 * operationNumber.
	 * 
	 * @param operationNumber
	 *            The int containing the number of operation
	 * @param paramValue1
	 *            The double containing the first value
	 * @param paramValue2
	 *            The double containing the second value
	 * @return A String representing the result of the calculation
	 */
	@RequestMapping("/calculate-percentage")
	public String calculatePercentge(@RequestParam(name = "operationNumber") int operationNumber,
			@RequestParam(name = "paramValue1") double paramValue1,
			@RequestParam(name = "paramValue2") double paramValue2) {

		return calculatorsService.calculatePercentage(operationNumber, paramValue1, paramValue2);

	}

}
