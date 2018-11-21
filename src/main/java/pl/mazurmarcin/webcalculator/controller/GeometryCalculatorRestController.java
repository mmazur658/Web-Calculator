package pl.mazurmarcin.webcalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.mazurmarcin.webcalculator.services.CalculatorsService;

@RestController
@RequestMapping("/geometry-calculator")
public class GeometryCalculatorRestController {

	private CalculatorsService calculatorsService;

	@Autowired
	public GeometryCalculatorRestController(CalculatorsService calculatorsService) {
		this.calculatorsService = calculatorsService;
	}

	@RequestMapping("/calculate-square")
	public double[] calculateSquare(@RequestParam("paramName") String paramName,
			@RequestParam("paramValue") Double paramValue) {

		return calculatorsService.calculateSquare(paramName, paramValue);
	}

	@RequestMapping("/calculate-rectangle")
	public double[] calculateRectangle(@RequestParam("paramName") String paramName,
			@RequestParam("paramValue1") Double paramValue1, @RequestParam("paramValue2") Double paramValue2) {

		return calculatorsService.calculateRectangle(paramName, paramValue1, paramValue2);
	}

}
