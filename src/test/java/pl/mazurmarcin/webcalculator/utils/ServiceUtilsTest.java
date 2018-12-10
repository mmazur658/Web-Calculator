package pl.mazurmarcin.webcalculator.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pl.mazurmarcin.webcalculator.entity.Comment;
import pl.mazurmarcin.webcalculator.entity.ContactFormMessage;

class ServiceUtilsTest {

	private ServiceUtilsImpl serviceUtilsImpl = new ServiceUtilsImpl();

	String senderEmail = "marcin@mazur.pl";
	String senderName = "Marcin Mazur";
	String messageText = "Test message text";
	String messageSubject = "Test message subject";

	@Test
	void shouldCreateContactFormMessage() {

		ContactFormMessage contactFormMessage = serviceUtilsImpl.createContactFormMessage(senderEmail, senderName,
				messageText, messageSubject);

		assertEquals(senderEmail, contactFormMessage.getSenderEmail());
		assertEquals(senderName, contactFormMessage.getSenderName());
		assertEquals(messageSubject, contactFormMessage.getMessageSubject());
		assertEquals(messageText, contactFormMessage.getMessageText());
		assertTrue(contactFormMessage.getIsActive());
		assertFalse(contactFormMessage.getIsReaded());
		assertFalse(contactFormMessage.getIsReplied());

		assertNotNull(contactFormMessage.getDate());
	}

	@Test
	void shouldPrepareHqlDependsOnListType() {

		// listType: new, archive, all

		String hqlType = "Form database ";
		String listType = "new";
		String hql = serviceUtilsImpl.prepareHqlDependsOnListType(hqlType, listType);
		assertEquals("Form database where isActive=true ORDER BY id DESC", hql);

		listType = "archive";
		hql = serviceUtilsImpl.prepareHqlDependsOnListType(hqlType, listType);
		assertEquals("Form database where isActive=false ORDER BY id DESC", hql);

		listType = "all";
		hql = serviceUtilsImpl.prepareHqlDependsOnListType(hqlType, listType);
		assertEquals("Form database ORDER BY id DESC", hql);

	}

	@Test
	void shouldChangeIsActiveAndIsReadedStatus() {

		ContactFormMessage contactFormMessage = serviceUtilsImpl.createContactFormMessage(senderEmail, senderName,
				messageText, messageSubject);

		assertTrue(contactFormMessage.getIsActive());
		assertFalse(contactFormMessage.getIsReaded());
		serviceUtilsImpl.changeIsActiveAndIsReadedStatus(contactFormMessage);
		assertFalse(contactFormMessage.getIsActive());
		assertTrue(contactFormMessage.getIsReaded());
		serviceUtilsImpl.changeIsActiveAndIsReadedStatus(contactFormMessage);
		assertTrue(contactFormMessage.getIsActive());
		assertTrue(contactFormMessage.getIsReaded());
	}

	@Test
	void shouldChangeIsRepliedStatus() {

		ContactFormMessage contactFormMessage = serviceUtilsImpl.createContactFormMessage(senderEmail, senderName,
				messageText, messageSubject);

		assertFalse(contactFormMessage.getIsReplied());
		serviceUtilsImpl.changeIsRepliedStatus(contactFormMessage);
		assertTrue(contactFormMessage.getIsReplied());
		serviceUtilsImpl.changeIsRepliedStatus(contactFormMessage);
		assertFalse(contactFormMessage.getIsReplied());

	}

	@Test
	void shouldCreateComment() {

		ContactFormMessage contactFormMessage = new ContactFormMessage();
		contactFormMessage.setId(50);
		String commentText = " Test Comment Text";
		Comment comment = serviceUtilsImpl.createComment(commentText, contactFormMessage);

		assertEquals(50, comment.getContactFormMessage().getId());
		assertEquals(commentText, comment.getCommentText());
		assertNotNull(comment.getDate());
	}

	@Test
	void shouldChangeIsReadedStatus() {

		ContactFormMessage contactFormMessage = serviceUtilsImpl.createContactFormMessage(senderEmail, senderName,
				messageText, messageSubject);

		assertFalse(contactFormMessage.getIsReaded());
		serviceUtilsImpl.changeIsReadStatus(contactFormMessage);
		assertTrue(contactFormMessage.getIsReaded());
		serviceUtilsImpl.changeIsReadStatus(contactFormMessage);
		assertFalse(contactFormMessage.getIsReaded());

	}

}
