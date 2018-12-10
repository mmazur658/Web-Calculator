package pl.mazurmarcin.webcalculator.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a CalculatorStat record in the database
 * 
 * @author Marcin Mazur
 */
@Entity
@Table(name = "calc_stats")
public class CalculatorStat {

	/**
	 * Unique identification number
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	/**
	 * The name of the calculator
	 */
	@Column(name = "calc_name")
	private String calcName;

	/**
	 * The date of added 
	 */
	@Column(name = "date")
	private Date date;

	/**
	 * The number of calculator usage
	 */
	@Column(name = "counts")
	private long counts;

	/**
	 * Gets the unique identification number of the CalculatorStat
	 * 
	 * @return A long representing the unique identification number of the
	 *         CalculatorStat
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the unique identification number of the CalculatorStat
	 * 
	 * @param id
	 *            A long containing the unique identification number of the
	 *            CalculatorStat
	 */
	public void setId(long id) {
		this.id = id;
	}

	public String getCalcName() {
		return calcName;
	}

	/**
	 * Sets the name of the calculator of the CalculatorStat
	 * 
	 * @param calcName
	 *            A String containing the name of the calculator of the
	 *            CalculatorStat
	 */
	public void setCalcName(String calcName) {
		this.calcName = calcName;
	}

	/**
	 * Gets the date of added of the CalculatorStat
	 * 
	 * @return A Date representing the date of added of the CalculatorStat
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date of added of the CalculatorStat
	 * 
	 * @param date
	 *            A Date containing the date of added of the CalculatorStat
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the number of calculator usage of the CalculatorStat
	 * 
	 * @return A long representing the number of calculator usage of the
	 *         CalculatorStat
	 */
	public long getCounts() {
		return counts;
	}

	/**
	 * Sets the number of calculator usage of the CalculatorStat
	 * 
	 * @param counts
	 *            A long containing the number of calculator usage of the
	 *            CalculatorStat
	 */
	public void setCounts(long counts) {
		this.counts = counts;
	}

	/**
	 * Constructs a CalculatorStat object.
	 */
	public CalculatorStat() {

	}

	/**
	 * Constructs a CalculatorStat with the calculator name, date of added and
	 * number of counts.
	 * 
	 * @param calcName
	 *            The calculator name
	 * @param date
	 *            The date of added
	 * @param counts
	 *            The number of calculator usage
	 */
	public CalculatorStat(String calcName, Date date, long counts) {
		this.calcName = calcName;
		this.date = date;
		this.counts = counts;
	}

	/**
	 * Returns the String representation of the CalculatorStat object.
	 * 
	 * @return The String representation of the CalculatorStat object.
	 */
	@Override
	public String toString() {
		return "CalculatorStat [id=" + id + ", calcName=" + calcName + ", date=" + date + ", counts=" + counts + "]";
	}

}
