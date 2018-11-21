package pl.mazurmarcin.webcalculator.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import pl.mazurmarcin.webcalculator.entity.CalculatorStat;

class CalculatorStatUtilsTest {

	private CalculatorStatUtilsImpl calculatorStatUtilsImpl = new CalculatorStatUtilsImpl();

	@Test
	void shouldCreateNewCalculatorStat() throws ParseException {

		String methodName = "calculateSquare";
		CalculatorStat calculatorStat = calculatorStatUtilsImpl.createNewCalculatorStat(methodName);

		assertEquals(methodName, calculatorStat.getCalcName());
		assertTrue(calculatorStat.getCounts() == 0);
		assertNotNull(calculatorStat.getDate());

	}

	@Test
	void shouldPrepareListForDisplayCase1() {
		
		
		Locale locale = new Locale("pl","PL");
		
		long resultRange = 4;
		List<Object[]> resultList = new ArrayList<>();
		
		Object[] tempObject = new Object[2];	
		tempObject[0]="calculateSquare";
		tempObject[1]=15;
		resultList.add(tempObject);
		
		tempObject = new Object[2];	
		tempObject[0]="calculatePercentage";
		tempObject[1]=20;
		resultList.add(tempObject);
		
		assertTrue(resultList.size()==2);
		calculatorStatUtilsImpl.prepareListForDisplay(resultList, resultRange, locale);
		
		assertTrue(resultList.size()==4);
		assertEquals("Kwadrat", resultList.get(0)[0]);
		assertEquals("Procenty", resultList.get(1)[0]);
		assertEquals("Brak danych", resultList.get(2)[0]);
		assertEquals("Brak danych", resultList.get(3)[0]);
		assertEquals(15, resultList.get(0)[1]);
		assertEquals(20, resultList.get(1)[1]);
		assertEquals(0, resultList.get(2)[1]);
		assertEquals(0, resultList.get(3)[1]);
	}
	
	@Test
	void shouldPrepareListForDisplayCase2() {		
		
		Locale locale = Locale.ENGLISH;
		
		long resultRange = 6;
		List<Object[]> resultList = new ArrayList<>();
		
		Object[] tempObject = new Object[2];	
		tempObject[0]="calculateSquare";
		tempObject[1]=15;
		resultList.add(tempObject);
		
		tempObject = new Object[2];	
		tempObject[0]="calculatePercentage";
		tempObject[1]=20;
		resultList.add(tempObject);
		
		tempObject = new Object[2];	
		tempObject[0]="calculateWeight";
		tempObject[1]=120;
		resultList.add(tempObject);
		
		assertTrue(resultList.size()==3);
		calculatorStatUtilsImpl.prepareListForDisplay(resultList, resultRange, locale);
		
		assertTrue(resultList.size()==6);
		assertEquals("Square", resultList.get(0)[0]);
		assertEquals("Percentage", resultList.get(1)[0]);
		assertEquals("Weight", resultList.get(2)[0]);
		assertEquals("No data", resultList.get(3)[0]);
		assertEquals("No data", resultList.get(4)[0]);
		assertEquals("No data", resultList.get(5)[0]);
		assertEquals(15, resultList.get(0)[1]);
		assertEquals(20, resultList.get(1)[1]);
		assertEquals(120, resultList.get(2)[1]);
		assertEquals(0, resultList.get(3)[1]);
		assertEquals(0, resultList.get(4)[1]);
		assertEquals(0, resultList.get(5)[1]);

	}
	
