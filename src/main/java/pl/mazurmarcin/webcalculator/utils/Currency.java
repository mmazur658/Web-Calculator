package pl.mazurmarcin.webcalculator.utils;

/**
 * Represents a Currency object using to display data on the web page.
 * 
 * @author Marcin Mazur
 *
 */
public class Currency {

	/**
	 * The code of the currency
	 */
	private String code;

	/**
	 * The name of the currency
	 */
	private String currencyName;

	/**
	 * The current value of the currency
	 */
	private String mid;

	/**
	 * The previous value of the currency
	 */
	private String prevMid;

	/**
	 * The value of the change of the currency
	 */
	private String change;

	/**
	 * The percentage change of the currency
	 */
	private String percentageChange;

	/**
	 * The status of the currency. The status determines whether the value of the
	 * currency has increased or decreased.
	 */
	private String status;

	/**
	 * Gets the code of the Currency
	 * 
	 * @return A String representing the code of the Currency
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code of the Currency
	 * 
	 * @param code
	 *            A String containing the code of the Currency
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the name of the Currency
	 * 
	 * @return A String representing the name of the Currency
	 */
	public String getCurrencyName() {
		return currencyName;
	}

	/**
	 * Sets the name of the Currency
	 * 
	 * @param currencyName
	 *            A String containing the name of the Currency
	 */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	/**
	 * Gets the value of the Currency
	 * 
	 * @return A String representing the value of the Currency
	 */
	public String getMid() {
		return mid;
	}

	/**
	 * Sets the value of the Currency
	 * 
	 * @param mid
	 *            A String containing the value of the Currency
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}

	/**
	 * Gets the previous value of the Currency
	 * 
	 * @return A String representing the previous value of the Currency
	 */
	public String getPrevMid() {
		return prevMid;
	}

	/**
	 * Sets the previous value of the Currency
	 * 
	 * @param prevMid
	 *            A String containing the previous value of the Currency
	 */
	public void setPrevMid(String prevMid) {
		this.prevMid = prevMid;
	}

	/**
	 * Gets the status of the Currency
	 * 
	 * @return A String representing the status of the Currency
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status of the Currency
	 * 
	 * @param status
	 *            A String containing the status of the Currency
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the value of the change of the Currency
	 * 
	 * @return A String representing the value of the change of the Currency
	 */
	public String getChange() {
		return change;
	}

	/**
	 * Sets the value of the change of the Currency
	 * 
	 * @param change
	 *            A String containing the value of the change of the Currency
	 */
	public void setChange(String change) {
		this.change = change;
	}

	/**
	 * Gets the percentage change of the Currency
	 * 
	 * @return A String representing the percentage change of the Currency
	 */
	public String getPercentageChange() {
		return percentageChange;
	}

	/**
	 * Sets the percentage change of the XXXXX
	 * 
	 * @param percentageChange
	 *            A String containing the percentage change of the XXXXX
	 */
	public void setPercentageChange(String percentageChange) {
		this.percentageChange = percentageChange;
	}

	/**
	 * Constructs a Currency object
	 */
	public Currency() {

	}

	/**
	 * Constructs a Currency object with the code, name, value, previous value,
	 * value of the change, percentage value of the change and status.
	 * 
	 * @param code
	 *            The string containing the code of the Currency
	 * @param currencyName
	 *            The string containing the name of the Currency
	 * @param mid
	 *            The string containing the value of the Currency
	 * @param prevMid
	 *            The string containing the previous value of the Currency
	 * @param change
	 *            The string containing the value of the change of the Currency
	 * @param percentageChange
	 *            The string containing the percentage value of the change of the
	 *            Currency
	 * @param status
	 *            The string containing the status of the Currency
	 */
	public Currency(String code, String currencyName, String mid, String prevMid, String change,
			String percentageChange, String status) {
		this.code = code;
		this.currencyName = currencyName;
		this.mid = mid;
		this.prevMid = prevMid;
		this.change = change;
		this.percentageChange = percentageChange;
		this.status = status;
	}

	/**
	 * Constructs a Currency object with the code, name, value and previous value.
	 * 
	 * @param code
	 *            The string containing the code of the Currency
	 * @param currencyName
	 *            The string containing the name of the Currency
	 * @param mid
	 *            The string containing the value of the Currency
	 * @param prevMid
	 *            The string containing the previous value of the Currency
	 */
	public Currency(String code, String currencyName, String mid, String prevMid) {
		this.code = code;
		this.currencyName = currencyName;
		this.mid = mid;
		this.prevMid = prevMid;
	}

	/**
	 * Returns the String representation of the Currency object.
	 * 
	 * @return The String representation of the Currency object.
	 */
	@Override
	public String toString() {
		return "Currency [code=" + code + ", currencyName=" + currencyName + ", mid=" + mid + ", prevMid=" + prevMid
				+ ", change=" + change + ", percentageChange=" + percentageChange + ", status=" + status + "]";
	}

}
