package pl.mazurmarcin.webcalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.mazurmarcin.webcalculator.services.CalculatorsService;

@RestController
@RequestMapping("/percentage-calculator")
public class PercentageCalculatorRestController {

	private CalculatorsService calculatorsService;

	@Autowired
	public PercentageCalculatorRestController(CalculatorsService calculatorsService) {
		this.calculatorsService = calculatorsService;
	}

	@RequestMapping("/calculate-percentage")
	public String calculatePercentge(@RequestParam(name = "operationNumber") int operationNumber,
			@RequestParam(name = "paramValue1") double paramValue1,
			@RequestParam(name = "paramValue2") double paramValue2) {

		return calculatorsService.calculatePercentage(operationNumber, paramValue1, paramValue2);

	}

}
