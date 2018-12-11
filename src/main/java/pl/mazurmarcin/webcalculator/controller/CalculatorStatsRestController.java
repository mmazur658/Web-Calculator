package pl.mazurmarcin.webcalculator.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.mazurmarcin.webcalculator.services.CalculatorStatService;

/**
 * The rest controller class is used to perform actions depending on the user
 * request.
 * 
 * @author Marcin Mazur
 *
 */
@RestController
@RequestMapping("/administrator-panel/calculator-stats")
public class CalculatorStatsRestController {

	/**
	 * The CalculatorStatService interface
	 */
	private CalculatorStatService calculatorStatService;

	/**
	 * Constructs a CalculatorStatsRestController with the CalculatorStatService.
	 * 
	 * @param calculatorStatService
	 *            The CalculatorStatService interface
	 */
	@Autowired
	public CalculatorStatsRestController(CalculatorStatService calculatorStatService) {
		this.calculatorStatService = calculatorStatService;
	}

	/**
	 * Returns the statistics of calculators as a list of Objects[] for given date
	 * range. The number of results is limited by resultRange.
	 * 
	 * @param startDate
	 *            The String containing the first day of the range
	 * @param endDate
	 *            The String containing the last day of the range
	 * @param resultRange
	 *            The long containing the number of the results to be returned
	 * @param locale
	 *            The Locale containing the user`s locale
	 * @return A List&lt;Object[]&gt; representing the statistics of calculators
	 */
	@RequestMapping("/get-calculator-stats-for-given-range")
	public List<Object[]> getTopXCalculatorStatsForGivenDateRange(@RequestParam(name = "startDate") String startDate,
			@RequestParam(name = "endDate") String endDate, @RequestParam(name = "resultRange") long resultRange,
			Locale locale) {

		List<Object[]> results = calculatorStatService.getTopXCalculatorStatsForGivenDateRange(startDate, endDate,
				resultRange, locale);

		return results;
	}

	/**
	 * Returns the monthly statistics for the given calculator name and date range.
	 * 
	 * @param calculatorName
	 *            The String containing the name of the calculator
	 * @param startDate
	 *            The String containing the first day of the range
	 * @param endDate
	 *            The String containing the last day of the range
	 * @param monthLength
	 *            The int containing the length of the month
	 * @return A List&lt;Object[]&gt; representing the monthly statistics
	 */
	@RequestMapping("/get-selected-calculator-monthly-data")
	public List<Object[]> getSelectedCalculatorMonthlyData(@RequestParam(name = "calculatorName") String calculatorName,
			@RequestParam(name = "startDate") String startDate, @RequestParam(name = "endDate") String endDate,
			@RequestParam(name = "monthLength") int monthLength) {
		return calculatorStatService.getSelectedCalculatorMonthlyData(calculatorName, startDate, endDate, monthLength);
	}

	/**
	 * Returns the general statistics for given name of calculator.
	 * 
	 * @param calculatorName
	 *            The String containing the name of the calculator
	 * @return A String[] representing the general statistic
	 */
	@RequestMapping("/get-selected-calculator-general-statistics")
	public String[] getSelectedCalculatorGeneralStatistics(
			@RequestParam(name = "calculatorName") String calculatorName) {
		return calculatorStatService.getSelectedCalculatorGeneralStatistics(calculatorName);
	}

}
