package pl.mazurmarcin.webcalculator.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

import pl.mazurmarcin.webcalculator.entity.CalculatorStat;

/**
 * Utility class used to perform operations on calculator statistics
 * 
 * @author Marcin Mazur
 *
 */
@Component
public class CalculatorStatUtilsImpl implements CalculatorStatUtils {

	@Override
	public CalculatorStat createNewCalculatorStat(String calcName) throws ParseException {

		CalculatorStat calculatorStat = new CalculatorStat();
		calculatorStat.setCalcName(calcName);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date()) + " 00:00:00.0";
		calculatorStat.setDate(sdf.parse(date));

		return calculatorStat;
	}

	@Override
	public void prepareListForDisplay(List<Object[]> resultList, long resultRange, Locale locale) {

		// Calculators names
		String[] calculatorType_PL = { "Kwadrat", "Prostokąt", "Długość", "Masa", "Powierzchnia", "Waluty",
				"Procenty" };
		String[] calculatorType_EN = { "Square", "Rectangle", "Length", "Weight", "Area", "Currency", "Percentage" };

		String tempName;
		int index;

		// 1. Get the name of calculator from resultList
		// 2. Find the index of this name in calculatorType_EN
		// 3. Save the new name of calculator depending on the locale
		for (Object[] o : resultList) {
			tempName = (String) o[0];
			tempName = tempName.substring(9, tempName.length());
			index = Arrays.asList(calculatorType_EN).indexOf(tempName);
			o[0] = locale.getLanguage().equals("pl") ? calculatorType_PL[index] : calculatorType_EN[index];
		}

		/*
		 * If the resultRange is not equal to 999 than resultList must contains the
		 * number of the element equal to resultRange. The placeholder object is added
		 * to the end of the list until the size of the list is equal to resultRange.
		 */
		if (resultRange != 999) {
			if (resultList.size() < resultRange) {
				Object[] tempObject = new Object[2];
				tempObject[0] = locale.getLanguage().equals("pl") ? "Brak danych" : "No data";
				tempObject[1] = 0;

				do {
					resultList.add(tempObject);
				} while (resultList.size() < resultRange);
			}
		}
		/*
		 * If the resultRange is equal to 999 than the list can contain any number of
		 * element. Only calculators names are changed according to user's locale.
		 */
		if (resultRange == 999) {

			boolean isPresent = false;

			if (locale.getLanguage().equals("pl")) {

				for (String s : calculatorType_PL) {

					isPresent = false;

					for (Object[] tempObject : resultList) {
						if (tempObject[0].equals(s))
							isPresent = true;
					}

					if (!isPresent) {
						Object[] tmpObject = new Object[2];
						tmpObject[0] = s;
						tmpObject[1] = 0;
						resultList.add(tmpObject);
					}
				}

			} else {

				for (String s : calculatorType_EN) {
					isPresent = false;

					for (Object[] tempObject : resultList) {
						if (tempObject[0].equals(s))
							isPresent = true;
					}

					if (!isPresent) {
						Object[] tmpObject = new Object[2];
						tmpObject[0] = s;
						tmpObject[1] = 0;
						resultList.add(tmpObject);
					}
				}
			}
		}
	}

	@Override
	public String getDateMinusGivenValue(int value) {

		value = value * (-1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, value);

		Date tempDate = calendar.getTime();

		return sdf.format(tempDate) + " 00:00:00.0";
	}

	@Override
	public String getToday() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(new Date()) + " 00:00:00.0";
	}

	@Override
	public List<Object[]> createListToDisplay(List<Object[]> resultList, int monthLength) {

		// Create a list and fill it with the Object[]. The number of Object[] is equal
		// to monthLength
		List<Object[]> mainList = new ArrayList<>();

		// The list must contains the number of Object[] equals to monthLength
		addBlankObjectsToTheList(mainList, monthLength);

		// Populate mainList with the values from resultList
		populateListWithValuesFromAnotherList(resultList, mainList);

		return mainList;
	}

	/**
	 * Adds a Object[] to the list. The list must contains the number of Object[]
	 * equals to monthLength
	 * 
	 * @param mainList
	 *            The list of Object[] containing the list to be populated
	 * @param monthLength
	 *            The int containing the length of the month
	 */
	private void addBlankObjectsToTheList(List<Object[]> mainList, int monthLength) {

		// Each tempObject contains the two indexes: The number of the day and the
		// default value of the calculator usage = 0
		Object[] tempObject = new Object[2];

		for (int i = 0; i < monthLength; i++) {
			tempObject = new Object[2];

			tempObject[0] = i + 1;

			tempObject[1] = 0;
			mainList.add(tempObject);

		}

	}

	/**
	 * Populates the mainList with the values from the resultList
	 * 
	 * @param resultList
	 *            The list of Object[] containing the list with values
	 * @param mainList
	 *            The list of Object[] containing the list to be populated
	 */
	private void populateListWithValuesFromAnotherList(List<Object[]> resultList, List<Object[]> mainList) {

		// Populate mainList with the values from resultList
		String tempString;
		int index;

		for (Object[] object : resultList) {

			tempString = String.valueOf(object[0]);
			tempString = tempString.substring(8, 10);
			index = Integer.parseInt(tempString);

			mainList.get(index - 1)[1] = object[1];

		}

	}
}