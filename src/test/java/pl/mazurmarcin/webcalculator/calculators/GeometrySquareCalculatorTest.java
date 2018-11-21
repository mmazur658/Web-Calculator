package pl.mazurmarcin.webcalculator.calculators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GeometrySquareCalculatorTest {
		
	private GeometryCalculatorImpl geometryCalculator = new GeometryCalculatorImpl();
	
	double[] resultSet = new double[5];
	double paramValue = 10.0;
	
	// 0 -sideA , 1-circuit , 2-field ,3-diameter ,4-radius

	@Test	
	void shouldReturnResultSetForGivenParameterName() {	
		
		// "squareSideA"
		resultSet = geometryCalculator.calculateSquare("squareSideA", paramValue);
		assertEquals(10.0, resultSet[0]);
		assertEquals(40.0, resultSet[1]);
		assertEquals(100.0, resultSet[2]);
		assertEquals(14.142135623730951, resultSet[3]);
		assertEquals(7.0710678118654755, resultSet[4]);
		
		
		// "squareCircuit"
		resultSet = geometryCalculator.calculateSquare("squareCircuit", paramValue);
		assertEquals(2.5, resultSet[0]);
		assertEquals(10.0, resultSet[1]);
		assertEquals(6.25, resultSet[2]);
		assertEquals(3.5355339059327378, resultSet[3]);
		assertEquals(1.7677669529663689, resultSet[4]);		
		
		// "squareField"
		resultSet = geometryCalculator.calculateSquare("squareField", paramValue);
		assertEquals(10.0, resultSet[2]);
		assertEquals(3.1622776601683795, resultSet[0]);
		assertEquals(12.649110640673518, resultSet[1]);
		assertEquals(4.47213595499958, resultSet[3]);
		assertEquals(2.23606797749979, resultSet[4]);
		
		// "squareDiameter"
		resultSet = geometryCalculator.calculateSquare("squareDiameter", paramValue);
		assertEquals(7.0710678118654755, resultSet[0]);
		assertEquals(28.284271247461902, resultSet[1]);
		assertEquals(50.00000000000001, resultSet[2]);
		assertEquals(10.0, resultSet[3]);
		assertEquals(5.0, resultSet[4]);
			
		// "squareRadius"
		resultSet = geometryCalculator.calculateSquare("squareRadius", paramValue);
		assertEquals(14.142135623730951, resultSet[0]);
		assertEquals(56.568542494923804, resultSet[1]);
		assertEquals(200.00000000000003, resultSet[2]);
		assertEquals(20.0, resultSet[3]);
		assertEquals(10.0, resultSet[4]);
		
		// any ohter parameter name
		resultSet = geometryCalculator.calculateSquare("squareNoName", paramValue);
		assertEquals(0, resultSet[0]);
		assertEquals(0, resultSet[1]);
		assertEquals(0, resultSet[2]);
		assertEquals(0, resultSet[3]);
		assertEquals(0, resultSet[4]);
		
	}	
	
	
	

}
