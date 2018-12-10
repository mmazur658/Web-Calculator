package pl.mazurmarcin.webcalculator.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.mazurmarcin.webcalculator.entity.Comment;
import pl.mazurmarcin.webcalculator.entity.ContactFormMessage;

/**
 * Repository class for performing database operations on ContactFormMessage
 * objects.
 * 
 * @author Marcin Mazur
 *
 */
@Repository
public class ContactFormMessageDaoImpl implements ContactFormMessageDao {

	/**
	 * The EntityManager interface
	 */
	private EntityManager entityManager;

	/**
	 * Constructs a ContactFormMessageDaoImpl with the EntityManager
	 * 
	 * @param entityManager
	 *            The EntityManager
	 */
	@Autowired
	public ContactFormMessageDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void sendMessage(ContactFormMessage contactFormMessage) {
		entityManager.persist(contactFormMessage);
	}

	@SuppressWarnings("unchecked")
	@Override
	public long getNumberOfUnreadContactFormMessage() {

		String hql = "SELECT COUNT(*) from ContactFormMessage where isActive = true";
		Query<Long> query = (Query<Long>) entityManager.createQuery(hql);
		Long count = (Long) query.uniqueResult();

		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContactFormMessage> getContactFormMessages(String hql, Integer resultStartRange, Integer resultRange) {

		Query<ContactFormMessage> query = (Query<ContactFormMessage>) entityManager.createQuery(hql);
		query.setFirstResult(resultStartRange);
		query.setMaxResults(resultRange);
		List<ContactFormMessage> contactFormMessageList = query.getResultList();

		return contactFormMessageList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ContactFormMessage getContactFormMessage(Long contactFormMessageId) {

		String hql = "from ContactFormMessage where id=:contactFormMessageId";
		Query<ContactFormMessage> theQuery = (Query<ContactFormMessage>) entityManager.createQuery(hql);
		theQuery.setParameter("contactFormMessageId", contactFormMessageId);

		return theQuery.getSingleResult();
	}

	@Override
	public void addComment(Comment comment) {
		entityManager.persist(comment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteComment(long commentId) {

		String hql = "delete Comment where id=:commentId";
		Query<ContactFormMessage> theQuery = (Query<ContactFormMessage>) entityManager.createQuery(hql);
		theQuery.setParameter("commentId", commentId);
		theQuery.executeUpdate();

	}

}