	@Test
	void shouldPrepareListForDisplayCase3() {		
		
		Locale locale = Locale.ENGLISH;
		
		long resultRange = 999;
		List<Object[]> resultList = new ArrayList<>();
		
		Object[] tempObject = new Object[2];	
		tempObject[0]="calculateSquare";
		tempObject[1]=120;
		resultList.add(tempObject);
		
		tempObject = new Object[2];	
		tempObject[0]="calculatePercentage";
		tempObject[1]=20;
		resultList.add(tempObject);
		
		tempObject = new Object[2];	
		tempObject[0]="calculateWeight";
		tempObject[1]=15;
		resultList.add(tempObject);
		
		assertTrue(resultList.size()==3);
		calculatorStatUtilsImpl.prepareListForDisplay(resultList, resultRange, locale);

		assertEquals("Square", resultList.get(0)[0]);
		assertEquals("Percentage", resultList.get(1)[0]);
		assertEquals("Weight", resultList.get(2)[0]);
		assertEquals("Rectangle", resultList.get(3)[0]);
		assertEquals("Length", resultList.get(4)[0]);
		assertEquals("Area", resultList.get(5)[0]);
		assertEquals("Currency", resultList.get(6)[0]);
		assertEquals(120, resultList.get(0)[1]);
		assertEquals(20, resultList.get(1)[1]);
		assertEquals(15, resultList.get(2)[1]);
		assertEquals(0, resultList.get(3)[1]);
		assertEquals(0, resultList.get(4)[1]);
		assertEquals(0, resultList.get(5)[1]);
		assertEquals(0, resultList.get(6)[1]);

	}
	@Test
	void shouldPrepareListForDisplayCase4() {		
		
		Locale locale = new Locale("pl","PL");
		
		long resultRange = 999;
		List<Object[]> resultList = new ArrayList<>();
		
		Object[] tempObject = new Object[2];	
		tempObject[0]="calculateSquare";
		tempObject[1]=120;
		resultList.add(tempObject);
		
		tempObject = new Object[2];	
		tempObject[0]="calculatePercentage";
		tempObject[1]=20;
		resultList.add(tempObject);
		
		tempObject = new Object[2];	
		tempObject[0]="calculateWeight";
		tempObject[1]=15;
		resultList.add(tempObject);
		
		assertTrue(resultList.size()==3);
		calculatorStatUtilsImpl.prepareListForDisplay(resultList, resultRange, locale);

		assertEquals("Kwadrat", resultList.get(0)[0]);
		assertEquals("Procenty", resultList.get(1)[0]);
		assertEquals("Masa", resultList.get(2)[0]);
		assertEquals("Prostokąt", resultList.get(3)[0]);
		assertEquals("Długość", resultList.get(4)[0]);
		assertEquals("Powierzchnia", resultList.get(5)[0]);
		assertEquals("Waluty", resultList.get(6)[0]);
		assertEquals(120, resultList.get(0)[1]);
		assertEquals(20, resultList.get(1)[1]);
		assertEquals(15, resultList.get(2)[1]);
		assertEquals(0, resultList.get(3)[1]);
		assertEquals(0, resultList.get(4)[1]);
		assertEquals(0, resultList.get(5)[1]);
		assertEquals(0, resultList.get(6)[1]);

	}

	@Test
	void shouldGetDateMinusGivenValue() {

		int value = -5;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, value);
		Date tempDate = calendar.getTime();

		String expectedDate = sdf.format(tempDate) + " 00:00:00.0";
		assertEquals(expectedDate, calculatorStatUtilsImpl.getDateMinusGivenValue((-1) * value));
	}

	@Test
	void shouldGetToday() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String expectedDate = sdf.format(new Date()) + " 00:00:00.0";
		assertEquals(expectedDate, calculatorStatUtilsImpl.getToday());
	}

	@Test
	void shouldCreateListToDisplay() {
		
		int monthLength = 30;	
		Object[] tempObject = new Object[2];		
		List<Object[]> resultList = new ArrayList<>();
		
		tempObject = new Object[2];
		tempObject[0]="2018-11-20 00:00:00.0";
		tempObject[1]=200;
		resultList.add(tempObject);
		
		tempObject = new Object[2];
		tempObject[0]="2018-11-15 00:00:00.0";
		tempObject[1]=150;
		resultList.add(tempObject);
		
		tempObject = new Object[2];
		tempObject[0]="2018-11-05 00:00:00.0";
		tempObject[1]=100;
		resultList.add(tempObject);
		
		List<Object[]> mainList = calculatorStatUtilsImpl.createListToDisplay(resultList, monthLength);
		
		assertTrue(mainList.size()==30);
		assertEquals(5, mainList.get(4)[0]);
		assertEquals(100, mainList.get(4)[1]);
		assertEquals(15, mainList.get(14)[0]);
		assertEquals(150, mainList.get(14)[1]);
		assertEquals(20, mainList.get(19)[0]);
		assertEquals(200, mainList.get(19)[1]);
		
		assertEquals(0, mainList.get(18)[1]);
		assertEquals(0, mainList.get(22)[1]);
		assertEquals(0, mainList.get(7)[1]);
		
	}

}
