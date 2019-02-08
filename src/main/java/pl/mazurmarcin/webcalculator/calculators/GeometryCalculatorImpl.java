package pl.mazurmarcin.webcalculator.calculators;

import org.springframework.stereotype.Component;

/**
 * Utility class used to perform calculation for geometric calculator.
 * 
 * @author Marcin Mazur
 *
 */
@Component
public class GeometryCalculatorImpl implements GeometryCalculator {

	private final String SQUARE_SIDE_A = "squareSideA";
	private final String SQUARE_CIRCUIT = "squareCircuit";
	private final String SQUARE_FIELD = "squareField";
	private final String SQUARE_DIAMETER = "squareDiameter";
	private final String SQUARE_RADIUS = "squareRadius";

	private final String RECTANGLE_SIDES_A_B = "sideA-sideB";
	private final String RECTANGLE_SIDE_A_FIELD = "sideA-field";
	private final String RECTANGLE_SIDE_B_FIELD = "sideB-field";
	private final String RECTANGLE_SIDE_A_CIRCUIT = "sideA-circuit";
	private final String RECTANGLE_SIDE_B_CIRCUIT = "sideB-circuit";

	private double calcSquareSideA(String paramName, double paramValue) {

		switch (paramName) {
		case SQUARE_SIDE_A:
			return paramValue;
		case SQUARE_CIRCUIT:
			return paramValue / 4;
		case SQUARE_FIELD:
			return Math.sqrt(paramValue);
		case SQUARE_DIAMETER:
			return (paramValue * Math.sqrt(2)) / 2;
		case SQUARE_RADIUS:
			return ((paramValue * 2) * Math.sqrt(2)) / 2;
		default:
			return 0;
		}

	}

	private double[] calcRectangleSides(String paramName, Double paramValue1, Double paramValue2) {

		double[] sides = new double[2];

		switch (paramName) {
		case RECTANGLE_SIDES_A_B:
			sides[0] = paramValue1;
			sides[1] = paramValue2;
			break;
		case RECTANGLE_SIDE_A_FIELD:
			sides[0] = paramValue1;
			sides[1] = paramValue2 / paramValue1;
			break;
		case RECTANGLE_SIDE_B_FIELD:
			sides[0] = paramValue2 / paramValue1;
			sides[1] = paramValue1;
			break;
		case RECTANGLE_SIDE_A_CIRCUIT:
			sides[0] = paramValue1;
			sides[1] = (paramValue2 - (2 * paramValue1)) / 2;
			break;
		case RECTANGLE_SIDE_B_CIRCUIT:
			sides[0] = (paramValue2 - (2 * paramValue1)) / 2;
			sides[1] = paramValue1;
			break;
		default:
			sides[0] = 0;
			sides[1] = 0;
		}

		return sides;
	}

	// 0 -sideA , 1-circuit , 2-field ,3-diameter ,4-radius
	@Override
	public double[] calculateSquare(String paramName, Double paramValue) {

		double[] resultSet = new double[5];
		resultSet[0] = calcSquareSideA(paramName, paramValue);
		resultSet[1] = resultSet[0] * 4;
		resultSet[2] = resultSet[0] * resultSet[0];
		resultSet[3] = resultSet[0] * Math.sqrt(2);
		resultSet[4] = resultSet[3] / 2;

		return resultSet;
	}

	@Override
	public double[] calculateRectangle(String paramName, Double paramValue1, Double paramValue2) {

		// 0-sideA 1-sideB 2-field 3-circuit 4-diameter 5-radius
		double[] sides = calcRectangleSides(paramName, paramValue1, paramValue2);
		double[] resultSet = new double[6];

		resultSet[0] = sides[0];
		resultSet[1] = sides[1];
		resultSet[2] = resultSet[0] * resultSet[1];
		resultSet[3] = (2 * resultSet[0]) + (2 * resultSet[1]);
		resultSet[4] = Math.sqrt(Math.pow(resultSet[0], 2) + Math.pow(resultSet[1], 2));
		resultSet[5] = resultSet[4] / 2;

		return resultSet;
	}

}
