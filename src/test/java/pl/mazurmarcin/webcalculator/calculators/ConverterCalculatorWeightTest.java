package pl.mazurmarcin.webcalculator.calculators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ConverterCalculatorWeightTest {

	// base unit for weight is kilogram
	private ConverterCalculatorImpl converterCalculatorImpl = new ConverterCalculatorImpl();

	String inputValue = "10";
	String expectedBasicUnitResult;
	BigDecimal inputValueBd = new BigDecimal(inputValue);
	
	BigDecimal[] expectedResultSet = new BigDecimal[12];
	
	@Test // "#weight-milligram"
	void shouldReturnResultSetForGivenInputIdCase1() {		
		
		expectedResultSet = converterCalculatorImpl.calculateWeight("#weight-milligram", inputValue);
		
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("0.0100000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("0.0010000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.000010"), expectedResultSet[3]);
		assertEquals(new BigDecimal("1.00E-8"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0.0003527396"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.0000220462"), expectedResultSet[6]);
		assertEquals(new BigDecimal("1.10E-8"), expectedResultSet[7]);
		assertEquals(new BigDecimal("9.8E-9"), expectedResultSet[8]);
		assertEquals(new BigDecimal("0.1543235835"), expectedResultSet[9]);
		assertEquals(new BigDecimal("1.000E-7"), expectedResultSet[10]);
		assertEquals(new BigDecimal("0.0500000000"), expectedResultSet[11]);
	}
	
	
	@Test // "#weight-gram"
	void shouldReturnResultSetForGivenInputIdCase2() {
		expectedResultSet = converterCalculatorImpl.calculateWeight("#weight-gram", inputValue);
		
		assertEquals(new BigDecimal("10000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("1.0000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.010"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0.0000100000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0.3527396211"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.0220462262"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0.0000110231"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0000098421"), expectedResultSet[8]);
		assertEquals(new BigDecimal("154.3235835294"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.0001000000"), expectedResultSet[10]);
		assertEquals(new BigDecimal("50.0000000000"), expectedResultSet[11]);
		
	}
	
	@Test // "#weight-dekagram"
	void shouldReturnResultSetForGivenInputIdCase3() {
		expectedResultSet = converterCalculatorImpl.calculateWeight("#weight-dekagram", inputValue);
		
		assertEquals(new BigDecimal("100000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("100.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.10"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0.0001000000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("3.5273962105"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.2204622622"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0.0001102311"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0000984207"), expectedResultSet[8]);
		assertEquals(new BigDecimal("1543.2358352941"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.0010000000"), expectedResultSet[10]);
		assertEquals(new BigDecimal("500.0000000000"), expectedResultSet[11]);
		
	}
	
	@Test // "#weight-kilogram"
	void shouldReturnResultSetForGivenInputIdCase4() {
		expectedResultSet = converterCalculatorImpl.calculateWeight("#weight-kilogram", inputValue);
		
		assertEquals(new BigDecimal("10000000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("10000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("1000.0000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("10"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0.0100000000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("352.7396210511"), expectedResultSet[5]);
		assertEquals(new BigDecimal("22.0462262185"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0.0110231131"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0098420653"), expectedResultSet[8]);
		assertEquals(new BigDecimal("154323.5835294143"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.1000000000"), expectedResultSet[10]);
		assertEquals(new BigDecimal("50000.0000000000"), expectedResultSet[11]);
		
	}
	
	@Test // "#weight-ton"
	void shouldReturnResultSetForGivenInputIdCase5() {
		expectedResultSet = converterCalculatorImpl.calculateWeight("#weight-ton", inputValue);
		
		assertEquals(new BigDecimal("10000000000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("10000000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("1000000.0000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("10000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("352739.6210511196"), expectedResultSet[5]);
		assertEquals(new BigDecimal("22046.2262184878"), expectedResultSet[6]);
		assertEquals(new BigDecimal("11.0231131092"), expectedResultSet[7]);
		assertEquals(new BigDecimal("9.8420652761"), expectedResultSet[8]);
		assertEquals(new BigDecimal("154323583.5294143065"), expectedResultSet[9]);
		assertEquals(new BigDecimal("100.0000000000"), expectedResultSet[10]);
		assertEquals(new BigDecimal("50000000.0000000000"), expectedResultSet[11]);
		
	}
	@Test // "#weight-ounce"
	void shouldReturnResultSetForGivenInputIdCase6() {
		expectedResultSet = converterCalculatorImpl.calculateWeight("#weight-ounce", inputValue);
		
		assertEquals(new BigDecimal("283495.2300000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("283.4952300000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("28.3495230000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.283495230"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0.0002834952"), expectedResultSet[4]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.6249999972"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0.0003125000"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0002790179"), expectedResultSet[8]);
		assertEquals(new BigDecimal("4374.9999807096"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.0028349523"), expectedResultSet[10]);
		assertEquals(new BigDecimal("1417.4761500000"), expectedResultSet[11]);
		
	}
	@Test // "#weight-#weight-pound"
	void shouldReturnResultSetForGivenInputIdCase7() {
		expectedResultSet = converterCalculatorImpl.calculateWeight("#weight-pound", inputValue);
		
		assertEquals(new BigDecimal("4535923.7000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("4535.9237000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("453.5923700000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("4.53592370"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0.0045359237"), expectedResultSet[4]);
		assertEquals(new BigDecimal("160.0000007055"), expectedResultSet[5]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0.0050000000"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0044642857"), expectedResultSet[8]);
		assertEquals(new BigDecimal("70000.0000000000"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.0453592370"), expectedResultSet[10]);
		assertEquals(new BigDecimal("22679.6185000000"), expectedResultSet[11]);
		
	}
	
	@Test // "#weight-short-ton"
	void shouldReturnResultSetForGivenInputIdCase8() {
		expectedResultSet = converterCalculatorImpl.calculateWeight("#weight-short-ton", inputValue);
		
		assertEquals(new BigDecimal("9071847400.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("9071847.4000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("907184.7400000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("9071.84740"), expectedResultSet[3]);
		assertEquals(new BigDecimal("9.0718474000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("320000.0014109585"), expectedResultSet[5]);
		assertEquals(new BigDecimal("20000.0000000000"), expectedResultSet[6]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[7]);
		assertEquals(new BigDecimal("8.9285714286"), expectedResultSet[8]);
		assertEquals(new BigDecimal("140000000.0000000000"), expectedResultSet[9]);
		assertEquals(new BigDecimal("90.7184740000"), expectedResultSet[10]);
		assertEquals(new BigDecimal("45359237.0000000000"), expectedResultSet[11]);
		
	}
	
	@Test // "#weight-long-ton"
	void shouldReturnResultSetForGivenInputIdCase9() {
		expectedResultSet = converterCalculatorImpl.calculateWeight("#weight-long-ton", inputValue);
		
		assertEquals(new BigDecimal("10160469088.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("10160469.0880000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("1016046.9088000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("10160.4690880"), expectedResultSet[3]);
		assertEquals(new BigDecimal("10.1604690880"), expectedResultSet[4]);
		assertEquals(new BigDecimal("358400.0015802735"), expectedResultSet[5]);
		assertEquals(new BigDecimal("22400.0000000000"), expectedResultSet[6]);
		assertEquals(new BigDecimal("11.2000000000"), expectedResultSet[7]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[8]);
		assertEquals(new BigDecimal("156800000.0000000000"), expectedResultSet[9]);
		assertEquals(new BigDecimal("101.6046908800"), expectedResultSet[10]);
		assertEquals(new BigDecimal("50802345.4400000000"), expectedResultSet[11]);
		
	}
	
	@Test // "#weight-grain"
	void shouldReturnResultSetForGivenInputIdCase10() {
		expectedResultSet = converterCalculatorImpl.calculateWeight("#weight-grain", inputValue);
		
		assertEquals(new BigDecimal("647.9891000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("0.6479891000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("0.0647989100"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.00064798910"), expectedResultSet[3]);
		assertEquals(new BigDecimal("6.480E-7"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0.0228571430"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.0014285714"), expectedResultSet[6]);
		assertEquals(new BigDecimal("7.143E-7"), expectedResultSet[7]);
		assertEquals(new BigDecimal("6.378E-7"), expectedResultSet[8]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.0000064799"), expectedResultSet[10]);
		assertEquals(new BigDecimal("3.2399455000"), expectedResultSet[11]);
	}
	
	@Test // "#weight-cental"
	void shouldReturnResultSetForGivenInputIdCase11() {
		expectedResultSet = converterCalculatorImpl.calculateWeight("#weight-cental", inputValue);
		
		assertEquals(new BigDecimal("1000000000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("1000000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("100000.0000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("1000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("1.0000000000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("35273.9621051120"), expectedResultSet[5]);
		assertEquals(new BigDecimal("2204.6226218488"), expectedResultSet[6]);
		assertEquals(new BigDecimal("1.1023113109"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.9842065276"), expectedResultSet[8]);
		assertEquals(new BigDecimal("15432358.3529414307"), expectedResultSet[9]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[10]);
		assertEquals(new BigDecimal("5000000.0000000000"), expectedResultSet[11]);
	}
	
	@Test // "#weight-carat"
	void shouldReturnResultSetForGivenInputIdCase12() {
		expectedResultSet = converterCalculatorImpl.calculateWeight("#weight-carat", inputValue);
		
		assertEquals(new BigDecimal("2000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("2.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("0.2000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.0020"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0.0000020000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0.0705479242"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.0044092452"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0.0000022046"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0000019684"), expectedResultSet[8]);
		assertEquals(new BigDecimal("30.8647167059"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.0000200000"), expectedResultSet[10]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[11]);
	}
	
	@Test // "#weight-noName"
	void shouldReturnResultSetForGivenInputIdCase13() {
		expectedResultSet = converterCalculatorImpl.calculateWeight("#weight-noName-NameNo", inputValue);
		
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


}
