package pl.mazurmarcin.webcalculator.dao;

import java.util.Date;
import java.util.List;

import pl.mazurmarcin.webcalculator.entity.CalculatorStat;

public interface ClaculatorStatDao {

	void saveCalculatorStat(CalculatorStat calculatorStat);

	List<Object[]> getTopXCalculatorStatsForGivenDateRange(String startDate, String endDate, long resultRange);

	long getAmountOfCalculatorsType();

	long sumOfCalculationForGivenDateRange(String startDate, String endDate);

	String sumOfCalculationOfSelectedCalculatorForGivenDateRange(String startDate, String endDate,
			String calculatorName);

	Date getCalculatorFirstUse(String calculatorName);

	List<Object[]> getSelectedCalculatorMonthlyData(String calculatorName, String startDate, String endDate);

}
