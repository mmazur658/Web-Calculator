package pl.mazurmarcin.webcalculator.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.mazurmarcin.webcalculator.entity.CalculatorStat;

@Repository
public class ClaculatorStatDaoImpl implements ClaculatorStatDao {

	private EntityManager entityManager;

	@Autowired
	public ClaculatorStatDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveCalculatorStat(CalculatorStat calculatorStat) {

		String hql = "FROM CalculatorStat WHERE calcName=:calcName AND date=:date";
		Query<CalculatorStat> theQuery = (Query<CalculatorStat>) entityManager.createQuery(hql);
		theQuery.setParameter("calcName", calculatorStat.getCalcName());
		theQuery.setParameter("date", calculatorStat.getDate());

		CalculatorStat tempCalculatorStat = null;
		try {
			tempCalculatorStat = theQuery.getSingleResult();
		} catch (Exception e) {
		}

		if (tempCalculatorStat == null) {
			calculatorStat.setCounts(1);
			entityManager.persist(calculatorStat);
		} else
			tempCalculatorStat.setCounts(tempCalculatorStat.getCounts() + 1);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getTopXCalculatorStatsForGivenDateRange(String startDate, String endDate, long resultRange) {

		String hql = "SELECT calcName, SUM(counts) AS suma FROM CalculatorStat WHERE date BETWEEN '" + startDate
				+ "' AND '" + endDate + "' GROUP BY calcName ORDER BY suma DESC";

		Query<Object[]> theQuery = (Query<Object[]>) entityManager.createQuery(hql);

		if (resultRange != 999)
			theQuery.setMaxResults((int) resultRange);

		return theQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public long getAmountOfCalculatorsType() {

		String hql = "SELECT DISTINCT calcName FROM CalculatorStat";
		Query<CalculatorStat> theQuery = (Query<CalculatorStat>) entityManager.createQuery(hql);
		List<CalculatorStat> tempList = theQuery.getResultList();

		return tempList.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public long sumOfCalculationForGivenDateRange(String startDate, String endDate) {

		String hql = "SELECT SUM(counts) AS suma FROM CalculatorStat WHERE date BETWEEN '" + startDate + "' AND '"
				+ endDate + "'";
		Query<Object> theQuery = (Query<Object>) entityManager.createQuery(hql);
		List<Object> tempList = theQuery.getResultList();

		Object object = tempList.get(0);

		if (object == null)
			return 0;
		else
			return Long.parseLong(String.valueOf(object));

	}

	@SuppressWarnings("unchecked")
	@Override
	public String sumOfCalculationOfSelectedCalculatorForGivenDateRange(String startDate, String endDate,
			String calculatorName) {

		String hql = "SELECT SUM(counts) AS suma FROM CalculatorStat WHERE calcName=:calculatorName AND date BETWEEN '"
				+ startDate + "' AND '" + endDate + "'";

		Query<Object> theQuery = (Query<Object>) entityManager.createQuery(hql);
		theQuery.setParameter("calculatorName", calculatorName);
		List<Object> tempList = theQuery.getResultList();

		Object object = tempList.get(0);

		if (object == null)
			return "0";
		else
			return String.valueOf(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Date getCalculatorFirstUse(String calculatorName) {

		String hql = "SELECT date FROM CalculatorStat WHERE calcName=:calculatorName ORDER BY date ASC";
		Query<Date> theQuery = (Query<Date>) entityManager.createQuery(hql);
		theQuery.setParameter("calculatorName", calculatorName);
		List<Date> tempList = theQuery.getResultList();

		return tempList.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getSelectedCalculatorMonthlyData(String calculatorName, String startDate, String endDate) {

		String hql = "SELECT date, counts FROM CalculatorStat WHERE calcName=:calculatorName AND date BETWEEN '"
				+ startDate + "' AND '" + endDate + "' ORDER BY date ASC";

		Query<Object[]> theQuery = (Query<Object[]>) entityManager.createQuery(hql);
		theQuery.setParameter("calculatorName", calculatorName);
		List<Object[]> tempList = theQuery.getResultList();

		return tempList;
	}
}
