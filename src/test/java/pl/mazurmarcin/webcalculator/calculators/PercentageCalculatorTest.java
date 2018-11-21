package pl.mazurmarcin.webcalculator.calculators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PercentageCalculatorTest {

	private PercentageCalculatorImpl percentageCalculatorImpl = new PercentageCalculatorImpl();

	String expectedResult;
	double paramValue1 = 10;
	double paramValue2 = 20;

	@Test
	void shouldRoundResult() {
		double resultToRound = 2.11111111;
		assertEquals("2.11", String.valueOf(percentageCalculatorImpl.roundResult(resultToRound)));
	}

	@Test // 101
	void shouldReturnResultDependsOnGivenCodeCase1() {
		expectedResult = percentageCalculatorImpl.calculatePercentge(101, paramValue1, paramValue2);
		assertEquals("2.0", expectedResult);
	}

	@Test // 102
	void shouldReturnResultDependsOnGivenCodeCase2() {
		expectedResult = percentageCalculatorImpl.calculatePercentge(102, paramValue1, paramValue2);
		assertEquals("200.0%", expectedResult);
	}

	@Test // 103
	void shouldReturnResultDependsOnGivenCodeCase3() {
		expectedResult = percentageCalculatorImpl.calculatePercentge(103, paramValue1, paramValue2);
		assertEquals("50.0%", expectedResult);
	}

	@Test // 104
	void shouldReturnResultDependsOnGivenCodeCase4() {
		expectedResult = percentageCalculatorImpl.calculatePercentge(104, paramValue1, paramValue2);
		assertEquals("12.0", expectedResult);
	}

	@Test // 105
	void shouldReturnResultDependsOnGivenCodeCase5() {
		expectedResult = percentageCalculatorImpl.calculatePercentge(105, paramValue1, paramValue2);
		assertEquals("8.0", expectedResult);
	}

	@Test // 106
	void shouldReturnResultDependsOnGivenCodeCase6() {
		expectedResult = percentageCalculatorImpl.calculatePercentge(106, paramValue1, paramValue2);
		assertEquals("100.0%", expectedResult);
	}

	@Test // 107
	void shouldReturnResultDependsOnGivenCodeCase7() {
		expectedResult = percentageCalculatorImpl.calculatePercentge(107, paramValue1, paramValue2);
		assertEquals("50.0%", expectedResult);
	}

	@Test // any other code
	void shouldReturnResultDependsOnGivenCodeCase8() {
		expectedResult = percentageCalculatorImpl.calculatePercentge(523, paramValue1, paramValue2);
		assertEquals("0", expectedResult);
	}

}
