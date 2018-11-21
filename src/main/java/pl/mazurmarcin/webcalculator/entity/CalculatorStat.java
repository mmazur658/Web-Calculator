package pl.mazurmarcin.webcalculator.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calc_stats")
public class CalculatorStat {

	/*
	 * The Entity private fields
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "calc_name")
	private String calcName;

	@Column(name = "date")
	private Date date;

	@Column(name = "counts")
	private long counts;

	/*
	 * Setters and getters methods
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCalcName() {
		return calcName;
	}

	public void setCalcName(String calcName) {
		this.calcName = calcName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getCounts() {
		return counts;
	}

	public void setCounts(long counts) {
		this.counts = counts;
	}

	/*
	 * Public methods
	 */
	public CalculatorStat() {

	}

	public CalculatorStat(String calcName, Date date, long counts) {
		this.calcName = calcName;
		this.date = date;
		this.counts = counts;
	}

}
