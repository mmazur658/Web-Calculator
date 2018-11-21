package pl.mazurmarcin.webcalculator.calculators;

import java.math.BigDecimal;

public interface ConverterCalculator {

	BigDecimal[] calculateLength(String inputId, String inputValue);

	BigDecimal[] calculateWeight(String inputId, String inputValue);

	BigDecimal[] calculateArea(String inputId, String inputValue);

}
