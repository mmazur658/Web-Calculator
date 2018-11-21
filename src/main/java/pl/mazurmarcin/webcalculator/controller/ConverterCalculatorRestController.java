package pl.mazurmarcin.webcalculator.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.mazurmarcin.webcalculator.services.CalculatorsService;

@RestController
@RequestMapping("/converter-calculator")
public class ConverterCalculatorRestController {

	private CalculatorsService calculatorsService;

	@Autowired
	public ConverterCalculatorRestController(CalculatorsService calculatorsService) {
		this.calculatorsService = calculatorsService;
	}

	@RequestMapping("/calculate-length")
	public BigDecimal[] calculateLength(@RequestParam(name = "inputId") String inputId,
			@RequestParam(name = "inputValue") String inputValue) {

		return calculatorsService.calculateLength(inputId, inputValue);
	}

	@RequestMapping("/calculate-weight")
	public BigDecimal[] calculateWeight(@RequestParam(name = "inputId") String inputId,
			@RequestParam(name = "inputValue") String inputValue) {

		return calculatorsService.calculateWeight(inputId, inputValue);
	}

	@RequestMapping("/calculate-area")
	public BigDecimal[] calculateArea(@RequestParam(name = "inputId") String inputId,
			@RequestParam(name = "inputValue") String inputValue) {

		return calculatorsService.calculateArea(inputId, inputValue);
	}
}
