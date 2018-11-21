package pl.mazurmarcin.webcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebCalculatorController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/geometry-calculator")
	public String geometryCalculator() {
		return "geometry-calculator";
	}

	@RequestMapping("/trigonometry-calculator")
	public String trigonometryCalculator() {
		return "trigonometry-calculator";
	}

	@RequestMapping("/converter-calculator")
	public String converterCalculator() {
		return "converter-calculator";
	}

	@RequestMapping("/combinatorics-calculator")
	public String combinatoricsCalculator() {
		return "combinatorics-calculator";
	}

	@RequestMapping("/currency-calculator")
	public String currencyCalculator() {
		return "currency-calculator";
	}

	@RequestMapping("/percentage-calculator")
	public String percentageCalculator() {
		return "percentage-calculator";
	}

	@RequestMapping("/basic-calculator")
	public String basicCalculator() {
		return "calc/basic-calc";
	}

	@RequestMapping("/advanced-calculator")
	public String advancedCalculator() {
		return "calc/advanced-calc";
	}

	@RequestMapping("/science-calculator")
	public String scienceCalculator() {
		return "calc/science-calc";
	}

	@RequestMapping("/login-form")
	public String showLoginForm() {
		return "login-form";
	}

}
