package pl.mazurmarcin.webcalculator.calculators;

public enum Length {

	PARSEC("parsec", "30857000000000000"), 
	LIGHT_YEAR("light-year", "9460600000000000"), 
	ASTRONOMICAL_UNIT("astronomical-unit","149597870700"), 
	NAUTICA_MILE("nautica-mile", "1852"), 
	YARD("yard", "0.9144"), 
	MILE("length-mile","1609.344"), 
	FOOT("foot", "0.3048"), 
	INCH("inch", "0.0254"), 
	KILOMETER("kilometer", "1000"), 
	METER("length-meter", "1"), 
	CENTIMETER("centimeter", "0.01"), 
	MILLIMETER("millimeter", "0.001");

	private String description;
	private String value;

	Length(String description, String value) {
		this.description = description;
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public String getValue() {
		return value;
	}

}
