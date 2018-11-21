package pl.mazurmarcin.webcalculator.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.mazurmarcin.webcalculator.services.CalculatorStatService;

@RestController
@RequestMapping("/administrator-panel/calculator-stats")
public class CalculatorStatsRestController {

	private CalculatorStatService calculatorStatService;

	@Autowired
	public CalculatorStatsRestController(CalculatorStatService calculatorStatService) {
		this.calculatorStatService = calculatorStatService;
	}

	@RequestMapping("/get-calculator-stats-for-given-range")
	public List<Object[]> getTopXCalculatorStatsForGivenDateRange(@RequestParam(name = "startDate") String startDate,
			@RequestParam(name = "endDate") String endDate, @RequestParam(name = "resultRange") long resultRange,
			Locale locale) {

		List<Object[]> results = calculatorStatService.getTopXCalculatorStatsForGivenDateRange(startDate, endDate,
				resultRange, locale);

		return results;
	}

	@RequestMapping("/get-selected-calculator-monthly-data")
	public List<Object[]> getSelectedCalculatorMonthlyData(@RequestParam(name = "calculatorName") String calculatorName,
			@RequestParam(name = "startDate") String startDate, @RequestParam(name = "endDate") String endDate,
			@RequestParam(name = "monthLength") int monthLength) {
		return calculatorStatService.getSelectedCalculatorMonthlyData(calculatorName, startDate, endDate, monthLength);
	}

	@RequestMapping("/get-selected-calculator-general-statistics")
	public String[] getSelectedCalculatorGeneralStatistics(
			@RequestParam(name = "calculatorName") String calculatorName) {
		return calculatorStatService.getSelectedCalculatorGeneralStatistics(calculatorName);
	}

}
