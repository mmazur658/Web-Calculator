package pl.mazurmarcin.webcalculator.utils;

public class Currency {

	/*
	 * Private Fields
	 */
	private String code;
	private String currencyName;
	private String mid;
	private String prevMid;
	private String change;
	private String percentageChange;
	private String status;

	/*
	 * Getters and Setters methods
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPrevMid() {
		return prevMid;
	}

	public void setPrevMid(String prevMid) {
		this.prevMid = prevMid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getPercentageChange() {
		return percentageChange;
	}

	public void setPercentageChange(String percentageChange) {
		this.percentageChange = percentageChange;
	}

	/*
	 * Public methods
	 */
	public Currency() {

	}

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

	public Currency(String code, String currencyName, String mid, String prevMid) {
		this.code = code;
		this.currencyName = currencyName;
		this.mid = mid;
		this.prevMid = prevMid;
	}

	@Override
	public String toString() {
		return "Currency [code=" + code + ", currencyName=" + currencyName + ", mid=" + mid + ", prevMid=" + prevMid
				+ ", change=" + change + ", percentageChange=" + percentageChange + ", status=" + status + "]";
	}

}
