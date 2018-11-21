package pl.mazurmarcin.webcalculator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mazurmarcin.webcalculator.dao.ContactFormMessageDao;
import pl.mazurmarcin.webcalculator.entity.ContactFormMessage;
import pl.mazurmarcin.webcalculator.utils.SearchEngineUtils;
import pl.mazurmarcin.webcalculator.utils.ServiceUtils;

@Service
public class ContactFormMessageServiceImpl implements ContactFormMessageService {

	private ContactFormMessageDao contactFormMessageDao;
	private SearchEngineUtils searchEngineUtils;
	private ServiceUtils serviceUtils;

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
		contactFormMessageDao.sendMessage(
				serviceUtils.createContactFormMessage(senderEmail, senderName, messageText, messageSubject));
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

		String hqlType = "from ContactFormMessage ";
		String hql = serviceUtils.prepareHqlDependsOnListType(hqlType, listType);

		return contactFormMessageDao.getContactFormMessages(hql, resultStartRange, resultRange);
	}

	@Override
	@Transactional
	public Long getTotalAmountOfContactFormMessagesList(String listType) {

		String hqlType = "SELECT COUNT(*) from ContactFormMessage ";
		String hql = serviceUtils.prepareHqlDependsOnListType(hqlType, listType);

		return contactFormMessageDao.getTotalAmountOfContactFormMessagesList(hql);
	}

	@Override
	@Transactional
	public void deleteContactFormMessage(long contactFormMessageId) {

		ContactFormMessage contactFormMessage = contactFormMessageDao.getContactFormMessage(contactFormMessageId);
		serviceUtils.changeIsActiveAndIsReadedStatus(contactFormMessage);

	}

	@Override
	@Transactional
	public void changeContactFormMessageReadStatus(long selectedCheckboxValue) {

		ContactFormMessage contactFormMessage = contactFormMessageDao.getContactFormMessage(selectedCheckboxValue);
		serviceUtils.changeIsReadedStatus(contactFormMessage);

	}

	@Override
	@Transactional
	public void changeContactFormMessageRepliedStatus(long selectedCheckboxValue) {

		ContactFormMessage contactFormMessage = contactFormMessageDao.getContactFormMessage(selectedCheckboxValue);
		serviceUtils.changeIsRepliedStatus(contactFormMessage);

	}

	@Override
	@Transactional
	public List<ContactFormMessage> getContactFormMessageSearchResult(String[] searchParameters, int startResult,
			Integer resultRange) {

		String searchType = "from ContactFormMessage where ";
		String[] fieldsName = { "senderName", "senderEmail", "messageSubject", "date", "listType" };
		String hql = searchEngineUtils.prepareHqlUsingContactFormMessageSearchParameters(searchParameters, searchType,
				fieldsName);

		return contactFormMessageDao.getContactFormMessages(hql, startResult, resultRange);
	}

	@Override
	@Transactional
	public long getContactFormMessageAmountOfSearchResult(String[] searchParameters) {

		String searchType = "SELECT COUNT(*) FROM ContactFormMessage where ";
		String[] fieldsName = { "senderName", "senderEmail", "messageSubject", "date", "listType" };
		String hql = searchEngineUtils.prepareHqlUsingContactFormMessageSearchParameters(searchParameters, searchType,
				fieldsName);

		return contactFormMessageDao.getContactFormMessageAmountOfSearchResult(hql);
	}

	@Override
	@Transactional
	public ContactFormMessage getContactFormMessage(Long contactFormMessageId) {
		return contactFormMessageDao.getContactFormMessage(contactFormMessageId);
	}

	@Override
	@Transactional
	public void setContactFormMessageReadStatusTrue(long selectedCheckboxValue) {

		ContactFormMessage contactFormMessage = contactFormMessageDao.getContactFormMessage(selectedCheckboxValue);
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

}
