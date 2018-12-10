package pl.mazurmarcin.webcalculator.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.mazurmarcin.webcalculator.dao.ClaculatorStatDao;
import pl.mazurmarcin.webcalculator.utils.CalculatorStatUtils;

/**
 * Service class for managing statistics of the calculators.
 * 
 * @author Marcin Mazur
 *
 */
@Service
public class CalculatorStatServiceImpl implements CalculatorStatService {

	/**
	 * The ClaculatorStatDao interface
	 */
	private ClaculatorStatDao claculatorStatDao;

	/**
	 * The CalculatorStatUtils interface
	 */
	private CalculatorStatUtils calculatorStatUtils;

	/**
	 * Constructs a CalculatorStatServiceImpl with the ClaculatorStatDao and
	 * CalculatorStatUtils.
	 * 
	 * @param claculatorStatDao
	 *            The ClaculatorStatDao interface
	 * @param calculatorStatUtils
	 *            The CalculatorStatUtils interface
	 */
	@Autowired
	public CalculatorStatServiceImpl(ClaculatorStatDao claculatorStatDao, CalculatorStatUtils calculatorStatUtils) {
		this.claculatorStatDao = claculatorStatDao;
		this.calculatorStatUtils = calculatorStatUtils;
	}

	@Override
	@Transactional
	public void saveCalculatorStat(String calcName) throws ParseException {
		claculatorStatDao.saveCalculatorStat(calculatorStatUtils.createNewCalculatorStat(calcName));
	}

	@Override
	@Transactional
	public List<Object[]> getTopXCalculatorStatsForGivenDateRange(String startDate, String endDate, long resultRange,
			Locale locale) {

		startDate = startDate + " 00:00:00.0";
		endDate = endDate + " 00:00:00.0";

		List<Object[]> resultList = claculatorStatDao.getTopXCalculatorStatsForGivenDateRange(startDate, endDate,
				resultRange);

		calculatorStatUtils.prepareListForDisplay(resultList, resultRange, locale);

		return resultList;
	}

	@Override
	public long[] getGeneralStatisticsResultSet() {

		long[] generalStatisticsResultSet = new long[6];

		generalStatisticsResultSet[0] = claculatorStatDao.getNumberOfCalculatorsType();

		String today = calculatorStatUtils.getToday();
		generalStatisticsResultSet[1] = claculatorStatDao.sumOfCalculationForGivenDateRange(today, today);

		String yesterday = calculatorStatUtils.getDateMinusGivenValue(1);
		generalStatisticsResultSet[2] = claculatorStatDao.sumOfCalculationForGivenDateRange(yesterday, yesterday);

		String startDate = yesterday;
		String endDate = calculatorStatUtils.getDateMinusGivenValue(6);
		generalStatisticsResultSet[3] = claculatorStatDao.sumOfCalculationForGivenDateRange(endDate, startDate);

		startDate = yesterday;
		endDate = calculatorStatUtils.getDateMinusGivenValue(29);
		generalStatisticsResultSet[4] = claculatorStatDao.sumOfCalculationForGivenDateRange(endDate, startDate);

		startDate = today;
		endDate = calculatorStatUtils.getDateMinusGivenValue(1000);
		generalStatisticsResultSet[5] = claculatorStatDao.sumOfCalculationForGivenDateRange(endDate, startDate);

		return generalStatisticsResultSet;
	}

	@Override
	public String[] getSelectedCalculatorGeneralStatistics(String calculatorName) {

		String[] selectedCalculatorGeneralStatistics = new String[6];

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		selectedCalculatorGeneralStatistics[0] = sdf.format(claculatorStatDao.getCalculatorFirstUse(calculatorName));

		String today = calculatorStatUtils.getToday();
		selectedCalculatorGeneralStatistics[1] = claculatorStatDao
				.sumOfCalculationOfSelectedCalculatorForGivenDateRange(today, today, calculatorName);

		String yesterday = calculatorStatUtils.getDateMinusGivenValue(1);
		selectedCalculatorGeneralStatistics[2] = claculatorStatDao
				.sumOfCalculationOfSelectedCalculatorForGivenDateRange(yesterday, yesterday, calculatorName);

		String startDate = yesterday;
		String endDate = calculatorStatUtils.getDateMinusGivenValue(6);
		selectedCalculatorGeneralStatistics[3] = claculatorStatDao
				.sumOfCalculationOfSelectedCalculatorForGivenDateRange(endDate, startDate, calculatorName);

		startDate = yesterday;
		endDate = calculatorStatUtils.getDateMinusGivenValue(29);
		selectedCalculatorGeneralStatistics[4] = claculatorStatDao
				.sumOfCalculationOfSelectedCalculatorForGivenDateRange(endDate, startDate, calculatorName);

		startDate = today;
		endDate = calculatorStatUtils.getDateMinusGivenValue(1000);
		selectedCalculatorGeneralStatistics[5] = claculatorStatDao
				.sumOfCalculationOfSelectedCalculatorForGivenDateRange(endDate, startDate, calculatorName);

		return selectedCalculatorGeneralStatistics;
	}

	@Override
	public List<Object[]> getSelectedCalculatorMonthlyData(String calculatorName, String startDate, String endDate,
			int monthLength) {

		startDate = startDate + " 00:00:00.0";
		endDate = endDate + " 23:59:59.9";

		List<Object[]> resultList = claculatorStatDao.getSelectedCalculatorMonthlyData(calculatorName, startDate,
				endDate);

		List<Object[]> mainList = calculatorStatUtils.createListToDisplay(resultList, monthLength);

		return mainList;
	}

}
