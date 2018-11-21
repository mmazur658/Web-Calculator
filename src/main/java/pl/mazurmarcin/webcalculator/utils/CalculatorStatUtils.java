package pl.mazurmarcin.webcalculator.utils;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import pl.mazurmarcin.webcalculator.entity.CalculatorStat;

public interface CalculatorStatUtils {

	CalculatorStat createNewCalculatorStat(String methodName) throws ParseException;

	void prepareListForDisplay(List<Object[]> resultList, long resultRange, Locale locale);

	String getDateMinusGivenValue(int value);

	String getToday();

	List<Object[]> createListToDisplay(List<Object[]> resultList, int monthLength);

}
