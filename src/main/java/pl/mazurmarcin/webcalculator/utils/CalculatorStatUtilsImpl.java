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

@Component
public class CalculatorStatUtilsImpl implements CalculatorStatUtils {

	@Override
	public CalculatorStat createNewCalculatorStat(String methodName) throws ParseException {

		CalculatorStat calculatorStat = new CalculatorStat();
		calculatorStat.setCalcName(methodName);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date()) + " 00:00:00.0";
		calculatorStat.setDate(sdf.parse(date));

		return calculatorStat;
	}

	@Override
	public void prepareListForDisplay(List<Object[]> resultList, long resultRange, Locale locale) {

		String[] calculatorType_PL = { "Kwadrat", "Prostokąt", "Długość", "Masa", "Powierzchnia", "Waluty",
				"Procenty" };
		String[] calculatorType_EN = { "Square", "Rectangle", "Length", "Weight", "Area", "Currency", "Percentage" };

		String tempName;
		int index;

		for (Object[] o : resultList) {
			tempName = (String) o[0];
			tempName = tempName.substring(9, tempName.length());
			index = Arrays.asList(calculatorType_EN).indexOf(tempName);
			o[0] = locale.getLanguage().equals("pl") ? calculatorType_PL[index] : calculatorType_EN[index];
		}

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

		List<Object[]> mainList = new ArrayList<>();

		Object[] tempObject = new Object[2];

		for (int i = 0; i < monthLength; i++) {
			tempObject = new Object[2];

			tempObject[0] = i + 1;

			tempObject[1] = 0;
			mainList.add(tempObject);

		}

		String tempString;
		int index;

		for (Object[] object : resultList) {

			tempString = String.valueOf(object[0]);
			tempString = tempString.substring(8, 10);
			index = Integer.parseInt(tempString);

			mainList.get(index - 1)[1] = object[1];

		}

		return mainList;
	}
}