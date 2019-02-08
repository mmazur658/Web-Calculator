package pl.mazurmarcin.webcalculator.calculators;

public enum Weight {
	
	MILLIGRAM("milligram","0.000001"),
	GRAM("gram","0.001"),
	DEKAGRAM("dekagram","0.01"),
	KILOGRAM("kilogram","1"),
	TON("weight-ton","1000"),
	OUNCE("ounce","0.028349523"),
	POUND("pound","0.45359237"),
	SHORT_TON("short-ton","907.18474"),
	LONG_TON("long-ton","1016.0469088"),
	GRAIN("grain","0.00006479891"),
	CENTAL("cental","100"),
	CARAT("carat","0.0002");

	private String description;
	private String value;

	Weight(String description, String value) {
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
