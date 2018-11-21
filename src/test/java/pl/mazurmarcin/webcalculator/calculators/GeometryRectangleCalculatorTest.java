package pl.mazurmarcin.webcalculator.calculators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeometryRectangleCalculatorTest {

	private GeometryCalculatorImpl geometryCalculator = new GeometryCalculatorImpl();

	// 0-sideA 1-sideB 2-field 3-circuit 4-diameter 5-radius
	double[] resultSet = new double[6];
	double paramValue1 = 10.0;
	double paramValue2 = 5.0;
	String paramName;

	@Test
	void shouldReturnResultSetForGivenParameterName() {
		// sideA-sideB
		resultSet = geometryCalculator.calculateRectangle("sideA-sideB", paramValue1, paramValue2);
		assertEquals(10.0, resultSet[0]);
		assertEquals(5.0, resultSet[1]);
		assertEquals(50.0, resultSet[2]);
		assertEquals(30.0, resultSet[3]);
		assertEquals(11.180339887498949, resultSet[4]);
		assertEquals(5.5901699437494745, resultSet[5]);

		// sideA-field
		resultSet = geometryCalculator.calculateRectangle("sideA-field", paramValue1, paramValue2);
		assertEquals(10.0, resultSet[0]);
		assertEquals(0.5, resultSet[1]);
		assertEquals(5.0, resultSet[2]);
		assertEquals(21, resultSet[3]);
		assertEquals(10.012492197250394, resultSet[4]);
		assertEquals(5.006246098625197, resultSet[5]);

		// sideB-field
		resultSet = geometryCalculator.calculateRectangle("sideB-field", paramValue1, paramValue2);
		assertEquals(0.5, resultSet[0]);
		assertEquals(10.0, resultSet[1]);
		assertEquals(5.0, resultSet[2]);
		assertEquals(21.0, resultSet[3]);
		assertEquals(10.012492197250394, resultSet[4]);
		assertEquals(5.006246098625197, resultSet[5]);

		// sideA-circuit
		paramValue2 = 50.0;
		resultSet = geometryCalculator.calculateRectangle("sideA-circuit", paramValue1, paramValue2);
		assertEquals(10.0, resultSet[0]);
		assertEquals(15.0, resultSet[1]);
		assertEquals(150.0, resultSet[2]);
		assertEquals(50.0, resultSet[3]);
		assertEquals(18.027756377319946, resultSet[4]);
		assertEquals(9.013878188659973, resultSet[5]);

		// sideB-circuit
		resultSet = geometryCalculator.calculateRectangle("sideB-circuit", paramValue1, paramValue2);
		assertEquals(15.0, resultSet[0]);
		assertEquals(10.0, resultSet[1]);
		assertEquals(150.0, resultSet[2]);
		assertEquals(50.0, resultSet[3]);
		assertEquals(18.027756377319946, resultSet[4]);
		assertEquals(9.013878188659973, resultSet[5]);

		// others
		resultSet = geometryCalculator.calculateRectangle("NameNo-NoName", paramValue1, paramValue2);
		assertEquals(0, resultSet[0]);
		assertEquals(0, resultSet[1]);
		assertEquals(0, resultSet[2]);
		assertEquals(0, resultSet[3]);
		assertEquals(0, resultSet[4]);
		assertEquals(0, resultSet[5]);

	}

}
