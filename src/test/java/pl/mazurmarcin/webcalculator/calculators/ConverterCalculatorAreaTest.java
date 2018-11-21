package pl.mazurmarcin.webcalculator.calculators;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

class ConverterCalculatorAreaTest {

	// base unit for Area is sqare meter
	
	private ConverterCalculatorImpl converterCalculatorImpl = new ConverterCalculatorImpl();

	String inputValue = "10";
	String expectedBasicUnitResult;
	BigDecimal inputValueBd = new BigDecimal(inputValue);
	
	BigDecimal[] expectedResultSet = new BigDecimal[12];
	
	@Test // "#area-noName"
	void shouldReturnResultSetForGivenInputIdCase1() {

		expectedResultSet = converterCalculatorImpl.calculateArea("#area-noName-nameNo", inputValue);

		assertEquals(new BigDecimal("0E-10"), expectedResultSet[0]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[1]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.00"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[8]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[10]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[11]);

	}
	
	@Test // "#area-millimeter"
	void shouldReturnResultSetForGivenInputIdCase2() {

		expectedResultSet = converterCalculatorImpl.calculateArea("#area-millimeter", inputValue);

		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("0.1000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("0.0010000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.000010"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0.0000000000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("1.000E-7"), expectedResultSet[5]);
		assertEquals(new BigDecimal("1.0E-9"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0.0155006413"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0001076391"), expectedResultSet[8]);
		assertEquals(new BigDecimal("0.0000119599"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.0000000000"), expectedResultSet[10]);
		assertEquals(new BigDecimal("2.5e-9"), expectedResultSet[11]);

	}
	
	@Test // "#area-centimeter"
	void shouldReturnResultSetForGivenInputIdCase3() {

		expectedResultSet = converterCalculatorImpl.calculateArea("#area-centimeter", inputValue);

		assertEquals(new BigDecimal("1000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("0.1000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.0010"), expectedResultSet[3]);
		assertEquals(new BigDecimal("1.0E-9"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0.0000100000"), expectedResultSet[5]);
		assertEquals(new BigDecimal("1.000e-7"), expectedResultSet[6]);
		assertEquals(new BigDecimal("1.5500641256"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0107639104"), expectedResultSet[8]);
		assertEquals(new BigDecimal("0.0011959900"), expectedResultSet[9]);
		assertEquals(new BigDecimal("4e-10"), expectedResultSet[10]);
		assertEquals(new BigDecimal("2.471e-7"), expectedResultSet[11]);

	}
	
	@Test // "#area-decymeter" 
	void shouldReturnResultSetForGivenInputIdCase4() {

		expectedResultSet = converterCalculatorImpl.calculateArea("#area-decymeter", inputValue);

		assertEquals(new BigDecimal("100000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("1000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.10"), expectedResultSet[3]);
		assertEquals(new BigDecimal("1.000E-7"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0.0010000000"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.0000100000"), expectedResultSet[6]);
		assertEquals(new BigDecimal("155.0064125552"), expectedResultSet[7]);
		assertEquals(new BigDecimal("1.0763910417"), expectedResultSet[8]);
		assertEquals(new BigDecimal("0.1195990046"), expectedResultSet[9]);
		assertEquals(new BigDecimal("3.86e-8"), expectedResultSet[10]);
		assertEquals(new BigDecimal("0.0000247105"), expectedResultSet[11]);

	}
	
	@Test // "#area-meter" 
	void shouldReturnResultSetForGivenInputIdCase5() {

		expectedResultSet = converterCalculatorImpl.calculateArea("#area-meter", inputValue);

		assertEquals(new BigDecimal("10000000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("100000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("1000.0000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("10"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0.0000100000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0.1000000000"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.0010000000"), expectedResultSet[6]);
		assertEquals(new BigDecimal("15500.6412555222"), expectedResultSet[7]);
		assertEquals(new BigDecimal("107.6391041671"), expectedResultSet[8]);
		assertEquals(new BigDecimal("11.9599004630"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.0000038612"), expectedResultSet[10]);
		assertEquals(new BigDecimal("0.0024710538"), expectedResultSet[11]);

	}
	
	@Test // "#area-kilometer" 
	void shouldReturnResultSetForGivenInputIdCase6() {

		expectedResultSet = converterCalculatorImpl.calculateArea("#area-kilometer", inputValue);

		assertEquals(new BigDecimal("10000000000000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("100000000000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("1000000000.0000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("10000000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("100000.0000000000"), expectedResultSet[5]);
		assertEquals(new BigDecimal("1000.0000000000"), expectedResultSet[6]);
		assertEquals(new BigDecimal("15500641255.5222424687"), expectedResultSet[7]);
		assertEquals(new BigDecimal("107639104.1670972231"), expectedResultSet[8]);
		assertEquals(new BigDecimal("11959900.4630108026"), expectedResultSet[9]);
		assertEquals(new BigDecimal("3.8611811125"), expectedResultSet[10]);
		assertEquals(new BigDecimal("2471.0538146717"), expectedResultSet[11]);

	}
	
	@Test // "#area-ar"
	void shouldReturnResultSetForGivenInputIdCase7() {

		expectedResultSet = converterCalculatorImpl.calculateArea("#area-ar", inputValue);

		assertEquals(new BigDecimal("1000000000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("10000000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("100000.0000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("1000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0.0010000000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.1000000000"), expectedResultSet[6]);
		assertEquals(new BigDecimal("1550064.1255522242"), expectedResultSet[7]);
		assertEquals(new BigDecimal("10763.9104167097"), expectedResultSet[8]);
		assertEquals(new BigDecimal("1195.9900463011"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.0003861181"), expectedResultSet[10]);
		assertEquals(new BigDecimal("0.2471053815"), expectedResultSet[11]);

	}
	
	@Test // "#area-hectare" 
	void shouldReturnResultSetForGivenInputIdCase8() {

		expectedResultSet = converterCalculatorImpl.calculateArea("#area-hectare", inputValue);

		assertEquals(new BigDecimal("100000000000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("1000000000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("10000000.0000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("100000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0.1000000000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("1000.0000000000"), expectedResultSet[5]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[6]);
		assertEquals(new BigDecimal("155006412.5552224247"), expectedResultSet[7]);
		assertEquals(new BigDecimal("1076391.0416709722"), expectedResultSet[8]);
		assertEquals(new BigDecimal("119599.0046301080"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.0386118111"), expectedResultSet[10]);
		assertEquals(new BigDecimal("24.7105381467"), expectedResultSet[11]);

	}
	
	@Test // "#area-inch" 
	void shouldReturnResultSetForGivenInputIdCase9() {

		expectedResultSet = converterCalculatorImpl.calculateArea("#area-inch", inputValue);

		assertEquals(new BigDecimal("6451.3460025000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("64.5134600250"), expectedResultSet[1]);
		assertEquals(new BigDecimal("0.6451346003"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.00645134600250"), expectedResultSet[3]);
		assertEquals(new BigDecimal("6.5e-9"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0.0000645135"), expectedResultSet[5]);
		assertEquals(new BigDecimal("6.451e-7"), expectedResultSet[6]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0694417104"), expectedResultSet[8]);
		assertEquals(new BigDecimal("0.0077157456"), expectedResultSet[9]);
		assertEquals(new BigDecimal("2.5e-9"), expectedResultSet[10]);
		assertEquals(new BigDecimal("0.0000015942"), expectedResultSet[11]);

	}
	
	@Test // "#area-foot" 
	void shouldReturnResultSetForGivenInputIdCase10() {

		expectedResultSet = converterCalculatorImpl.calculateArea("#area-foot", inputValue);

		assertEquals(new BigDecimal("929030.4000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("9290.3040000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("92.9030400000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.92903040"), expectedResultSet[3]);
		assertEquals(new BigDecimal("9.290E-7"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0.0092903040"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.0000929030"), expectedResultSet[6]);
		assertEquals(new BigDecimal("1440.0566945874"), expectedResultSet[7]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[8]);
		assertEquals(new BigDecimal("1.1111111111"), expectedResultSet[9]);
		assertEquals(new BigDecimal("3.587e-7"), expectedResultSet[10]);
		assertEquals(new BigDecimal("0.0002295684"), expectedResultSet[11]);

	}
	
	@Test // "#area-yard" 
	void shouldReturnResultSetForGivenInputIdCase11() {

		expectedResultSet = converterCalculatorImpl.calculateArea("#area-yard", inputValue);

		assertEquals(new BigDecimal("8361273.6000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("83612.7360000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("836.1273600000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("8.36127360"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0.0000083613"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0.0836127360"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.0008361274"), expectedResultSet[6]);
		assertEquals(new BigDecimal("12960.5102512869"), expectedResultSet[7]);
		assertEquals(new BigDecimal("90.0000000000"), expectedResultSet[8]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.0000032284"), expectedResultSet[10]);
		assertEquals(new BigDecimal("0.0020661157"), expectedResultSet[11]);

	}
	
	@Test // "#area-mile" 
	void shouldReturnResultSetForGivenInputIdCase12() {

		expectedResultSet = converterCalculatorImpl.calculateArea("#area-mile", inputValue);

		assertEquals(new BigDecimal("25898811033600.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("258988110336.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("2589881103.3600000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("25898811.03360"), expectedResultSet[3]);
		assertEquals(new BigDecimal("25.8988110336"), expectedResultSet[4]);
		assertEquals(new BigDecimal("258988.1103360000"), expectedResultSet[5]);
		assertEquals(new BigDecimal("2589.8811033600"), expectedResultSet[6]);
		assertEquals(new BigDecimal("40144817877.6394810177"), expectedResultSet[7]);
		assertEquals(new BigDecimal("278772481.8649637299"), expectedResultSet[8]);
		assertEquals(new BigDecimal("30974720.2072181922"), expectedResultSet[9]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[10]);
		assertEquals(new BigDecimal("6399.7355800038"), expectedResultSet[11]);

	}
	
	@Test // "#area-acre"
	void shouldReturnResultSetForGivenInputIdCase13() {

		expectedResultSet = converterCalculatorImpl.calculateArea("#area-acre", inputValue);

		assertEquals(new BigDecimal("40468564224.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("404685642.2400000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("4046856.4224000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("40468.5642240"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0.0404685642"), expectedResultSet[4]);
		assertEquals(new BigDecimal("404.6856422400"), expectedResultSet[5]);
		assertEquals(new BigDecimal("4.0468564224"), expectedResultSet[6]);
		assertEquals(new BigDecimal("62728869.6162285864"), expectedResultSet[7]);
		assertEquals(new BigDecimal("435600.0000000000"), expectedResultSet[8]);
		assertEquals(new BigDecimal("48400.0000000000"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.0156256456"), expectedResultSet[10]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[11]);

	}
}