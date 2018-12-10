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


	@Override
	public double[] calculateSquare(String paramName, Double paramValue) {

		// 0 -sideA , 1-circuit , 2-field ,3-diameter ,4-radius
		double[] resultSet = new double[5];

		if (paramName.equals("squareSideA")) {
			resultSet[0] = paramValue;
			resultSet[1] = paramValue * 4;
			resultSet[2] = paramValue * paramValue;
			resultSet[3] = paramValue * Math.sqrt(2);
			resultSet[4] = resultSet[3] / 2;

		} else if (paramName.equals("squareCircuit")) {

			resultSet[0] = paramValue / 4;
			resultSet[1] = paramValue;
			resultSet[2] = resultSet[0] * resultSet[0];
			resultSet[3] = resultSet[0] * Math.sqrt(2);
			resultSet[4] = resultSet[3] / 2;

		} else if (paramName.equals("squareField")) {

			resultSet[2] = paramValue;
			resultSet[0] = Math.sqrt(resultSet[2]);
			resultSet[1] = resultSet[0] * 4;
			resultSet[3] = resultSet[0] * Math.sqrt(2);
			resultSet[4] = resultSet[3] / 2;

		} else if (paramName.equals("squareDiameter")) {

			resultSet[0] = (paramValue * Math.sqrt(2)) / 2;
			resultSet[1] = resultSet[0] * 4;
			resultSet[2] = resultSet[0] * resultSet[0];
			resultSet[3] = paramValue;
			resultSet[4] = resultSet[3] / 2;

		} else if (paramName.equals("squareRadius")) {

			resultSet[0] = ((paramValue * 2) * Math.sqrt(2)) / 2;
			resultSet[1] = resultSet[0] * 4;
			resultSet[2] = resultSet[0] * resultSet[0];
			resultSet[3] = paramValue * 2;
			resultSet[4] = paramValue;

		} else {
			for (int i = 0; i < resultSet.length; i++)
				resultSet[i] = 0;
		}

		return resultSet;
	}

	@Override
	public double[] calculateRectangle(String paramName, Double paramValue1, Double paramValue2) {

		// 0-sideA 1-sideB 2-field 3-circuit 4-diameter 5-radius
		double[] resultSet = new double[6];

		if (paramName.equals("sideA-sideB")) {
			resultSet[0] = paramValue1;
			resultSet[1] = paramValue2;
			resultSet[2] = resultSet[0] * resultSet[1];
			resultSet[3] = (2 * resultSet[0]) + (2 * resultSet[1]);
			resultSet[4] = Math.sqrt(Math.pow(resultSet[0], 2) + Math.pow(resultSet[1], 2));
			resultSet[5] = resultSet[4] / 2;

		} else if (paramName.equals("sideA-field")) {

			resultSet[0] = paramValue1;
			resultSet[1] = paramValue2 / paramValue1;
			resultSet[2] = paramValue2;
			resultSet[3] = (2 * resultSet[0]) + (2 * resultSet[1]);
			resultSet[4] = Math.sqrt(Math.pow(resultSet[0], 2) + Math.pow(resultSet[1], 2));
			resultSet[5] = resultSet[4] / 2;

		} else if (paramName.equals("sideB-field")) {

			resultSet[0] = paramValue2 / paramValue1;
			resultSet[1] = paramValue1;
			resultSet[2] = paramValue2;
			resultSet[3] = (2 * resultSet[0]) + (2 * resultSet[1]);
			resultSet[4] = Math.sqrt(Math.pow(resultSet[0], 2) + Math.pow(resultSet[1], 2));
			resultSet[5] = resultSet[4] / 2;

		} else if (paramName.equals("sideA-circuit")) {

			resultSet[0] = paramValue1;
			resultSet[1] = (paramValue2 - (2 * paramValue1)) / 2;
			resultSet[2] = resultSet[0] * resultSet[1];
			resultSet[3] = paramValue2;
			resultSet[4] = Math.sqrt(Math.pow(resultSet[0], 2) + Math.pow(resultSet[1], 2));
			resultSet[5] = resultSet[4] / 2;

		} else if (paramName.equals("sideB-circuit")) {

			resultSet[0] = (paramValue2 - (2 * paramValue1)) / 2;
			resultSet[1] = paramValue1;
			resultSet[2] = resultSet[0] * resultSet[1];
			resultSet[3] = paramValue2;
			resultSet[4] = Math.sqrt(Math.pow(resultSet[0], 2) + Math.pow(resultSet[1], 2));
			resultSet[5] = resultSet[4] / 2;

		} else {
			for (int i = 0; i < resultSet.length; i++)
				resultSet[i] = 0;
		}

		return resultSet;
	}

}
