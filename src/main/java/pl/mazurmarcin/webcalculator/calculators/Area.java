package pl.mazurmarcin.webcalculator.calculators;

public enum Area {
	
	SQUARE_MILLIMETER("millimeter","0.000001"),
	SQUARE_CENTIMETER("centimeter","0.0001"),
	SQUARE_DECIMETER("decymeter","0.01"),
	SQUARE_METER("area-meter","1"),
	SQUARE_KILOMETER("kilometer","1000000"),
	AR("area-ar","100"),
	HECTARE("hectare","10000"),
	SQUARE_INCH("inch","0.00064513460025"),
	SQUARE_FOOT("foot","0.09290304"),
	SQUARE_YARD("yard","0.83612736"),
	SQUARE_MILE("mile","2589881.10336"),
	ACRE("acre","4046.8564224");	
	
	private String description;
	private String value;

	Area(String description, String value) {
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
