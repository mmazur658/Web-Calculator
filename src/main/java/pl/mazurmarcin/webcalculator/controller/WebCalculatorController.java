package pl.mazurmarcin.webcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The controller class is used to return the view depending one the user request.
 * This controller contains the views of: <br>
 * 
 * <ul>
 * <li>"geometry-calculator"</li>
 * <li>"trigonometry-calculator"</li>
 * <li>"converter-calculator"</li>
 * <li>"combinatorics-calculator"</li>
 * <li>"currency-calculator"</li>
 * <li>"percentage-calculator"</li>
 * <li>"calc/basic-calc"</li>
 * <li>"calc/advanced-calc"</li>
 * <li>"calc/science-calc"</li>
 * <li>"login-form"</li>
 * </ul>
 * 
 * @author Marcin Mazur
 *
 */
@Controller
public class WebCalculatorController {

	/**
	 * Returns the view of "index".
	 * 
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	/**
	 * Returns the view of "geometry-calculator".
	 * 
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/geometry-calculator")
	public String geometryCalculator() {
		return "geometry-calculator";
	}

	/**
	 * Returns the view of "trigonometry-calculator".
	 * 
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/trigonometry-calculator")
	public String trigonometryCalculator() {
		return "trigonometry-calculator";
	}

	/**
	 * Returns the view of "converter-calculator".
	 * 
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/converter-calculator")
	public String converterCalculator() {
		return "converter-calculator";
	}

	/**
	 * Returns the view of "combinatorics-calculator".
	 * 
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/combinatorics-calculator")
	public String combinatoricsCalculator() {
		return "combinatorics-calculator";
	}

	/**
	 * Returns the view of "currency-calculator".
	 * 
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/currency-calculator")
	public String currencyCalculator() {
		return "currency-calculator";
	}

	/**
	 * Returns the view of "percentage-calculator".
	 * 
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/percentage-calculator")
	public String percentageCalculator() {
		return "percentage-calculator";
	}

	/**
	 * Returns the view of "calc/basic-calc".
	 * 
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/basic-calculator")
	public String basicCalculator() {
		return "calc/basic-calc";
	}

	/**
	 * Returns the view of "calc/advanced-calc".
	 * 
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/advanced-calculator")
	public String advancedCalculator() {
		return "calc/advanced-calc";
	}

	/**
	 * Returns the view of "calc/science-calc".
	 * 
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/science-calculator")
	public String scienceCalculator() {
		return "calc/science-calc";
	}

	/**
	 * Returns the view of "login-form".
	 * 
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/login-form")
	public String showLoginForm() {
		return "login-form";
	}

}
