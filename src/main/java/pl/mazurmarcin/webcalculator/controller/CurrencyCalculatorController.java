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

@Controller
@RequestMapping("/currency-calculator")
public class CurrencyCalculatorController {

	private CalculatorsService calculatorsService;

	@Autowired
	public CurrencyCalculatorController(CalculatorsService calculatorsService) {
		this.calculatorsService = calculatorsService;
	}

	@RequestMapping("get-currency-table")
	public String getCurrencyTable(Model theModel,
			@RequestParam(required = false, name = "selectedCurrencyCode") String selectedCurrencyCode)
			throws JSONException, IOException {

		List<Currency> currencyList = calculatorsService.calculateCurrency(selectedCurrencyCode);
		theModel.addAttribute("currencyList", currencyList);

		return "parts/currency-table";
	}
}
