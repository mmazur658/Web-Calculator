package pl.mazurmarcin.webcalculator.controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.mazurmarcin.webcalculator.services.CalculatorsService;
import pl.mazurmarcin.webcalculator.utils.Currency;

/**
 * The controller class is used to return the view depending on the user
 * request. This controller contains the views of: <br>
 * <ul>
 * <li>"parts/currency-table"</li>
 * </ul>
 * 
 * @author Marcin Mazur
 *
 */
@Controller
@RequestMapping("/currency-calculator")
public class CurrencyCalculatorController {

	/**
	 * The CalculatorsService interface
	 */
	private CalculatorsService calculatorsService;

	/**
	 * Constructs a CurrencyCalculatorController with the CalculatorsService
	 * 
	 * @param calculatorsService
	 *            The CalculatorsService interface
	 */
	@Autowired
	public CurrencyCalculatorController(CalculatorsService calculatorsService) {
		this.calculatorsService = calculatorsService;
	}

	/**
	 * Returns the view of "parts/currency-table" with model attribute:
	 * <ul>
	 * <li>currencyList - The list of the Currency objects</li>
	 * </ul>
	 * 
	 * @param theModel
	 *            The Model containing the data passed to the view
	 * @param selectedCurrencyCode
	 *            The String containing the code of the currency
	 * @return The String representing the name of the view
	 * @throws JSONException
	 *             A JSONException is thrown when the
	 *             calculatorsService.calculateCurrency is not able to return the
	 *             list of currencies
	 * @throws IOException
	 *             A IOException is thrown when the
	 *             calculatorsService.calculateCurrency is not able to download the
	 *             currencies.
	 */
	@RequestMapping("get-currency-table")
	public String getCurrencyTable(Model theModel,
			@RequestParam(required = false, name = "selectedCurrencyCode") String selectedCurrencyCode)
			throws JSONException, IOException {

		List<Currency> currencyList = calculatorsService.calculateCurrency(selectedCurrencyCode);
		theModel.addAttribute("currencyList", currencyList);

		return "parts/currency-table";
	}
}
