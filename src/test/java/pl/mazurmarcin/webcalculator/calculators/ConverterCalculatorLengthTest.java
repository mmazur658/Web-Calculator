package pl.mazurmarcin.webcalculator.calculators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ConverterCalculatorLengthTest {

	private ConverterCalculatorImpl converterCalculatorImpl = new ConverterCalculatorImpl();

	String inputValue = "10";
	String expectedBasicUnitResult;
	BigDecimal inputValueBd = new BigDecimal(inputValue);

	BigDecimal[] expectedResultSet = new BigDecimal[12];

	@Test // "#length-noName"
	void shouldReturnResultSetForGivenInputIdCase1() {

		expectedResultSet = converterCalculatorImpl.calculateLength("#length-noName-nameNo", inputValue);

		assertEquals(new BigDecimal("0E-10"), expectedResultSet[0]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[1]);
		assertEquals(new BigDecimal("0.00"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0E-10"), expectedResultSet[8]);
		assertEquals(new BigDecimal("0E-30"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0E-30"), expectedResultSet[10]);
		assertEquals(new BigDecimal("0E-30"), expectedResultSet[11]);

	}

	@Test // "#length-millimeter"
	void shouldReturnResultSetForGivenInputIdCase2() {

		expectedResultSet = converterCalculatorImpl.calculateLength("#length-millimeter", inputValue);

		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("1.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("0.010"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.0000100000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("0.3937007874"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0.0328083990"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.0109361330"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0.0000062137"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0000053996"), expectedResultSet[8]);
		assertEquals(new BigDecimal("6.6845871222684455E-14"), expectedResultSet[9]);
		assertEquals(new BigDecimal("1.057015411285e-18"), expectedResultSet[10]);
		assertEquals(new BigDecimal("3.24075574424e-19"), expectedResultSet[11]);

	}

	@Test // "#length-centimeter"
	void shouldReturnResultSetForGivenInputIdCase3() {

		expectedResultSet = converterCalculatorImpl.calculateLength("#length-centimeter", inputValue);

		assertEquals(new BigDecimal("100.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("0.10"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.0001000000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("3.9370078740"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0.3280839895"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.1093613298"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0.0000621371"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0000539957"), expectedResultSet[8]);
		assertEquals(new BigDecimal("6.68458712226844550E-13"), expectedResultSet[9]);
		assertEquals(new BigDecimal("1.0570154112847e-17"), expectedResultSet[10]);
		assertEquals(new BigDecimal("3.240755744240E-18"), expectedResultSet[11]);
	}

	@Test // "#length-meter"
	void shouldReturnResultSetForGivenInputIdCase4() {

		expectedResultSet = converterCalculatorImpl.calculateLength("#length-meter", inputValue);

		assertEquals(new BigDecimal("10000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("1000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("10"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.0100000000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("393.7007874016"), expectedResultSet[4]);
		assertEquals(new BigDecimal("32.8083989501"), expectedResultSet[5]);
		assertEquals(new BigDecimal("10.9361329834"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0.0062137119"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0053995680"), expectedResultSet[8]);
		assertEquals(new BigDecimal("6.6845871222684454960E-11"), expectedResultSet[9]);
		assertEquals(new BigDecimal("1.057015411284697e-15"), expectedResultSet[10]);
		assertEquals(new BigDecimal("3.24075574423956e-16"), expectedResultSet[11]);
	}

	@Test // "#length-kilometer"
	void shouldReturnResultSetForGivenInputIdCase5() {

		expectedResultSet = converterCalculatorImpl.calculateLength("#length-kilometer", inputValue);

		assertEquals(new BigDecimal("10000000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("1000000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("10000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("393700.7874015748"), expectedResultSet[4]);
		assertEquals(new BigDecimal("32808.3989501312"), expectedResultSet[5]);
		assertEquals(new BigDecimal("10936.1329833771"), expectedResultSet[6]);
		assertEquals(new BigDecimal("6.2137119224"), expectedResultSet[7]);
		assertEquals(new BigDecimal("5.3995680346"), expectedResultSet[8]);
		assertEquals(new BigDecimal("6.6845871222684454959960E-8"), expectedResultSet[9]);
		assertEquals(new BigDecimal("1.057015411284696531E-12"), expectedResultSet[10]);
		assertEquals(new BigDecimal("3.24075574423955666E-13"), expectedResultSet[11]);
		
	}

	@Test // "#length-inch"
	void shouldReturnResultSetForGivenInputIdCase6() {

		expectedResultSet = converterCalculatorImpl.calculateLength("#length-inch", inputValue);

		assertEquals(new BigDecimal("254.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("25.4000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("0.2540"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.0002540000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("0.8333333333"), expectedResultSet[5]);
		assertEquals(new BigDecimal("0.2777777778"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0.0001578283"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0001371490"), expectedResultSet[8]);
		assertEquals(new BigDecimal("1.697885129056185156E-12"), expectedResultSet[9]);
		assertEquals(new BigDecimal("2.6848191446631e-17"), expectedResultSet[10]);
		assertEquals(new BigDecimal("8.231519590368e-18"), expectedResultSet[11]);
	}

	@Test // "#length-foot"
	void shouldReturnResultSetForGivenInputIdCase7() {

		expectedResultSet = converterCalculatorImpl.calculateLength("#length-foot", inputValue);

		assertEquals(new BigDecimal("3048.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("304.8000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("3.0480"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.0030480000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("120.0000000000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[5]);
		assertEquals(new BigDecimal("3.3333333333"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0.0018939394"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0016457883"), expectedResultSet[8]);
		assertEquals(new BigDecimal("2.0374621548674221872E-11"), expectedResultSet[9]);
		assertEquals(new BigDecimal("3.22178297359576e-16"), expectedResultSet[10]);
		assertEquals(new BigDecimal("9.8778235084422e-17"), expectedResultSet[11]);
	}

	@Test // "#length-yard"
	void shouldReturnResultSetForGivenInputIdCase8() {

		expectedResultSet = converterCalculatorImpl.calculateLength("#length-yard", inputValue);

		assertEquals(new BigDecimal("9144.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("914.4000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("9.1440"), expectedResultSet[2]);
		assertEquals(new BigDecimal("0.0091440000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("360.0000000000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("30.0000000000"), expectedResultSet[5]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[6]);
		assertEquals(new BigDecimal("0.0056818182"), expectedResultSet[7]);
		assertEquals(new BigDecimal("0.0049373650"), expectedResultSet[8]);
		assertEquals(new BigDecimal("6.1123864646022665615E-11"), expectedResultSet[9]);
		assertEquals(new BigDecimal("9.66534892078727e-16"), expectedResultSet[10]);
		assertEquals(new BigDecimal("2.96334705253265e-16"), expectedResultSet[11]);
	} 

	@Test // "#length-mile"
	void shouldReturnResultSetForGivenInputIdCase9() {

		expectedResultSet = converterCalculatorImpl.calculateLength("#length-mile", inputValue);

		assertEquals(new BigDecimal("16093440.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("1609344.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("16093.440"), expectedResultSet[2]);
		assertEquals(new BigDecimal("16.0934400000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("633600.0000000000"), expectedResultSet[4]);
		assertEquals(new BigDecimal("52800.0000000000"), expectedResultSet[5]);
		assertEquals(new BigDecimal("17600.0000000000"), expectedResultSet[6]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[7]);
		assertEquals(new BigDecimal("8.6897624190"), expectedResultSet[8]);
		assertEquals(new BigDecimal("1.07578001776999891483081E-7"), expectedResultSet[9]);
		assertEquals(new BigDecimal("1.701101410058558654E-12"), expectedResultSet[10]);
		assertEquals(new BigDecimal("5.21549081245746508E-13"), expectedResultSet[11]);
	}

	@Test // "#length-nautica-mile"
	void shouldReturnResultSetForGivenInputIdCase10() {

		expectedResultSet = converterCalculatorImpl.calculateLength("#length-nautica-mile", inputValue);

		assertEquals(new BigDecimal("18520000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("1852000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("18520"), expectedResultSet[2]);
		assertEquals(new BigDecimal("18.5200000000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("729133.8582677165"), expectedResultSet[4]);
		assertEquals(new BigDecimal("60761.1548556430"), expectedResultSet[5]);
		assertEquals(new BigDecimal("20253.7182852143"), expectedResultSet[6]);
		assertEquals(new BigDecimal("11.5077944802"), expectedResultSet[7]);
		assertEquals(new BigDecimal("10.0000000000"), expectedResultSet[8]);
		assertEquals(new BigDecimal("1.23798553504411610585845E-7"), expectedResultSet[9]);
		assertEquals(new BigDecimal("1.957592541699257975E-12"), expectedResultSet[10]);
		assertEquals(new BigDecimal("6.00187963833165894E-13"), expectedResultSet[11]);
	}

	@Test // "#length-astronomical-unit"
	void shouldReturnResultSetForGivenInputIdCase11() {

		expectedResultSet = converterCalculatorImpl.calculateLength("#length-astronomical-unit", inputValue);

		assertEquals(new BigDecimal("1495978707000000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("149597870700000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("1495978707000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("1495978707.0000000000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("58896799488188.9763779528"), expectedResultSet[4]);
		assertEquals(new BigDecimal("4908066624015.7480314961"), expectedResultSet[5]);
		assertEquals(new BigDecimal("1636022208005.2493438320"), expectedResultSet[6]);
		assertEquals(new BigDecimal("929558072.7302553090"), expectedResultSet[7]);
		assertEquals(new BigDecimal("807763880.6695464363"), expectedResultSet[8]);
		assertEquals(new BigDecimal("10.000000000000000000000000000000"), expectedResultSet[9]);
		assertEquals(new BigDecimal("0.000158127254825275352514639663"), expectedResultSet[10]);
		assertEquals(new BigDecimal("0.000048481015879703146773827657"), expectedResultSet[11]);
	}

	@Test // "#length-light-year"
	void shouldReturnResultSetForGivenInputIdCase12() {

		expectedResultSet = converterCalculatorImpl.calculateLength("#length-light-year", inputValue);

		assertEquals(new BigDecimal("94606000000000000000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("9460600000000000000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("94606000000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("94606000000000.0000000000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("3724645669291338582.6771653543"), expectedResultSet[4]);
		assertEquals(new BigDecimal("310387139107611548.5564304462"), expectedResultSet[5]);
		assertEquals(new BigDecimal("103462379702537182.8521434821"), expectedResultSet[6]);
		assertEquals(new BigDecimal("58785443012805.2175296270"), expectedResultSet[7]);
		assertEquals(new BigDecimal("51083153347732.1814254860"), expectedResultSet[8]);
		assertEquals(new BigDecimal("632402.049289328554594193164542147457"), expectedResultSet[9]);
		assertEquals(new BigDecimal("10.000000000000000000000000000000"), expectedResultSet[10]);
		assertEquals(new BigDecimal("3.065949379395274978124898726383"), expectedResultSet[11]);
	}

	@Test // "#length-parsec"
	void shouldReturnResultSetForGivenInputIdCase13() {

		expectedResultSet = converterCalculatorImpl.calculateLength("#length-parsec", inputValue);

		assertEquals(new BigDecimal("308570000000000000000.0000000000"), expectedResultSet[0]);
		assertEquals(new BigDecimal("30857000000000000000.0000000000"), expectedResultSet[1]);
		assertEquals(new BigDecimal("308570000000000000"), expectedResultSet[2]);
		assertEquals(new BigDecimal("308570000000000.0000000000"), expectedResultSet[3]);
		assertEquals(new BigDecimal("12148425196850393700.7874015748"), expectedResultSet[4]);
		assertEquals(new BigDecimal("1012368766404199475.0656167979"), expectedResultSet[5]);
		assertEquals(new BigDecimal("337456255468066491.6885389326"), expectedResultSet[6]);
		assertEquals(new BigDecimal("191736508788674.1430048517"), expectedResultSet[7]);
		assertEquals(new BigDecimal("166614470842332.6133909287"), expectedResultSet[8]);
		assertEquals(new BigDecimal("2062663.048318374226699471331445896041"), expectedResultSet[9]);
		assertEquals(new BigDecimal("32.616324546011880853222839989007"), expectedResultSet[10]);
		assertEquals(new BigDecimal("10.000000000000000000000000000000"), expectedResultSet[11]);
	}

}
