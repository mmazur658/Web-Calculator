package pl.mazurmarcin.webcalculator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mazurmarcin.webcalculator.dao.ContactFormMessageDao;
import pl.mazurmarcin.webcalculator.entity.ContactFormMessage;
import pl.mazurmarcin.webcalculator.utils.SearchEngineUtils;
import pl.mazurmarcin.webcalculator.utils.ServiceUtils;

/**
 * Service class for managing contact form messages.
 * 
 * @author Marcin Mazur
 *
 */
@Service
public class ContactFormMessageServiceImpl implements ContactFormMessageService {

	/**
	 * The array containing the names of the message search parameters
	 */
	private final String[] NAMES_OF_CONTACT_FORM_MESSAGE_FIELDS = { "senderName", "senderEmail", "messageSubject", "date", "listType" };
	
	/**
	 * The ContactFormMessageDao interface
	 */
	private ContactFormMessageDao contactFormMessageDao;

	/**
	 * The SearchEngineUtils interface
	 */
	private SearchEngineUtils searchEngineUtils;

	/**
	 * The ServiceUtils interface
	 */
	private ServiceUtils serviceUtils;

	/**
	 * Constructs a ContactFormMessageServiceImpl with the ContactFormMessageDao,
	 * SearchEngineUtils and ServiceUtils.
	 * 
	 * @param contactFormMessageDao
	 *            The ContactFormMessageDao interface
	 * @param searchEngineUtils
	 *            The SearchEngineUtils interface
	 * @param serviceUtils
	 *            The ServiceUtils interface
	 */
	@Autowired
	public ContactFormMessageServiceImpl(ContactFormMessageDao contactFormMessageDao,
			SearchEngineUtils searchEngineUtils, ServiceUtils serviceUtils) {
		this.contactFormMessageDao = contactFormMessageDao;
		this.searchEngineUtils = searchEngineUtils;
		this.serviceUtils = serviceUtils;
	}

	@Override
	@Transactional
	public void sendMessage(String senderEmail, String senderName, String messageText, String messageSubject) {

		ContactFormMessage contactFormMessage = serviceUtils.createContactFormMessage(senderEmail, senderName,
				messageText, messageSubject);

		contactFormMessageDao.sendMessage(contactFormMessage);

	}

	@Override
	@Transactional
	public long getNumberOfUnreadContactFormMessage() {
		return contactFormMessageDao.getNumberOfUnreadContactFormMessage();
	}

	@Override
	@Transactional
	public List<ContactFormMessage> getContactFormMessages(String listType, Integer resultStartRange,
			Integer resultRange) {

		// Prepare the HQL Statement to be executed
		String hqlType = "from ContactFormMessage ";
		String hql = serviceUtils.prepareHqlDependsOnListType(hqlType, listType);

		return contactFormMessageDao.getContactFormMessages(hql, resultStartRange, resultRange);
	}

	@Override
	@Transactional
	public void deleteContactFormMessage(long contactFormMessageId) {

		ContactFormMessage contactFormMessage = contactFormMessageDao.getContactFormMessage(contactFormMessageId);
		serviceUtils.changeIsActiveAndIsReadedStatus(contactFormMessage); // change to false

	}

	@Override
	@Transactional
	public void changeContactFormMessageReadStatus(long contactFormMessageId) {

		ContactFormMessage contactFormMessage = contactFormMessageDao.getContactFormMessage(contactFormMessageId);
		serviceUtils.changeIsReadStatus(contactFormMessage);

	}

	@Override
	@Transactional
	public void changeContactFormMessageRepliedStatus(long contactFormMessageId) {

		ContactFormMessage contactFormMessage = contactFormMessageDao.getContactFormMessage(contactFormMessageId);
		serviceUtils.changeIsRepliedStatus(contactFormMessage);

	}

	@Override
	@Transactional
	public List<ContactFormMessage> getContactFormMessageSearchResult(String[] searchParameters, int startResult,
			Integer resultRange) {

		// Prepare the HQL Statement
		String searchType = "from ContactFormMessage where ";		
		String hql = searchEngineUtils.prepareHqlUsingContactFormMessageSearchParameters(searchParameters, searchType,
				NAMES_OF_CONTACT_FORM_MESSAGE_FIELDS);

		return contactFormMessageDao.getContactFormMessages(hql, startResult, resultRange);
	}

	@Override
	@Transactional
	public ContactFormMessage getContactFormMessage(Long contactFormMessageId) {
		return contactFormMessageDao.getContactFormMessage(contactFormMessageId);
	}

	@Override
	@Transactional
	public void setContactFormMessageReadStatusTrue(long contactFormMessageId) {

		ContactFormMessage contactFormMessage = contactFormMessageDao.getContactFormMessage(contactFormMessageId);
		contactFormMessage.setIsReaded(true);

	}

	@Override
	@Transactional
	public void addComment(long messageId, String commentText) {

		ContactFormMessage contactFormMessage = contactFormMessageDao.getContactFormMessage(messageId);
		contactFormMessageDao.addComment(serviceUtils.createComment(commentText, contactFormMessage));

	}

	@Override
	@Transactional
	public void deleteComment(long commentId) {
		contactFormMessageDao.deleteComment(commentId);

	}

	@Override
	public long getNumberOfAllContactFormMessages(String listType) {

		// Prepare the HQL Statement
		String hqlType = "SELECT COUNT(*) FROM ContactFormMessage ";
		String hql = serviceUtils.prepareHqlDependsOnListType(hqlType, listType);

		return contactFormMessageDao.getNumberOfAllContactFormMessages(hql);
	}

	@Override
	public long getNumberOfContactFormMessagesForGivenSearchParams(String[] searchParametersValue) {

		// Prepare the HQL Statement
		String searchType = "SELECT COUNT(*) FROM ContactFormMessage WHERE ";
		String hql = searchEngineUtils.prepareHqlUsingContactFormMessageSearchParameters(searchParametersValue, searchType,
				NAMES_OF_CONTACT_FORM_MESSAGE_FIELDS);
		
		return contactFormMessageDao.getNumberOfAllContactFormMessages(hql);
	}

}
