package pl.mazurmarcin.webcalculator.services;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public interface CalculatorStatService {

	void saveCalculatorStat(String methodName) throws ParseException;

	List<Object[]> getTopXCalculatorStatsForGivenDateRange(String startDate, String endDate, long resultRange,
			Locale locale);

	long[] getGeneralStatisticsResultSet();

	String[] getSelectedCalculatorGeneralStatistics(String calculatorName);

	List<Object[]> getSelectedCalculatorMonthlyData(String calculatorName, String startDate, String endDate,
			int monthLength);

}
